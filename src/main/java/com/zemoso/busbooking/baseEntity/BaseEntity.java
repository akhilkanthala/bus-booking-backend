package com.zemoso.busbooking.baseEntity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
////    @Type(type="org.hibernate.type.UUIDCharType")
//    private Integer id;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    public Integer id;

    @Column
    @CreationTimestamp
    private LocalDateTime createdTime;

    @Column
    @UpdateTimestamp
    private LocalDateTime updatedTime;

    @Column
    private boolean deleted = false;
//
//    @Type(type="org.hibernate.type.UUIDCharType")
//    @Column UUID createdBy;
//
//    @Type(type="org.hibernate.type.UUIDCharType")
//    @Column UUID updatedBy;
//

}