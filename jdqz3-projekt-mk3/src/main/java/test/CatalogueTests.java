package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HandbagsCataloguePage;
import pages.MainMenu;
import pages.MainPage;

public class CatalogueTests{

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


    @Test
    public void chooseAllCatalogue() {
        mainPage.chooseHandbagsCategory();
        HandbagsCataloguePage handbagsCataloguePage = new HandbagsCataloguePage(driver);
        Assert.assertTrue(handbagsCataloguePage.menu.isHandbagpresent());
        Assert.assertTrue(handbagsCataloguePage.menu.isBeachBagsPresent());
        Assert.assertTrue(handbagsCataloguePage.menu.isLaptopBagsPresent());
        Assert.assertTrue(handbagsCataloguePage.menu.isBagsPresent());
    }

    @Test
    public void contactUsCatalogue(){
        mainPage.chooseContactUs();

    }

}
