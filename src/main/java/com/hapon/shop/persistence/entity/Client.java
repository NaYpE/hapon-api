package com.hapon.shop.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    private String id;
    private String name;
    private String surnames;
    @Column(name = "cel_phone")
    private Long celPhone;
    private String address;
    private String email;

    @OneToMany(mappedBy = "client")
    private List<Purchase> purchases;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public Long getCelPhone() {
        return celPhone;
    }

    public void setCelPhone(Long celPhone) {
        this.celPhone = celPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
