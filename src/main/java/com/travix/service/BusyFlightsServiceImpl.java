package com.travix.service;

import com.travix.beans.*;
import com.travix.service.helper.RequestConverter;
import com.travix.service.helper.ResultConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Implementation for the BusyFlights service.
 */
@Service
public class BusyFlightsServiceImpl implements BusyFlightsService {

    private static final Logger log = LoggerFactory.getLogger(BusyFlightsServiceImpl.class);

    private static final String CRAZY_AIR_URL = "http://localhost:8080/crazyAir/search";
    private static final String TOUGH_JET_URL = "http://localhost:8080/toughJet/search";

    public <T> T fetch(final String url, final Object request, final Class<T> responseType) {

        final Map<String, String> vars = new HashMap<>();
        final RestTemplate restTemplate = new RestTemplate();

        final T forNow = restTemplate.postForObject(url, request, responseType, vars);

        //TODO: use spring-aop around this method to log instead (with underlying aspectj)
        // this point may be further discussed
        // (from specifications: "This should preferably be done using AspectJ.")

        if (log.isDebugEnabled()) {
            log.debug(forNow.toString());
        }

        return forNow;
    }

    public List<BusyFlightsResult> merge(final List<CrazyAirResult> r1, final List<ToughJetResult> r2) {

        //TODO: implements merging here

        return null;
    }

    public List<BusyFlightsResult> sort(final List<BusyFlightsResult> list) {

        //TODO: implements sort here

        return list;
    }

    @Override
    public List<BusyFlightsResult> search(BusyFlightsRequest request) {

        final CrazyAirRequest crazyAirRequest = RequestConverter.toCrazyAirRequest(request);
        final ToughJetRequest toughJetRequest = RequestConverter.toThoughJetRequest(request);

        // the ideal algorithm here would send two HTTP requests in parallel
        // still not blocking a tomcat thread while io waiting for the two answers.
        // that would improve the vertical scalability of the solution
        // (next limits in that case would probably be :
        //      memory usage, number of tcp local ports available)

        // for pragmatic reasons, and in order to meet the deadline (2/3 hours)
        // I choose the synchronous way

        final CrazyAirResult[] crazyAirResults = fetch(CRAZY_AIR_URL, crazyAirRequest, CrazyAirResult[].class);
        final ToughJetResult[] toughJetResults = fetch(TOUGH_JET_URL, toughJetRequest, ToughJetResult[].class);

        // it is probably useless to do parallel stream here
        // we would have to choose a suitable collection with direct access
        // and this would benefit only to huge collections
        // which we probably don't want in the API.
        // we would provide pagination instead.

        final List<BusyFlightsResult> r1 = Arrays.stream(crazyAirResults)
                .map(ResultConverter::toBusyFlightsResult)
                .collect(Collectors.toList());

        final List<BusyFlightsResult> r2 = Arrays.stream(toughJetResults)
                .map(ResultConverter::toBusyFlightsResult)
                .collect(Collectors.toList());

        r1.addAll(r2);

        Collections.sort(r1);

        return r1;
    }
}
