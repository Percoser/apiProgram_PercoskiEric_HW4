package com.example.demo.Models;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.ResultSet;

@Entity
@Table(name = "country")
public class Item {
    @Id
    @Column (name = "id")
    public String id;
    @Column(name = "name")
    public String name;
    @Column(name = "capital")
    public String capital;
    @Column(name = "region")
    public String region;
    @Column(name = "subregion")
    public String subregion;
    @Column(name = "population")
    public String population;

    public Item() {
    }

    public Item(String id,String name, String capital, String region, String subregion, String population) {

        this.id = id;
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.subregion = subregion;
        this.population = population;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }


}
