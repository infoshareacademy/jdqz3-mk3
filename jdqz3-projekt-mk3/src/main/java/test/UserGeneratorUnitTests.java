package test;

import generators.UserGenerator;
import org.junit.Assert;
import org.junit.Test;

import static java.lang.Character.isUpperCase;

public class UserGeneratorUnitTests {

    @Test
    public void isUserFirstNameLength9() {
        Assert.assertEquals(9, UserGenerator.firstNameGenerator().length());
    }

    @Test
    public void isFirstLetterInFirstNameCapital() {
        char firstLetter = UserGenerator.firstNameGenerator().charAt(0);
        Assert.assertTrue(isUpperCase(firstLetter));
    }

    @Test
    public void isUserLastNameLength15() {
        Assert.assertEquals(15, UserGenerator.lastNameGenerator().length());
    }

    @Test
    public void isFirstLetterInLastNameCapital() {
        char firstLetter = UserGenerator.lastNameGenerator().charAt(0);
        Assert.assertTrue(isUpperCase(firstLetter));
    }

    @Test
    public void isBillingCompanyLength10() {
        Assert.assertEquals(10, UserGenerator.billingCompanyGenerator().length());
    }

    @Test
    public void isFirstLetterInBillingCompanyCapital() {
        char firstLetter = UserGenerator.billingCompanyGenerator().charAt(0);
        Assert.assertTrue(isUpperCase(firstLetter));
    }

    @Test
    public void isAtSignInEmailAddress() {
        String atSign = "@";
        Assert.assertTrue(UserGenerator.emailGenerator().contains(atSign));
    }

    @Test
    public void isPrefixInPnoneNumber() {
        String prefix = "+48";
        Assert.assertTrue(UserGenerator.phoneNumberGenerator().contains(prefix));
    }

    @Test
    public void isFiveWordsInNotes() {
        String[] words = UserGenerator.orderNotesGenerator().split(" ");
        int numberOfWords = words.length;
        Assert.assertEquals(5, numberOfWords);
    }

    @Test
    public void isPasswordLength10() {
        Assert.assertEquals(10, UserGenerator.passwordGenerator().length());
    }
}
