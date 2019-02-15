package models;
import static generators.ItemGenerator.*;

public class Item {
    private  String category;
    private  String collection;
    private  Integer available;
    private  String productCode;
    private  Integer ratingPrice;
    private  String description;
    private  Integer weight;
    private  Integer heights;
    private  Integer width;
    private  Integer length;

    public Item (){
        setCategory(randomCategory());
        setCollection(randomCollecion());
        setAvailable(randomAvailability());
        setProductCode(randomProductCode());
        setRatingPrice(randomRating());
        setDescription(randomDescription());
        setWeight(randomWeight());
        setHeights(randomHeight());
        setWidth(randomWidth());
        setLength(randomLength());

    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setRatingPrice(Integer ratingPrice) {
        this.ratingPrice = ratingPrice;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setHeights(Integer heights) {
        this.heights = heights;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Item{" +
                "category='" + category + '\'' +
                ", collection='" + collection + '\'' +
                ", available=" + available +
                ", productCode='" + productCode + '\'' +
                ", ratingPrice=" + ratingPrice +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                ", heights=" + heights +
                ", width=" + width +
                ", length=" + length +
                '}';
    }
}
