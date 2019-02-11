package utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.RandomStringGenerator;

public class Sample5 {
    public static String generateFirstname(){
        int firstNameLength = 8;
        String firstname = generateData(firstNameLength);
        return firstname;
    }

    public static String generateLastname(){
        int lastNameLength = 14;
        return generateData(lastNameLength);
    }

    private static String generateData(int length){

        RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('a', 'z').build();
        String data =  generator.generate(length);
        return StringUtils.capitalize(data);
    }
}
