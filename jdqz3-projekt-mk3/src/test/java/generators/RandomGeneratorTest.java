package generators;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RandomGeneratorTest {

    @Test
    public void generateRandomStringGivesProperResult() {
        //GIVEN
        int length = 1000000;
        boolean isError = false;

        //WHEN
        String result = RandomGenerator.generateRandomString(length);

        for (int i = 0; i < result.length(); i++) {
            char letter = result.charAt(i);
            if (letter < 'a' || letter > 'z') {
                isError = true;
                break;
            }
        }

        //THEN
        Assert.assertFalse(isError);
    }

    @Test
    public void generateRandomNumberGivesProperResult() {
        //GIVEN
        int min = 5;
        int max = 6;

        //WHEN
        int result = RandomGenerator.generateRandomNumber(min,max);
        System.out.println(result);


        //THEN
        assertTrue(result >= min);
        assertTrue(result <= max);

    }
}