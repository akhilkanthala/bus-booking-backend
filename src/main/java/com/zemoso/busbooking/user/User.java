package com.zemoso.busbooking.user;

import com.zemoso.busbooking.baseEntity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users1")
@Getter
@Setter
public class User extends BaseEntity {
    public User(String email) {
        super();
    }

    @Column(nullable = false)
    @NotBlank
    private String userName;

    @Column(unique = true, nullable = false)
    @NotBlank
    private String email;



    public User() {

    }



    public User(Integer id,String userName,String email) {
        super();
        this.id=id;
        this.userName=userName;
        this.email=email;
    }

    public User(Integer id) {
        super();
        this.id=id;
    }


//    @Column(nullable = false)
//    @NotBlank
//    private String password;


}
