package com.zemoso.busbooking.route;


import com.zemoso.busbooking.destination.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route,Integer> {
    List<Route> findAllByDeleted(Boolean deleted);

    Route findAllByIdAndDeleted(Integer routeId, boolean b);

    boolean existsByDestinationAndDestination1(Destination destination, Destination destination1);
}
