package com.company.mybasket.customer.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
public class Customer {
    @GeneratedValue
    @Id
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
}
