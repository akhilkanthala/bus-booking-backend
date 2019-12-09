package com.zemoso.busbooking.buscompany;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BusCompanyController {

    @Autowired
    private BusCompanyService busCompanyService;

    @GetMapping(value = "/buscompany")
    public ResponseEntity<?> getAllBusCompanies()  {

        return new ResponseEntity<>(busCompanyService.getAllBusCompanies(), HttpStatus.OK);
    }

    @GetMapping(value="buscompany/{buscompanyid}")
    public ResponseEntity<BusCompany> findBusCompany(@PathVariable Integer busCompanyId) {
        return new ResponseEntity<>(busCompanyService.findBusCompany(busCompanyId), HttpStatus.OK);
    }

    @PostMapping(value = "/buscompany")
    public ResponseEntity<BusCompany> addBusCompany(@RequestBody final BusCompany busCompany) {
            return new ResponseEntity<>(busCompanyService.addBusCompany(busCompany), HttpStatus.CREATED);
        }
}
