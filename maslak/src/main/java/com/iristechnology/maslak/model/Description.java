package com.iristechnology.maslak.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Description {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false)
    private long id;

    private String disease;

    private String desDescription;
    private  String status;

    @ManyToOne
    @JoinColumn(name="id", nullable=false, insertable = false,updatable = false)
    private Patient patient;


    @ManyToMany
    Set<Medicine> medicine;








}
