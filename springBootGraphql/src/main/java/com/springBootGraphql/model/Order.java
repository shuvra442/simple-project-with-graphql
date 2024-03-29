package com.springBootGraphql.model;

import jakarta.persistence.*;

@Entity
@Table(name = "OrderPlaced")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ordDetails;
    private String ordName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrdDetails() {
        return ordDetails;
    }

    public void setOrdDetails(String ordDetails) {
        this.ordDetails = ordDetails;
    }

    public String getOrdName() {
        return ordName;
    }

    public void setOrdName(String ordName) {
        this.ordName = ordName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
