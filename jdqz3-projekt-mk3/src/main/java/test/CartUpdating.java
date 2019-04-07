package test;

import categories.CartCategory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HandbagsCataloguePage;
import pages.MainPage;
import pages.ReviewYourOrderPage;

public class CartUpdating {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void startBrowser() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
    }

    @After
    public void close() {
        mainPage.close();
    }

    @Category(CartCategory.class)
    @Test
    public void deleteFromCart(){
        mainPage.chooseHandbagsCategory();
        HandbagsCataloguePage handbagsCataloguePage = new HandbagsCataloguePage(driver);
        handbagsCataloguePage.addBagToCart();
        handbagsCataloguePage.proceedToCheckout();
        ReviewYourOrderPage reviewYourOrderPage = new ReviewYourOrderPage(driver);
        reviewYourOrderPage.clickDeleteFromCart();
        //TODO add assertion after fixing the bug
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
