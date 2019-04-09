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
import pages.*;

public class RegisteredUserTests {
    private WebDriver driver;
    private MainPage mainPage;
    private Address address;
    private User user;
    private User user2;

    @Before
    public void startBrowser() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        this.address = new Address();
        this.user = new User();
        this.user2 = new User();
        mainPage.enterRegistrationPage();
        Register registerPage = new Register(driver);
        registerPage.fillInRegistrationForm(user, address);
        registerPage.clickCreateAnAccButton();
    }

    @After
    public void close() {
        mainPage.close();
    }

    @Category(UserCategory.class)
    @Test
    public void isRegisteredUserSignedIn() {
        mainPage.logout();
        mainPage.enterSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.loginAsRegisteredUser(user);
        Assert.assertEquals(user.getFirstName(), signInPage.getRegisteredUserFirstName());
    }

    @Category(UserCategory.class)
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

    @Category(UserCategory.class)
    @Test
    public void isPasswordChangedToTheSamePassword() {
        AccountPage accountPage = new AccountPage(driver);
        accountPage.goToChangePasswordPage();
        ChangePasswordPage changePasswordPage = new ChangePasswordPage(driver);
        changePasswordPage.fillNewPasswordWithTheSameValues(user);
        Assert.assertNotEquals("Invalid password", changePasswordPage.readPasswordMessage());
    }

    @Category(UserCategory.class)
    @Test
    public void isEmptyPasswordNotAccepted() {
        AccountPage accountPage = new AccountPage(driver);
        accountPage.goToChangePasswordPage();
        ChangePasswordPage changePasswordPage = new ChangePasswordPage(driver);
        changePasswordPage.fillNewPasswordWithEmptyValues(user);
        Assert.assertEquals("Please provide a new password", changePasswordPage.readEmptyPasswordMessage());
    }

    @Category(UserCategory.class)
    @Test
    public void isPasswordChanged() {
        AccountPage accountPage = new AccountPage(driver);
        accountPage.goToChangePasswordPage();
        ChangePasswordPage changePasswordPage = new ChangePasswordPage(driver);
        changePasswordPage.fillNewPasswordWithValues(user, user2);
        Assert.assertNotEquals("Invalid password", changePasswordPage.readPasswordMessage());
    }

    @Category(UserCategory.class)
    @Test
    public void isShippingAddressAdded() {
        AccountPage accountPage = new AccountPage(driver);
        accountPage.goToBillingAndShippingInformation();
        accountPage.clickAddANewAddress();
        BillingShippingPage billingShippingPage = new BillingShippingPage(driver);
        billingShippingPage.fillShippingAddress(user, address);
        Assert.assertEquals("Request completed with success", billingShippingPage.successMessage());
    }
}
