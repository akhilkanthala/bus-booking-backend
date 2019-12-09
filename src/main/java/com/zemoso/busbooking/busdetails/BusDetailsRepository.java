package com.zemoso.busbooking.busdetails;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusDetailsRepository extends JpaRepository<BusDetails, Integer> {
    List<BusDetails> findAllByBusCompanyIdAndDeleted(Integer busCompanyId,boolean deleted);
    BusDetails getOneByIdAndDeleted(Integer id, Boolean deleted);
    boolean existsByRegNo(String regNo);
}

