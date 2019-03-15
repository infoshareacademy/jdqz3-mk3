package models;

import generators.BagGenerator;
import generators.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Order extends RandomGenerator {
    private List<Bag> bags;
    private User user;
    private Payment payment;

    public Order (){
        this.user = new User();
        this.payment = new Payment();
        this.bags = createBagList();
    }

    public List<Bag> createBagList(){
        int amount = RandomGenerator.generateRandomNumber(1, 5);
        List<Bag> bagsList = new ArrayList<Bag>();
        for (int i =0; i<amount; i++){
            Bag newBag = BagGenerator.generateRandomBag();
            bagsList.add(newBag);
        }
        return bagsList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "bags=" + bags +
                ", user=" + user +
                ", payment=" + payment +
                '}';
    }
}
