package com.zemoso.busbooking.destination;


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
public class Destination extends BaseEntity {
    @Column(nullable = false)
    @NotBlank
    private String destinationName;

    public Destination(Integer destinationId) {
        super();
        this.id=destinationId;
    }
    public Destination(){
        super();
    }
}