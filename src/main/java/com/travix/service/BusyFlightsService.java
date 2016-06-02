package com.travix.service;

import com.travix.beans.BusyFlightsRequest;
import com.travix.beans.BusyFlightsResult;

import java.util.List;

/**
 * Created by christophe on 01/06/2016.
 */
public interface BusyFlightsService {

    List<BusyFlightsResult> search(BusyFlightsRequest request);
}
