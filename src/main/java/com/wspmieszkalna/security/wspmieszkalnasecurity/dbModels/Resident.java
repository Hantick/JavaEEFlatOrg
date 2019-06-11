package com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "residents")
public class Resident {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
    @OneToOne(mappedBy = "flat_owner")
    private Flat flat;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "resident_roles", joinColumns = @JoinColumn(name = "resident_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;



    @Transient
    private String passwordConfirm;
    public Resident() {
    }
    public Resident(String _login, String _password, String _name, String _surname, String _phone_number) {
        this.login=_login;
        this.password=_password;
        this.name=_name;
        this.surname=_surname;
        this.phone_number=_phone_number;
    }
    public Resident(Resident residents){
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
    public String getName() { return name; }
    public String getPassword(){ return password; }

    public String getSurname() { return surname; }
    public String getPhoneNumber() { return phone_number; }
    public Set<Role> getRoles() { return roles; }
    public String getPhone_number() { return phone_number; }
    public String getPasswordConfirm() { return passwordConfirm; }

    public void setRoles(Set<Role> roles) { this.roles = roles; }
    public void setLogin(String login) { this.login = login; }
    public void setPassword(String password) { this.password = password; }
    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setPhone_number(String phone_number) { this.phone_number = phone_number; }
    public void setId(int id) { this.id = id; }

    public void setPasswordConfirm(String passwordConfirm) { this.passwordConfirm = passwordConfirm; }
}
