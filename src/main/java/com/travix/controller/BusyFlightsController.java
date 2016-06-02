package com.travix.controller;

import com.travix.beans.*;
import com.travix.service.BusyFlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * The BusyFlight controller that provides search requests.
 * <p>
 * Created by christophe on 01/06/2016.
 */
@RestController
public class BusyFlightsController {

    @Autowired
    private BusyFlightsService service;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public List<BusyFlightsResult> search(@RequestBody final BusyFlightsRequest request) {

        return service.search(
                new BusyFlightsRequest("LHR", "LHR", "2011-12-03T10:15:30Z", "2011-12-03T10:15:30Z", "2"));
    }

    @RequestMapping(value = "/crazyAir/search", method = RequestMethod.POST)
    @ResponseBody
    public List<CrazyAirResult> searchCrazyAir(@RequestBody final CrazyAirRequest request) {

        final List<CrazyAirResult> list = new ArrayList<>();

        list.add(new CrazyAirResult("airfrance", "123.45", "E", "LHR", "AMS", "01-02-2016 21:34:00", "02-03-2016 22:45:00"));
        list.add(new CrazyAirResult("airmaroc", "256.98", "E", "LHR", "AMS", "04-03-2016 21:34:00", "05-03-2016 22:45:00"));

        return list;
    }

    @RequestMapping(value = "/toughJet/search", method = RequestMethod.POST)
    @ResponseBody
    public List<ToughJetResult> searchToughJet(@RequestBody final ToughJetRequest request) {

        final List<ToughJetResult> list = new ArrayList<>();

        list.add(new ToughJetResult("airuk", BigDecimal.valueOf(234.56), BigDecimal.valueOf(20), BigDecimal.TEN, "LHR", "AMS"));

        return list;
    }
}
