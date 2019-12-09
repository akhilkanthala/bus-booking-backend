package com.zemoso.busbooking.buscompany;

import java.util.List;


public interface BusCompanyService {
    public List<BusCompany> getAllBusCompanies();

    public BusCompany findBusCompany(Integer busCompanyId);

    public BusCompany addBusCompany(BusCompany userDTO);
}
