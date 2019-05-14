package com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "residents")
public class Residents {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "resident_id")
    private int id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "phone_number")
    private String phone_number;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "resident_roles", joinColumns = @JoinColumn(name = "resident_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();;

    public Residents() {

    }
    public Residents(Residents residents){
        this.id=residents.getId();
        this.login=residents.getLogin();
        this.password=residents.getPassword();
        this.name=residents.getName();
        this.surname=residents.getSurname();
        this.phone_number=residents.getPhoneNumber();
    }






    public int getId(){
        return id;
    }
    public String getLogin(){
        return login;
    }
    public String getPassword(){
        return password;
    }
    private String getName() {
        return name;
    }
    private String getSurname() {
        return surname;
    }
    private String getPhoneNumber() {
        return phone_number;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
