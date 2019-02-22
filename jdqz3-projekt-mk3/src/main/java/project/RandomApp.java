package project;

import models.Address;
import models.Item;
import models.Payment;
import models.User;

public class RandomApp {
    public static void main(String[] args) {
        Item item1 = new Item();
        System.out.println(item1);

        Address adres1 = new Address();
        System.out.println(adres1);

        User user1 = new User();
        System.out.println(user1);

        Payment payment = new Payment();
        System.out.println(payment);
    }
}
