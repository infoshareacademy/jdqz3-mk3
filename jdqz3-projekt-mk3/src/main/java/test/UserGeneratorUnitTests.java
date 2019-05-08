package test;

import generators.UserGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static java.lang.Character.isUpperCase;

public class UserGeneratorUnitTests {
//    private UserGenerator userGenerator;
//
//    @Before
//    public void setUp() {
//        userGenerator = new UserGenerator();
//    }

    @Test
    public void isUserFirstNameLength9() {
        Assert.assertEquals(9, UserGenerator.firstNameGenerator().length());
    }

    @Test
    public void isUserLastNameLength15() {
        Assert.assertEquals(15, UserGenerator.lastNameGenerator().length());
    }

    @Test
    public void isFirstLetterInFirstNameCapital() {
        char firstLetter = UserGenerator.firstNameGenerator().charAt(0);
        Assert.assertTrue(isUpperCase(firstLetter));
    }

    @Test
    public void isFirstLetterInLastNameCapital() {
        char firstLetter = UserGenerator.lastNameGenerator().charAt(0);
        Assert.assertTrue(isUpperCase(firstLetter));
    }

    @Test
    public void isFiveWordsInNotes() {
        String[] words = UserGenerator.orderNotesGenerator().split(" ");
        int numberOfWords = words.length;
        Assert.assertEquals(5, numberOfWords);
    }
}
