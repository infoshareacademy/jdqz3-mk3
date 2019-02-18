package models;

import static generators.BagGenerator.*;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private static String category;
    private static String collection;
    private static String name;
    private static Boolean avaliable;
    private static Integer price;
    private static Integer weight;
    private static Integer height;
    private static Integer width;
    private static Integer lenght;


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

    public Bag() {
        setCategory(categoryGenerator());
        setCollection(collectionGenerator());
        setName(nameGenerator());
        setAvaliable(avaliableGenerator());
        setPrice(priceGenerator());
        setWeight(weightGenerator());
        setHeight(heightGenerator());
        setWidth(widthGenerator());
        setLenght(lenghtGenerator());
    }


    public static String getCategory() {
        return category;
    }

    public static String getCollection() {
        return collection;
    }

    public static String getName() {
        return name;
    }

    public static Boolean getAvaliable() {
        return avaliable;
    }

    public static Integer getPrice() {
        return price;
    }

    public static Integer getWeight() {
        return weight;
    }

    public static Integer getHeight() {
        return height;
    }

    public static Integer getWidth() {
        return width;
    }

    public static Integer getLenght() {
        return lenght;
    }

    public static void setCategory(String category) {
        Bag.category = category;
    }

    public static void setCollection(String collection) {
        Bag.collection = collection;
    }

    public static void setName(String name) {
        Bag.name = name;
    }

    public static void setAvaliable(Boolean avaliable) {
        Bag.avaliable = avaliable;
    }

    public static void setPrice(Integer price) {
        Bag.price = price;
    }

    public static void setWeight(Integer weight) {
        Bag.weight = weight;
    }

    public static void setHeight(Integer height) {
        Bag.height = height;
    }

    public static void setWidth(Integer width) {
        Bag.width = width;
    }

    public static void setLenght(Integer lenght) {
        Bag.lenght = lenght;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "='category" + category + '\'' +
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
