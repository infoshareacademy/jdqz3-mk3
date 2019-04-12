package test;

import categories.CartCategory;
import generators.ScreenshotGenerator;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HandbagsCataloguePage;
import pages.MainPage;
import pages.ReviewYourOrderPage;

import java.io.IOException;

public class CartUpdating {
    private WebDriver driver;
    private MainPage mainPage;
    private ScreenshotGenerator sg;

    @Before
    public void startBrowser() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        this.sg = new ScreenshotGenerator();
    }
    @After
    public void close() throws IOException {
        sg.takesScreenshot(driver, name.getMethodName());
        mainPage.close();
    }

    @Rule
    public final TestName name = new TestName();

    @Category(CartCategory.class)
    @Test
    public void deleteFromCart(){
        mainPage.chooseHandbagsCategory();
        HandbagsCataloguePage handbagsCataloguePage = new HandbagsCataloguePage(driver);
        handbagsCataloguePage.addBagToCart();
        handbagsCataloguePage.proceedToCheckout();
        ReviewYourOrderPage reviewYourOrderPage = new ReviewYourOrderPage(driver);
        reviewYourOrderPage.clickDeleteFromCart();
        Assert.assertEquals("http://demo.shopizer.com:8080/shop/", driver.getCurrentUrl());
    }

    @Category(CartCategory.class)
    @Test
    public void deleteFromCartCataloguePage(){
        mainPage.chooseHandbagsCategory();
        HandbagsCataloguePage handbagsCataloguePage = new HandbagsCataloguePage(driver);
        handbagsCataloguePage.addBagToCart();
        handbagsCataloguePage.clickDeleteButton();
        Assert.assertEquals("Shopping cart (0)", handbagsCataloguePage.readAmountInCart());
    }

    @Category(CartCategory.class)
    @Test
    public void changeAmount(){
        mainPage.chooseHandbagsCategory();
        HandbagsCataloguePage handbagsCataloguePage = new HandbagsCataloguePage(driver);
        handbagsCataloguePage.addBagToCart();
        handbagsCataloguePage.proceedToCheckout();
        ReviewYourOrderPage reviewYourOrderPage = new ReviewYourOrderPage(driver);
        reviewYourOrderPage.changeQuantity("2");
        reviewYourOrderPage.recalculateClick();
        Assert.assertEquals("(2)", reviewYourOrderPage.readAmountInCart());
    }
}