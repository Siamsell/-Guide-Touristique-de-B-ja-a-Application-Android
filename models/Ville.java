package com.siham.guidetoristique.models;

import java.util.ArrayList;

public class Ville {
    public String name,description;
    public ArrayList<Site> sites;
    public Ville(String name, String description,ArrayList<Site> sites){
        this.name = name;
        this.description = description;
        this.sites = sites;
    }
}