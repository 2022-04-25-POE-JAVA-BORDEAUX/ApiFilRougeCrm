package com.m2i.apifilrougecrm.entity;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="typePresta")
    private String typePresta;
    @Column(name="designation")
    private String designation;
    @Column(name="nbDays")
    private int nbDays;
    @Column(name = "unitPrice")
    private float unitPrice;

    private int state; // CANCELLED:0 OPTION:1 CONFIRMED:2

    @ManyToOne //(cascade = {CascadeType.ALL})
    @JoinColumn(name="clientId")
    private Client client;


    public Order() {

    }

    public Order(String typePresta, String designation, int nbDays, float unitPrice) {
        this.typePresta = typePresta;
        this.designation = designation;
        this.nbDays = nbDays;
        this.unitPrice = unitPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypePresta() {
        return typePresta;
    }

    public void setTypePresta(String typePresta) {
        this.typePresta = typePresta;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getNbDays() {
        return nbDays;
    }

    public void setNbDays(int nbDays) {
        this.nbDays = nbDays;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
