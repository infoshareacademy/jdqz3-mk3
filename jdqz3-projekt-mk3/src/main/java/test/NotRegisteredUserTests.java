package test;

import categories.UserCategory;
import models.Address;
import models.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.SignInPage;

public class NotRegisteredUserTests {
    private WebDriver driver;
    private MainPage mainPage;
    private Address address;
    private User user;

    @Before
    public void startBrowser() {
        driver = new ChromeDriver();
        //
        mainPage = new MainPage(driver);
        this.address = new Address();
        this.user = new User();
    }

    @After
    public void close() {
        mainPage.close();
    }

    @Category(UserCategory.class)
    @Test
    public void checkMessageWhenSignInWithoutCredentials() {
        mainPage.enterSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clickSignInButton();
        Assert.assertEquals("Login Failed. Username or Password is incorrect.", signInPage.isMessageForEmptyCredentialsCorrect());
    }

}
