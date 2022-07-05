package com.airport.ev.model;

import javax.persistence.*;


@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "firstname")
    private String firsname;

    @ManyToOne
    @JoinColumn(name = "idlanguage")
    private Language language;

    @ManyToOne
    @JoinColumn(name = "idcountry")
    private Country country;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirsname() {
        return firsname;
    }

    public void setFirsname(String firsname) {
        this.firsname = firsname;
    }
}