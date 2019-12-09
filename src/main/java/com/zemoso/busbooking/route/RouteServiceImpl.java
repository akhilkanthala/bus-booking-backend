package com.zemoso.busbooking.route;

import com.zemoso.busbooking.exception.IncompleteFieldsException;
import com.zemoso.busbooking.exception.ResourceAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteServiceImpl implements RouteService{
    @Autowired
    private RouteRepository routeRepository;
    @Override
    public Route findRoute(Integer routeId) {
        return routeRepository.findAllByIdAndDeleted(routeId,false);
    }

    @Override
    public Route addRoute(Route route) {
        if(route.getDistance()==null){
            throw new IncompleteFieldsException("Please fill the required fields");
        }
        if(routeRepository.existsByDestinationAndDestination1(route.getDestination(),route.getDestination1())){
            throw new ResourceAlreadyExistsException("Email Id Already Exists");
        }
        return routeRepository.save(route);
    }

}
