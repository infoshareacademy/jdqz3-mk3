package models;

import generators.BagGenerator;

import static generators.BagGenerator.*;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private String category;
    private String collection;
    private String name;
    private Boolean avaliable;
    private Integer price;
    private Integer weight;
    private Integer height;
    private Integer width;
    private Integer lenght;


    public Bag(String category, String collection, String name, Boolean avaliable, Integer price, Integer weight, Integer height, Integer width, Integer lenght) {
        this.category = category;
        this.collection = collection;
        this.name = name;
        this.avaliable = avaliable;
        this.price = price;
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.lenght = lenght;
    }

    public String getCategory() {
        return category;
    }

    public String getCollection() {
        return collection;
    }

    public String getName() {
        return name;
    }

    public Boolean getAvaliable() {
        return avaliable;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getLenght() {
        return lenght;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "category=" + category + '\'' +
                ", collection='" + collection + '\'' +
                ", name='" + name + '\'' +
                ", avaliable='" + avaliable + '\'' +
                ", price='" + price + '\'' +
                ", weight='" + price + '\'' +
                ", height='" + price + '\'' +
                ", width='" + width + '\'' +
                ", lenght='" + lenght + '\'' +
                '}';
    }
}
