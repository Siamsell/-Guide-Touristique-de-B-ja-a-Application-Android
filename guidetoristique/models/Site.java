package com.siham.guidetoristique.models;


import java.util.ArrayList;
import java.util.List;

public class Site {

    public int id;
    public String name, description, telephone, email, type;
    public ArrayList<SiteImage> images;
    private List<String> reviews;
    private String location;

    public Site(int id, String name, String description, String telephone, String email, String type, ArrayList<SiteImage> images, List<String> avis ,String location) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.telephone = telephone;
        this.email = email;
        this.images = images;
        this.type = type;
        this.reviews = avis;
        this.location = location;
    }

    public List<String> getReviews() {
        return reviews;
    }


    public void setReviews(List<String> reviews) {
        this.reviews = reviews;
    }
    public String getLocation() {
        return location;
    }

}
