package com.example.androidtuan05;

import java.io.Serializable;

public class Cake implements Serializable {
    private int image;
    private String name;
    private String pricel;
    private String Category;

    public Cake(int image, String name, String pricel, String category) {
        this.image = image;
        this.name = name;
        this.pricel = pricel;
        Category = category;
    }

    public Cake() {
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPricel() {
        return pricel;
    }

    public void setPricel(String pricel) {
        this.pricel = pricel;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    @Override
    public String toString() {
        return "Cake{" +
                "image=" + image +
                ", name='" + name + '\'' +
                ", pricel='" + pricel + '\'' +
                ", Category='" + Category + '\'' +
                '}';
    }
}
