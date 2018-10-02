package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addrId;

    @Column(name = "line1")
    private String line1;
    @Column(name = "line2")
    private String line2;
    @Column(name = "line3")
    private String line3;
    @Column(name = "city")
    private String city;

    public Address() {}

    public Address(int addrId, String line1, String line2, String line3, String city) {
        this.addrId = addrId;
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.city = city;
    }

    public int getAddrId() {
        return addrId;
    }

    public void setAddrId(int addrId) {
        this.addrId = addrId;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getLine3() {
        return line3;
    }

    public void setLine3(String line3) {
        this.line3 = line3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
