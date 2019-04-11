package test;

import categories.CatalogueCategory;
import generators.ScreenshotGenerator;
import models.User;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ContactUsPage;
import pages.HandbagsCataloguePage;
import pages.MainMenu;
import pages.MainPage;

import java.io.IOException;

public class CatalogueTests{

    private WebDriver driver;
    private MainPage mainPage;
    private User user;
    private ScreenshotGenerator sg;

    @Before
    public void startBrowser() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
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

    @Category(CatalogueCategory.class)
    @Test
    public void chooseAllCatalogue() {
        Assert.assertTrue(mainPage.menu.isHandbagpresent());
        Assert.assertTrue(mainPage.menu.isBeachBagsPresent());
        Assert.assertTrue(mainPage.menu.isLaptopBagsPresent());
        Assert.assertTrue(mainPage.menu.isBagsPresent());
    }

    @Category(CatalogueCategory.class)
    @Test
    public void contactUsCatalogue(){
        mainPage.chooseContactUs();
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.fillInContactForm(user);
        contactUsPage.insertSubject();
        contactUsPage.insertComments();
        contactUsPage.clickCaptcha();
        contactUsPage.clickSend();
        Assert.assertEquals("Your message has been sent", contactUsPage.isCorectMessage());
    }
}
