package com.preeti.assignment2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    private String addressTag;

    private String street;
    private String city;
    private Integer pinCode;
    private String state;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;

}
