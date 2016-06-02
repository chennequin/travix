package com.travix.function;

import com.travix.beans.BusyFlightsResult;
import com.travix.beans.CrazyAirResult;

/**
 * Represents a function that transform a CrazyAir result into a BusyFlight result.
 * <p>
 * Created by christophe on 02/06/2016.
 */
public interface CrazyAirToBusyFlightsResult {

    BusyFlightsResult applyAsBusyFlightsResult(CrazyAirResult r);
}
