package test;

import categories.UserCategory;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import models.Address;
import models.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.SignInPage;

@RunWith(JUnitParamsRunner.class)
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
    public void signInWithoutCredentials() {
        mainPage.enterSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clickSignInButton();
        Assert.assertEquals("Login Failed. Username or Password is incorrect.", signInPage.isMessageForEmptyCredentialsCorrect());
    }

    @Category(UserCategory.class)
    @Parameters({" , ", "NotExistingLogin, NotExistingPassword"})
    @Test
    public void signInWithIncorrectCredentials(String email, String password) {
        mainPage.enterSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.notExistingEmail(email);
        signInPage.notExistingPassword(password);
        signInPage.clickSignInButton();
        Assert.assertEquals("Login Failed. Username or Password is incorrect.", signInPage.isMessageForEmptyCredentialsCorrect());
    }
}
