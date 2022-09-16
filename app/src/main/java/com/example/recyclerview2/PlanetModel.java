package com.example.recyclerview2;

public class PlanetModel {
    String planetname;
    String planetdescription;
    int image;
    String price;
    String milage;

    public PlanetModel(String planetname,
                       String planetdescription, int image,String price, String milage) {
        this.planetname = planetname;
        this.planetdescription = planetdescription;
        this.image = image;
        this.price=price;
        this.milage = milage;
    }

    public String getPlanetname() {
        return planetname;
    }

    public String getPlanetdescription() {
        return planetdescription;
    }

    public String getPrice() {
        return price;
    }
    public String getMilage() {
        return milage;
    }

    public int getImage() {
        return image;
    }

}
