package com.zemoso.busbooking.trip;

import com.zemoso.busbooking.baseEntity.BaseEntity;
import com.zemoso.busbooking.busdetails.BusDetails;
import com.zemoso.busbooking.route.Route;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
public class Trip extends BaseEntity {
    @Column(nullable = false)
    private Date departure;
    @Column(nullable = false)
    private Date arrival;
    @Column(nullable = false)
    private Integer availableSeats;
    @Column(nullable = false)
    private float price;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="busDetails_id")
    private BusDetails busDetails;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="route_id")
    private Route route;
}
