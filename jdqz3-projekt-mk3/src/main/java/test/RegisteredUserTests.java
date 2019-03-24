package test;

import models.Address;
import models.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class RegisteredUserTests {
    private WebDriver driver;
    private MainPage mainPage;
    private Address address;
    private User user;

    @Before
    public void startBrowser() {
        driver = new ChromeDriver();
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
    public void isRegisteredUserSignedIn() {
        mainPage.logout();
        mainPage.enterSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.loginAsRegisteredUser(user);
        Assert.assertEquals(user.getFirstName(), signInPage.getRegisteredUserFirstName());
    }

    @Test
    public void isRegisteredUserLoggedOut() {
        mainPage.logout();
        mainPage.enterSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.loginAsRegisteredUser(user);
        AccountPage accountPage = new AccountPage(driver);
        accountPage.logoutUser();
        Assert.assertNotEquals(user.getFirstName(), mainPage.getMyAccountText());
    }

    @Test
    public void isPasswordChangedToTheSamePassword() {
        AccountPage accountPage = new AccountPage(driver);
        accountPage.goToChangePasswordPage();
        ChangePasswordPage changePasswordPage = new ChangePasswordPage(driver);
        changePasswordPage.fillNewPasswordWithTheSameValues(user);
        Assert.assertNotEquals("Invalid password", changePasswordPage.readPasswordMessage());
    }

    @Test
    public void isEmptyPasswordNotAccepted() {
        AccountPage accountPage = new AccountPage(driver);
        accountPage.goToChangePasswordPage();
        ChangePasswordPage changePasswordPage = new ChangePasswordPage(driver);
        changePasswordPage.fillNewPasswordWithEmptyValues(user);
        Assert.assertEquals("Please provide a new password", changePasswordPage.readEmptyPasswordMessage());
    }

//    @Test
//    public void isPasswordChanged() {
//
//    }
}
