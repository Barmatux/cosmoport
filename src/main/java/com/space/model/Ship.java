package com.space.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "ship")
public class Ship {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "planet")
    private String planet;
    @Column(name = "shipType")
    @Enumerated(EnumType.STRING)
    private ShipType shipType;
    @Column(name = "prodDate")
    private Date prodDate;
    @Column(name = "isUsed")
    private Boolean isUsed = false;
    @Column(name = "speed")
    private Double speed;
    @Column(name = "crewSize")
    private Integer crewSize;
    @Column(name = "rating")
    private Double rating;

    public Ship() {
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

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }

    public Date getProdDate() {
        return prodDate;
    }

    public void setProdDate(Date prodDate) {
        this.prodDate = prodDate;
    }

    public Boolean getUsed() {
        return isUsed;
    }

    public void setUsed(Boolean used) {
        isUsed = used;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Integer getCrewSize() {
        return crewSize;
    }

    public void setCrewSize(Integer crewSize) {
        this.crewSize = crewSize;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        if(name.length()<=50){
//        this.name = name;}
//        else System.out.println("too long");
//    }
//
//    public String getPlanet() {
//        return planet;
//    }
//
//    public void setPlanet(String planet) {
//        if (planet.length()<=50){
//        this.planet = planet;}
//        else System.out.println("Too long");
//    }
//
//    public ShipType getShipType() {
//        return shipType;
//    }
//
//    public void setShipType(ShipType shipType) {
//        if(shipType!=null) {
//        this.shipType = shipType; }
//        else System.out.println("Wrong type");
//    }
//
//    public Date getProdDate() {
//        return prodDate;
//    }
//
//    public void setProdDate(Date prodDate) {
//        if(prodDate.after(new Date("31.12.2799")) && prodDate.before(new Date("01.01.3020"))) {
//        this.prodDate = prodDate;}
//        else System.out.println("Incorrect date");
//    }
//
//    public Boolean getUsed() {
//        return isUsed;
//    }
//
//    public void setUsed(Boolean used) {
//        isUsed = used;
//    }
//
//    public Double getSpeed() {
//        return speed;
//    }
//
//    public void setSpeed(Double speed) {
//        if(Math.round(speed*100.0)/100.0>=0.01 && Math.round(speed*100.0)/100.0<=0.99){
//        this.speed = speed;}
//        else System.out.println("Incorrect speed");
//    }
//
//    public Integer getCrewSize() {
//        return crewSize;
//    }
//
//    public void setCrewSize(Integer crewSize) {
//        if(crewSize>=1 && crewSize<=9999) {
//        this.crewSize = crewSize; }
//        else System.out.println("Incorrect crew size");
//    }
//
//    public Double getRating() {
//        return rating;
//    }
//
//    public void setRating(Double rating) {
//        rating = (80*speed*(isUsed?0.5:1))/2;// посмотреть как правильно работать с датами!
//        rating=Math.round(rating*100.0)/100.0;
//        this.rating = rating;
//    }

    @Override
    public String toString() {
        return "Id" + id + "Name" + name;
    }
}
