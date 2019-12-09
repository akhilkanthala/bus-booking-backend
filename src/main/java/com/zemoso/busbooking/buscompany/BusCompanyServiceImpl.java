package com.zemoso.busbooking.buscompany;


import com.zemoso.busbooking.exception.IncompleteFieldsException;
import com.zemoso.busbooking.exception.ResourceAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusCompanyServiceImpl implements BusCompanyService {
    @Autowired
    private BusCompanyRepository busCompanyRepository;

    @Override
    public List<BusCompany> getAllBusCompanies() {
        return busCompanyRepository.findAllByDeleted(false);
    }

    @Override
    public BusCompany findBusCompany(Integer busCompanyId) {
        return busCompanyRepository.getOneByIdAndDeleted(busCompanyId,false);
    }

    @Override
    public BusCompany addBusCompany(BusCompany busCompany) {
        if(busCompany.getCompanyName()==null || busCompany.getRating()==null){
            throw new IncompleteFieldsException("Please fill the required fields");
        }
        if(busCompanyRepository.existsByCompanyName(busCompany.getCompanyName())){
            throw new ResourceAlreadyExistsException("Email Id Already Exists");
        };
        return busCompanyRepository.save(busCompany);
    }
}
