package com.example.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class Booking {
    @Id
    private String email;
    private String name;
    private long contact;
    private String address;
    private String paymentmode;


    public Booking(String email, String name, long contact, String address, String paymentmode) {
        this.email = email;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.paymentmode = paymentmode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPaymentmode() {
        return paymentmode;
    }

    public void setPaymentmode(String paymentmode) {
        this.paymentmode = paymentmode;
    }

    public Booking() {
    }

    @OneToOne
    @JsonBackReference
    private User user;
}
