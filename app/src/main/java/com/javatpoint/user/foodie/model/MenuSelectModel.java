package com.javatpoint.user.foodie.model;

public class MenuSelectModel {
    String name;
    String cat;
    int fav;
    int price;
    String desc;
    String image;

    public MenuSelectModel()
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public int getFav() {
        return fav;
    }

    public void setFav(int fav) {
        this.fav = fav;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public MenuSelectModel(String name, String cat, int fav, int price, String desc, String image) {

        this.name = name;
        this.cat = cat;
        this.fav = fav;
        this.price = price;
        this.desc = desc;
        this.image = image;
    }
}
