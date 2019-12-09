package com.zemoso.busbooking.busdetails;

import com.zemoso.busbooking.baseEntity.BaseEntity;
import com.zemoso.busbooking.buscompany.BusCompany;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table
@Getter
@Setter
public class BusDetails extends BaseEntity {
    @Column(nullable = false,unique = true)
    @NotBlank
    private String regNo;

    @Column(nullable = false)
    private Integer totalSeats;

    @Column(nullable = false)
    private String busType;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="busCompany_id")
    private BusCompany busCompany;

    public BusDetails(Integer busDetailsID) {
        super();
        this.id=busDetailsID;
    }
    public BusDetails(){
        super();
    }
}
