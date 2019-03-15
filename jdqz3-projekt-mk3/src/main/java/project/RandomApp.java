package project;

import generators.BagGenerator;
import models.Address;
import models.Bag;
import models.Payment;
import models.User;

public class RandomApp {
    public static void main(String[] args) {

        Address adres1 = new Address();
        System.out.println(adres1);

        Bag bag = BagGenerator.generateRandomBag();
        System.out.println(bag);

        User user1 = new User();
        System.out.println(user1);

        Payment payment = new Payment();
        System.out.println(payment);
    }
}
