package com.airport.ev.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "airport")
public class Airport {


    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Id
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "airport")
    private List<Airport> airport;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }


}