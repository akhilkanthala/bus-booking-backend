package com.zemoso.busbooking.route;

import com.zemoso.busbooking.destination.Destination;
import com.zemoso.busbooking.destination.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RouteController {
    @Autowired
    private RouteService routeService;

    @Autowired
    private DestinationRepository destinationRepository;

    @GetMapping(value = "/route/{RouteId}")
    public ResponseEntity<Route> findRoute(@PathVariable Integer RouteId) {
        return new ResponseEntity<>(routeService.findRoute(RouteId), HttpStatus.OK);
    }
    @PostMapping(value = "/route")
    public ResponseEntity<Route> addRoute(@RequestBody final Route route,@RequestParam("destinationId") Integer destinationId,@RequestParam("destinationId1") Integer destinationId1) {
        if (destinationRepository.existsById(destinationId)) {
//            System.out.println(destinationId);
            route.setDestination(new Destination(destinationId));
//            System.out.println(route.getDestination().getId());
            if (destinationRepository.existsById(destinationId1)) {
                route.setDestination1(new Destination(destinationId1));
                return new ResponseEntity<>(routeService.addRoute(route), HttpStatus.CREATED);
            }
        }
            return null;
    }
}
