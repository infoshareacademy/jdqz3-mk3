package utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.RandomStringGenerator;

public class Sample6 {
    public static String generateFirstname(){
        int firstNameLength = 8;

        String name =  generateData(firstNameLength);
        return Sample6.formatName(name);
    }

    public static String generateLastname(){
        int lastNameLength = 14;

        String name = generateData(lastNameLength);
        return Sample6.formatName(name);
    }

    private static String generateData(int length){

        RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('a', 'z').build();
        String data =  generator.generate(length);
        return StringUtils.capitalize(data);
    }

    private static String formatName(String name){

        return StringUtils.capitalize(name);
    }
}
