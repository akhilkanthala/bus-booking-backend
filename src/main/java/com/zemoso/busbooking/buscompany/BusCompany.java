package com.zemoso.busbooking.buscompany;


import com.zemoso.busbooking.baseEntity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table
@Getter
@Setter
public class BusCompany extends BaseEntity {
    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private Float rating;

    public BusCompany(Integer buscompanyid) {
        super();
        this.id=buscompanyid;
    }
    public BusCompany(){
        super();
    }
}
