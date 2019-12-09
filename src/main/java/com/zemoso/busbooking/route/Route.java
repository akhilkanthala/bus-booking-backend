package com.zemoso.busbooking.route;

import com.zemoso.busbooking.baseEntity.BaseEntity;
import com.zemoso.busbooking.destination.Destination;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table
@Getter
@Setter
public class Route extends BaseEntity {
    @Column(nullable = false)
    private Integer distance;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="destination_id")
    private Destination destination;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="destination_id1")
    private Destination destination1;
    public Route(Integer routeId){
        super();
        this.id=routeId;
    }
    public Route(){
        super();
    }
}
