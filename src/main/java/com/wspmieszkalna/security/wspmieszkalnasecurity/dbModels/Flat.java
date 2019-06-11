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
    private String flat_name;
    @Column(name = "flat_password")
    private String flat_password;
    @Column(name = "flat_street")
    private String flat_street;
    @Column(name = "flat_number")
    private String flat_number;
    @Column(name = "flat_city")
    private String flat_city;
    public String getFlat_city() {
        return flat_city;
    }

    public void setFlat_city(String flat_city) {
        this.flat_city = flat_city;
    }

    public void setResidents(Set<Resident> residents) {
        this.residents = residents;
    }

    public int getId() {
        return id;
    }

    public String getFlat_name() {
        return flat_name;
    }

    public String getFlat_password() {
        return flat_password;
    }

    public String getFlat_street() {
        return flat_street;
    }

    public String getFlat_number() {
        return flat_number;
    }

    public Set<Resident> getResidents() {
        return residents;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }
    public void setFlat_name(String flat_name) {
        this.flat_name = flat_name;
    }

    public void setFlat_password(String flat_password) {
        this.flat_password = flat_password;
    }

    public void setFlat_street(String flat_street) {
        this.flat_street = flat_street;
    }

    public void setFlat_number(String flat_number) {
        this.flat_number = flat_number;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "residents", joinColumns = @JoinColumn(name = "resident_id"), inverseJoinColumns = @JoinColumn(name = "flat_owner"))
    private Set<Resident> residents;



        @Transient
        private String passwordConfirm;
        public Flat() {
        }

    public Flat(String flat_name, String flat_password, String flat_street, String flat_number, String flat_city) {
        this.flat_name = flat_name;
        this.flat_password = flat_password;
        this.flat_street = flat_street;
        this.flat_number = flat_number;
        this.flat_city = flat_city;
    }

    public Flat(Flat flats){
            this.id=flats.getId();
            this.flat_name = flats.getFlat_name();
            this.flat_password = flats.getFlat_password();
            this.flat_street = flats.getFlat_street();
            this.flat_number = flats.getFlat_number();
            this.flat_city = flats.getFlat_city();
        }

}
