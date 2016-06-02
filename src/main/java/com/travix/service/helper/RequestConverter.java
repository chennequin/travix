package com.travix.service.helper;

import com.travix.beans.BusyFlightsRequest;
import com.travix.beans.CrazyAirRequest;
import com.travix.beans.ToughJetRequest;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * This class converts requests.
 *
 * Created by christophe on 02/06/2016.
 */
public class RequestConverter {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
            .withZone(ZoneOffset.UTC);

    public static LocalDateTime fromISO8601(final String iso) {
        return LocalDateTime.parse(iso, formatter);
    }

    /**
     * Convert a BusyFlightsRequest to a CrazyAirRequest.
     *
     * @param r a BusyFlightsRequest
     * @return the associated CrazyAirRequest
     */
    public static CrazyAirRequest toCrazyAirRequest(final BusyFlightsRequest r) {

        return new CrazyAirRequest(
                r.getOrigin(), r.getDestination(),
                fromISO8601(r.getDepartureDate()), fromISO8601(r.getReturnDate()),
                r.getNumberOfPassengers());
    }

    /**
     * Default implementation.
     *
     * @param r a BusyFlightsRequest
     * @return the associated ToughJetRequest
     */
    public static ToughJetRequest toThoughJetRequest(final BusyFlightsRequest r) {

        //TODO: check/write test that numberOfAdults maps exactly to numberOfPassengers

        return new ToughJetRequest(
                r.getOrigin(), r.getDestination(),
                fromISO8601(r.getDepartureDate()), fromISO8601(r.getReturnDate()),
                r.getNumberOfPassengers());
    }
}
