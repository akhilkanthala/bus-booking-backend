package com.zemoso.busbooking.destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DestinationController {
    @Autowired
    private DestinationService destinationService;

    @GetMapping(value = "/destination")
    public ResponseEntity<?> getAllDestinations()  {

        return new ResponseEntity<>(destinationService.getAllDestinations(), HttpStatus.OK);
    }
    @GetMapping(value = "/destination/{destinationId}")
    public ResponseEntity<Destination> getDestination(@PathVariable("destinationId") Integer destinationId)  {

        return new ResponseEntity<>(destinationService.getDestination(destinationId), HttpStatus.OK);
    }
    @PostMapping(value = "/destination")
    public ResponseEntity<Destination> addDestination(@RequestBody final Destination destination) {
        return new ResponseEntity<>(destinationService.addDestination(destination), HttpStatus.CREATED);
    }

}
