package com.zemoso.busbooking.destination;

import com.zemoso.busbooking.exception.IncompleteFieldsException;
import com.zemoso.busbooking.exception.ResourceAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationServiceImpl implements DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;
    @Override
    public List<Destination> getAllDestinations() {
        return destinationRepository.findAllByDeleted(false);
    }

    @Override
    public Destination addDestination(Destination destination) {
        if(destination.getDestinationName()==null){
            throw new IncompleteFieldsException("Please fill the required fields");
        }
        if(destinationRepository.existsByDestinationName(destination.getDestinationName())){
            throw new ResourceAlreadyExistsException("Destination Already Exists");
        };
        return destinationRepository.save(destination);
    }

    @Override
    public Destination getDestination(Integer destinationId) {
        return destinationRepository.getOneByIdAndDeleted(destinationId,false);
    }
}
