package generators;

public class UserGenerator extends RandomGenerator {

    public static String firstNameGenerator() {
        String firstName = capitalize(generateRandomString(9));
        return firstName;
    }

    public static String lastNameGenerator() {
        String lastName = capitalize(generateRandomString(15));
        return lastName;
    }

    public static String billingCompanyGenerator() {
        String billingCompany = capitalize(generateRandomString(10));
        return billingCompany;
    }

    public static String emailGenerator() {
        String emailLogin = generateRandomString(10);
        String domain = "@testtest.com";
        return emailLogin + domain;
    }

    public static String phoneNumberGenerator() {
        String prefix = "+48 ";
        Integer customerPhone = generateRandomNumber(100000000, 999999999);
        String fullPhoneNumber = prefix + customerPhone;
        return fullPhoneNumber;
    }

    public static String orderNotesGenerator() {
        String word1 = capitalize(generateRandomString(6));
        String word2 = generateRandomString(3);
        String word3 = generateRandomString(6);
        String word4 = generateRandomString(2);
        String word5 = generateRandomString(5);
        return word1 + " " + word2 + " " + word3 + " " + word4 + " " + word5 + ".";
    }

    public static String passwordGenerator() {
        String password = generateRandomString(8) + generateRandomNumber(10,99);
        return password;
    }
}