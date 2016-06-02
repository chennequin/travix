package com.travix.beans;

import org.springframework.util.Assert;

/**
 * This class represents a CrazyFlights request.
 */
public class BusyFlightsRequest {

    private String origin;
    private String destination;

    private String departureDate;
    private String returnDate;

    private int numberOfPassengers;

    public BusyFlightsRequest() {
    }

    /**
     * Constructor.
     *
     * @param origin
     * @param destination
     * @param departureDate
     * @param returnDate
     * @param numberOfPassengers
     */
    public BusyFlightsRequest(String origin, String destination, String departureDate, String returnDate, String numberOfPassengers) {

        Assert.isTrue(origin.length() == 3, "must be 3 letter IATA code(eg. LHR, AMS)");
        Assert.isTrue(destination.length() == 3, "must be 3 letter IATA code(eg. LHR, AMS)");

        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.numberOfPassengers = Integer.parseInt(numberOfPassengers);
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }
}
