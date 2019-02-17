package generators;

public class ItemGenerator extends RandomGenerator {
    private static String[] categories = {"HANDBAGS", "BEACH BAGS", "LAPTOP BAGS", "BAGS"};
    private static String[] collecions = {"Vintage", "Chic", "Courier", "Retro", "Beach"};

    public static String randomCategory(){
        Integer randomNumber = generateRandomNumber(0, categories.length);
        return  categories[randomNumber];
    }
    public static String randomCollecion(){
        Integer randomNumber = generateRandomNumber(0, collecions.length);
        return  collecions[randomNumber];
    }

    private  static  String randomName(){
     String name = capitalize(generateRandomString(8));
     return name;
    }

    public static Integer randomAvailability(){
        Integer randomNumber = generateRandomNumber(0, 50);
        return  randomNumber;
    }

    public static String randomProductCode(){
        String code = generateRandomString(2);
        Integer randomNumber = generateRandomNumber(100, 999);
        return  code + randomNumber;
    }

    public static Integer randomRating(){
        Integer randomNumber = generateRandomNumber(1, 5);
        return  randomNumber;
    }

    public  static  String randomDescription(){
        String word1  = capitalize(generateRandomString(8));
        String word2  = generateRandomString(4);
        String word3  = generateRandomString(6);
        String word4  = generateRandomString(3);
        String word5  = generateRandomString(8);
        return word1 + " " + word2 + " " + word3 + " " + word4 + " " + word5;
    }

    public static Integer randomWeight(){
        Integer randomNumber = generateRandomNumber(1, 5);
        return  randomNumber;
    }

    public static Integer randomHeight(){
        Integer randomNumber = generateRandomNumber(10, 25);
        return  randomNumber;
    }

    public static Integer randomWidth(){
        Integer randomNumber = generateRandomNumber(10, 35);
        return  randomNumber;
    }

    public static Integer randomLength(){
        Integer randomNumber = generateRandomNumber(1, 5);
        return  randomNumber;
    }
}
