package com.zemoso.busbooking.busdetails;

import com.zemoso.busbooking.buscompany.BusCompany;
import com.zemoso.busbooking.exception.IncompleteFieldsException;
import com.zemoso.busbooking.exception.ResourceAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BusDetailsServiceImpl implements BusDetailsService {

    @Autowired
    private BusDetailsRepository busDetailsRepository;

    @Override
    public BusDetails findBus(Integer busId) {
        return busDetailsRepository.getOneByIdAndDeleted(busId,false);
    }

    @Override
    public BusDetails addBus(BusDetails busDetails) {
        if(busDetails.getRegNo()==null || busDetails.getBusCompany()==null){
            throw new IncompleteFieldsException("Please fill the required fields");
        }
        if(busDetailsRepository.existsByRegNo(busDetails.getRegNo())){
            throw new ResourceAlreadyExistsException("Email Id Already Exists");
        };
        return busDetailsRepository.save(busDetails);
    }
}
