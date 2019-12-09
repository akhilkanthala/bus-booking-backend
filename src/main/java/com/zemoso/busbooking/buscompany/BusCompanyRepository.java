package com.zemoso.busbooking.buscompany;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusCompanyRepository extends JpaRepository<BusCompany, Integer> {

    List<BusCompany> findAllByDeleted(boolean deleted);
    public BusCompany getOneByIdAndDeleted(Integer id, Boolean deleted);

    boolean existsByCompanyName(String companyName);
}
