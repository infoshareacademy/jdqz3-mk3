package test;

import generators.RandomGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasePage;
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

    @Test
    public void changeAmount(){
        mainPage.chooseHandbagsCategory();
        HandbagsCataloguePage handbagsCataloguePage = new HandbagsCataloguePage(driver);
        handbagsCataloguePage.addBagToCart();
        handbagsCataloguePage.proceedToCheckout();
        ReviewYourOrderPage reviewYourOrderPage = new ReviewYourOrderPage(driver);
        reviewYourOrderPage.changeQuantity("2");
        reviewYourOrderPage.recalculateClick();
        Assert.assertEquals("2", reviewYourOrderPage.readAmountInCart());
    }
}
