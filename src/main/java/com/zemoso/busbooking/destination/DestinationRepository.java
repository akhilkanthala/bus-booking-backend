package com.zemoso.busbooking.destination;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DestinationRepository extends JpaRepository<Destination,Integer> {
    List<Destination> findAllByDeleted(Boolean deleted);

    boolean existsByDestinationName(String destinationName);
    boolean existsById(Integer destinationId);

    Destination getOneByIdAndDeleted(Integer destinationId, boolean b);
}
