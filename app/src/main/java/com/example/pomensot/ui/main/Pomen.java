package com.example.pomensot.ui.main;

import com.example.pomensot.Links;

public class Pomen {
    public int pid;
    public String name;
    public String description;
    public String email;
    public String image;
    public String location;
    public String address;

    public Pomen(String name, String email, String image, String location, String address) {
        this.name = name;
        this.email = email;
        this.image = image;
        this.location = location;
        this.address = address;
    }

    public Pomen(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getImage (){
        return Links.url_Pomen_image+image;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
