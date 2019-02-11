package utils;

import org.apache.commons.text.RandomStringGenerator;

public class Sample2 {
    public void generateFirstnameAndLastnameAndDispplayIt(){
        int firstNameLength = 8;
        int lastNameLength = 14;

        RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('a', 'z').build();

        String firstname = generator.generate(firstNameLength);
        String lastname = generator.generate(lastNameLength);

        System.out.println(firstname + " " + lastname);
    }
}
