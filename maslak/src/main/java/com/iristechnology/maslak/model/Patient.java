package com.iristechnology.maslak.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Data
@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false)
    private long id;

    private String firstName;

    private String middleName;

    private String lastNme;

    private String address;

    private String phoneNumber;

    private int age;

    private String gender;

    private String date;
    public int status;

    @OneToMany(mappedBy="patient")
    private Set<Description> description;


}
