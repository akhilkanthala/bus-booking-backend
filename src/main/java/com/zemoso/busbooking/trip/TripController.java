package com.zemoso.busbooking.trip;

import com.zemoso.busbooking.busdetails.BusDetails;
import com.zemoso.busbooking.busdetails.BusDetailsRepository;
import com.zemoso.busbooking.route.Route;
import com.zemoso.busbooking.route.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TripController {
    @Autowired
    private TripService tripService;
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private BusDetailsRepository busDetailsRepository;

    @GetMapping(value = "/trip/{tripId}")
    public ResponseEntity<Trip> findTrip(@PathVariable Integer tripId) {
        return new ResponseEntity<>(tripService.findTrip(tripId), HttpStatus.OK);
    }

    @GetMapping(value = "/trips")
    public ResponseEntity<List<Trip>> findTrips(@RequestParam("from") Integer from,@RequestParam("to") Integer to,@RequestParam("date") String departure) throws ParseException {
        Date date=new SimpleDateFormat("yyyy-MM-dd").parse(departure);
//        System.out.println(date);
        return new ResponseEntity<>(tripService.findTrips(from,to,date), HttpStatus.OK);
    }

    @PostMapping(value = "/trip")
    public ResponseEntity<Trip> addTrip(@RequestBody Trip trip,@RequestParam("busDetailsId") Integer busDetailsID,@RequestParam("routeId") Integer routeId){
    if(busDetailsRepository.existsById(busDetailsID)){
        trip.setBusDetails(new BusDetails(busDetailsID));
        if(routeRepository.existsById(routeId)){
            trip.setRoute(new Route(routeId));
            return new ResponseEntity<>(tripService.addTrip(trip),HttpStatus.CREATED);
        }
    }
        return null;
    }
}
