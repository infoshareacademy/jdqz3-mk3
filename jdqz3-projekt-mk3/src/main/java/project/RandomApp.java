package project;

import generators.BagGenerator;
import models.Address;
import models.Bag;

public class RandomApp {
    public static void main(String[] args) {

        Address adres1 = new Address();
        System.out.println(adres1);

        Bag bag = BagGenerator.generateRandomBag();
        System.out.println(bag);
    }
}
