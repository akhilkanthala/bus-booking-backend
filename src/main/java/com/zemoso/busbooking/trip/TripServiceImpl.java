package com.zemoso.busbooking.trip;

import com.zemoso.busbooking.exception.IncompleteFieldsException;
import com.zemoso.busbooking.exception.ResourceAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class TripServiceImpl implements TripService {
    @Autowired
    private TripRepository tripRepository;

    @Override
    public Trip findTrip(Integer tripId) {
        return tripRepository.getOneByIdAndDeleted(tripId,false);
    }

    @Override
    public Trip addTrip(Trip trip) {
        if(trip.getDeparture()==null || trip.getAvailableSeats()==null ||trip.getRoute()==null){
            throw new IncompleteFieldsException("Please fill the required fields");
        }
        if(tripRepository.existsByBusDetailsAndRouteAndDeparture(trip.getBusDetails(),trip.getRoute(),trip.getDeparture())){
            throw new ResourceAlreadyExistsException("Trip Already Exists");
        }
        return tripRepository.save(trip);
    }

    @Override
    public List<Trip> findTrips(Integer from, Integer to,Date departure) {
        final Calendar end = Calendar.getInstance();
        end.setTime(departure);
        end.add(Calendar.DAY_OF_YEAR, 1);
        Date date=new Date(end.getTimeInMillis());
//        System.out.println(date);
        return tripRepository.findAllBySourceAndDestinationAndDate(from,to,departure,date);
    }
}
