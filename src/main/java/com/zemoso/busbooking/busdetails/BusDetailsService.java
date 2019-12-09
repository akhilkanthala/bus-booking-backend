package com.zemoso.busbooking.busdetails;



public interface BusDetailsService {
    public BusDetails findBus(Integer busId);

    public BusDetails addBus(BusDetails busDetails);
}
