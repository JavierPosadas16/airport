package com.airport.ev.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "country")
public class Country {


    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "code")
    private String code;
    @Id
    @Column(name = "name")
    private String name;


    @ManyToOne
    @JoinColumn(name = "airport")
    private Airport airport;

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }
    @OneToMany(mappedBy = "country")
    private List<Country> country;

    public List<Country> getCountry() {
        return country;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}