package test;

import models.Address;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.Register;
import pages.SignInPage;

public class RegisteredUserTests {
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
        mainPage.enterRegistrationPage();
        Register registerPage = new Register(driver);
        registerPage.fillInRegistrationForm(user, address);
        registerPage.clickCreateAnAccButton();
    }

    @After
    public void close() {
        mainPage.close();
    }

    @Test
    public void isRegisteredUserLogged() {
        mainPage.logout();
        mainPage.enterSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.loginAsRegisteredUser(user);
        //Assert
    }
}
