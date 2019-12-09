package com.zemoso.busbooking.destination;

import java.util.List;

public interface DestinationService {
    List<Destination> getAllDestinations();

    Destination addDestination(Destination destination);

    Destination getDestination(Integer destinationId);
}
