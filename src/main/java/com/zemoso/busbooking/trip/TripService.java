package com.zemoso.busbooking.trip;

import java.util.Date;
import java.util.List;

public interface TripService {
    Trip findTrip(Integer tripId);

    Trip addTrip(Trip trip);

    List<Trip> findTrips(Integer from, Integer to,Date departure);
}
