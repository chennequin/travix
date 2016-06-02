package com.travix.service.helper;

import com.travix.beans.BusyFlightsResult;
import com.travix.beans.CrazyAirResult;
import com.travix.beans.ToughJetResult;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * This class converts responses of the two API.
 *
 * Created by christophe on 02/06/2016.
 */
public class ResultConverter {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
            .withZone(ZoneOffset.UTC);

    public static String toISO8601(final LocalDateTime dateTime) {
        return dateTime.format(formatter);
    }

    /**
     * convert a CrazyAirResult.
     *
     * @param cr a CrazyAirResult
     * @return the associated BusyFlightsResult
     */
    public static BusyFlightsResult toBusyFlightsResult(final CrazyAirResult cr) {

        final BusyFlightsResult br = new BusyFlightsResult();

        br.setAirline(cr.getAirline());
        br.setSupplier("CrazyAir");
        br.setFare(new BigDecimal(cr.getPrice()));
        br.setDepartureAirportCode(cr.getDepartureAirportCode());
        br.setDestinationAirportCode(cr.getDestinationAirportCode());

        br.setDepartureDate(toISO8601(CrazyAirResult.getLocalDateTime(cr.getDepartureDate())));
        br.setArrivalDate(toISO8601(CrazyAirResult.getLocalDateTime(cr.getArrivalDate())));

        return br;
    }

    /**
     * converts a ToughJetResult.
     *
     * @param tr a ToughJetResult
     * @return the associated BusyFlightsResult
     */
    public static BusyFlightsResult toBusyFlightsResult(final ToughJetResult tr) {

        final BusyFlightsResult br = new BusyFlightsResult();

        br.setAirline(tr.getCarrier());
        br.setSupplier("ToughJet");
        br.setFare(tr.getBasePrice().add(tr.getTax()).subtract(tr.getDiscount()));
        br.setDepartureAirportCode(tr.getDepartureAirportName());
        br.setDestinationAirportCode(tr.getArrivalAirportName());

        // TODO: to specify more, eventually use Optional
        br.setDepartureDate(null);
        br.setArrivalDate(null);

        return br;
    }
}
