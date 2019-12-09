package com.zemoso.busbooking.trip;

import com.zemoso.busbooking.busdetails.BusDetails;
import com.zemoso.busbooking.route.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip,Integer> {
    Trip getOneByIdAndDeleted(Integer tripId, boolean b);


    boolean existsByBusDetailsAndRouteAndDeparture(BusDetails busDetails, Route route, Date departure);

    @Query("SELECT t FROM Trip t JOIN Route r ON t.route.id=r.id JOIN Destination d ON r.destination.id=d.id JOIN Destination d1 ON r.destination1.id=d1.id WHERE d.id=?1 AND d1.id=?2 AND t.departure>=?3 AND ?4>t.departure")
    List<Trip> findAllBySourceAndDestinationAndDate(Integer from, Integer to,Date departure,Date date);
}
