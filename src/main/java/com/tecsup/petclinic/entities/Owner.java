package com.tecsup.petclinic.entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "owners")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String telephone;

}
