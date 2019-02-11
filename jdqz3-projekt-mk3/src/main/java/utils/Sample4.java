package utils;

import org.apache.commons.text.RandomStringGenerator;

public class Sample4 {
    public String generateFirstname(){
        int firstNameLength = 8;
        String firstname = generateData(firstNameLength);
        return firstname;
    }

    public String generateLastname(){
        int lastNameLength = 14;
        return generateData(lastNameLength);
    }

    private String generateData(int length){

        RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('a', 'z').build();
        return generator.generate(length);
    }
}
