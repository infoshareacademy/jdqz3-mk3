package test;

import categories.UserCategory;
import generators.ScreenshotGenerator;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import models.Address;
import models.User;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.SignInPage;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

//@RunWith(JUnitParamsRunner.class)
public class NotRegisteredUserTests {
    private WebDriver driver;
    private MainPage mainPage;
    private Address address;
    private User user;
    private ScreenshotGenerator sg;

    @Before
    public void startBrowser() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        this.address = new Address();
        this.user = new User();
        this.sg = new ScreenshotGenerator();
    }

    @After
    public void close() throws IOException {
        sg.takesScreenshot(driver, name.getMethodName());
        mainPage.close();
    }

    @Rule
    public final TestName name = new TestName();

    @Category(UserCategory.class)
    @Test
    public void signInWithoutCredentials() {
        mainPage.enterSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clickSignInButton();
        Assert.assertEquals("Login Failed. Username or Password is incorrect.", signInPage.isMessageForEmptyCredentialsCorrect());
    }

//    Below test is commented out because parametrized tests cause error wen running from suite

//    @Category(UserCategory.class)
//    @Parameters({" , ", "NotExistingLogin, NotExistingPassword"})
//    @Test
//    public void signInWithIncorrectCredentials(String email, String password) {
//        mainPage.enterSignInPage();
//        SignInPage signInPage = new SignInPage(driver);
//        signInPage.notExistingEmail(email);
//        signInPage.notExistingPassword(password);
//        signInPage.clickSignInButton();
//        assertThat(signInPage.isMessageForEmptyCredentialsCorrect()).isEqualTo("Login Failed. Username or Password is incorrect.");
//    }
}
