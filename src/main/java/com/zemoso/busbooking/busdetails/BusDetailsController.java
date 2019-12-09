package com.zemoso.busbooking.busdetails;

import com.zemoso.busbooking.buscompany.BusCompany;
import com.zemoso.busbooking.buscompany.BusCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BusDetailsController {
    @Autowired
    private BusDetailsService busDetailsService;
    @Autowired
    private BusCompanyRepository busCompanyRepository;

    @GetMapping(value = "/busdetails/{busId}")
    public ResponseEntity<BusDetails> findBus(@PathVariable Integer busId) {
        return new ResponseEntity<>(busDetailsService.findBus(busId), HttpStatus.OK);
    }

    @PostMapping(value = "/busdetails/{busCompanyId}")
    public ResponseEntity<BusDetails> addBus(@RequestBody final BusDetails busDetails, @PathVariable Integer busCompanyId) {
        if (busCompanyRepository.existsById(busCompanyId)) {
            busDetails.setBusCompany(new BusCompany(busCompanyId));
            return new ResponseEntity<>(busDetailsService.addBus(busDetails), HttpStatus.CREATED);
        }
        else
            return null;
    }
}
