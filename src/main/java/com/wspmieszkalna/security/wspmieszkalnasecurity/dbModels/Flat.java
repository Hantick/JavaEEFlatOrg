package com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "flats")
public class Flat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "flat_id")
    private int id;
    @Column(name = "flat_name")
    private String name;
    @Column(name = "flat_password")
    private String password;
    @Column(name = "flat_street")
    private String street;
    @Column(name = "flat_number")
    private String number;
    @Column(name = "flat_city")
    private String city;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Resident flat_owner;


    @OneToMany
    private Set<Resident> residents;

    public void addResident(Resident newResident) {
        this.residents.add(newResident);
    }
    public Set<Resident> getResidents() {
        return residents;
    }
    public void setResidents(Set<Resident> residents) {
        this.residents = residents;
    }

    public void setResident(Resident flat_owner) {
        this.flat_owner= flat_owner;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }

    public Resident getOwner() {
        return flat_owner;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setOwner(Resident owner) {
        this.flat_owner = owner;
    }

    public Flat() {
    }

    public Flat(String name, String password, String street, String number, String city, Resident flat_owner) {
        this.name = name;
        this.password = password;
        this.street = street;
        this.number = number;
        this.city = city;
        this.flat_owner=flat_owner;
        setResident(flat_owner);
    }

    public Flat(Flat flats){
        this.id=flats.getId();
        this.name = flats.getName();
        this.password = flats.getPassword();
        this.street = flats.getStreet();
        this.number = flats.getNumber();
        this.city = flats.getCity();
        this.flat_owner=flats.getOwner();
    }


}
