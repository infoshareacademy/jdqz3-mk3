package generators;

public class AdressGenerator extends RandomGenerator{
 private static String[] countries = {"Belgium", "Brazil",
 "Canada", "China", "Czech Republic", "France",
 "India", "Italy", "Switzerland", "United States"};

    public static String streetGenerator() {
     String street = capitalize(generateRandomString(10));
     Integer number = generateRandomNumber(1, 500);
     return street + " " + number;
    }

    public static String randomCountry(){
        Integer randomNumber = generateRandomNumber(0, countries.length);
        return countries[randomNumber];
    }

    public static String cityGenerator(){
        String street = capitalize(generateRandomString(8));
        return street;
    }

    public static String postalCodeGenerator(){
        Integer firstNumber = generateRandomNumber(10, 99);
        Integer secondNumber = generateRandomNumber(100, 999);
        return firstNumber + "-" + secondNumber;
    }
    public static String stateGenerator(){
        String state = capitalize(generateRandomString(8));
        return state;
    }

    public static void main(String[] args) {
        System.out.println(streetGenerator());
    }
}
