package com.travix.function;

import com.travix.beans.BusyFlightsResult;
import com.travix.beans.ToughJetResult;

/**
 * Represents a function that transform a ToughJet result into a BusyFlights result.
 *
 * Created by christophe on 02/06/2016.
 */
@FunctionalInterface
public interface ToughJetToBusyFlightsResult {

    BusyFlightsResult apply(ToughJetResult r);
}
