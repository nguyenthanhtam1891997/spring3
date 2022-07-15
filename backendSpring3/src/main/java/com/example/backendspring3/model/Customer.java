package com.example.backendspring3.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String phone;

    @JsonBackReference
    @OneToMany(mappedBy = "customer")
    private List<OderBook> oderBookList;

//    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Customer() {
    }

    public Customer(Long id, String name, String address, String phone, User user) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.user = user;
    }

    public Customer(Long id, String name, String address, String phone, List<OderBook> oderBookList, User user) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.oderBookList = oderBookList;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<OderBook> getOderBookList() {
        return oderBookList;
    }

    public void setOderBookList(List<OderBook> oderBookList) {
        this.oderBookList = oderBookList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
