package com.travix.beans;

import java.math.BigDecimal;

/**
 * This class represents a CrazyFlights single result.
 */
public class BusyFlightsResult implements Comparable<BusyFlightsResult> {

    private String airline;
    private String supplier;

    /*
        I would consider the money pattern for further improvements:
        http://martinfowler.com/eaaCatalog/money.html
     */
    private BigDecimal fare;

    private String departureAirportCode;
    private String destinationAirportCode;

    private String departureDate;
    private String arrivalDate;

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public BigDecimal getFare() {
        return fare;
    }

    public void setFare(BigDecimal fare) {
        this.fare = fare;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }



    @Override
    public int compareTo(BusyFlightsResult o) {
        return this.fare.compareTo(o.fare);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BusyFlightsResult that = (BusyFlightsResult) o;

        if (!airline.equals(that.airline)) return false;
        if (!supplier.equals(that.supplier)) return false;
        if (!fare.equals(that.fare)) return false;
        if (!departureAirportCode.equals(that.departureAirportCode)) return false;
        if (!destinationAirportCode.equals(that.destinationAirportCode)) return false;
        if (!departureDate.equals(that.departureDate)) return false;
        return arrivalDate.equals(that.arrivalDate);

    }

    @Override
    public int hashCode() {
        int result = airline.hashCode();
        result = 31 * result + supplier.hashCode();
        result = 31 * result + fare.hashCode();
        result = 31 * result + departureAirportCode.hashCode();
        result = 31 * result + destinationAirportCode.hashCode();
        result = 31 * result + departureDate.hashCode();
        result = 31 * result + arrivalDate.hashCode();
        return result;
    }
}
