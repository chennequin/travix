package com.travix.beans;

import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class represents a CrazyAir request.
 */
public class CrazyAirRequest {

    private String origin;
    private String destination;

    private String departureDate;
    private String returnDate;

    private int numberOfPassengers;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

    public CrazyAirRequest() {
    }

    public CrazyAirRequest(String origin, String destination, LocalDateTime departureDate, LocalDateTime returnDate, int numberOfPassengers) {

        Assert.isTrue(origin.length() == 3, "must be 3 letter IATA code(eg. LHR, AMS)");
        Assert.isTrue(destination.length() == 3, "must be 3 letter IATA code(eg. LHR, AMS)");

        this.origin = origin;
        this.destination = destination;
        this.departureDate = formatter.format(departureDate);
        this.returnDate = formatter.format(returnDate);
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
}
