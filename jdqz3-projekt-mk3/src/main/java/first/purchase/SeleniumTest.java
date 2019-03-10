package first.purchase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {

    private WebDriver driver;
    private PurchaseSelectors inventoryOfElement;
    private String url;

    @Before
    public void startBrowser() {
        inventoryOfElement = new PurchaseSelectors();
        url = "http://demo.shopizer.com:8080/shop";
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        JavascriptExecutor runner = (JavascriptExecutor)driver;
        wait.until((ExpectedCondition<Boolean>) driver -> (runner.executeScript("return document.readyState").equals("complete")));
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void purchase() {
        driver.get(url);
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement beachBag = driver.findElement(By.xpath(inventoryOfElement.getBeachBagsLink()));
        beachBag.click();

        WebElement retroStyleBag = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(inventoryOfElement.getRetroStyleBag())));
        retroStyleBag.click();

        WebElement shoppingCart = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(inventoryOfElement.getShoppingCart())));
        Actions cartActions = new Actions(driver);
        cartActions.moveToElement(shoppingCart).build().perform();

        WebElement checkout = wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector(inventoryOfElement.getCheckout()))));
        Actions checkoutActions = new Actions(driver);
        checkoutActions.moveToElement(checkout).click().build().perform();

        WebElement proceedToCheckout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(inventoryOfElement.getProceedToCheckout())));
        Actions proceedActions = new Actions(driver);
        proceedActions.moveToElement(proceedToCheckout).click().build().perform();

        WebElement firstName = wait.until(ExpectedConditions.elementToBeClickable((By.xpath(inventoryOfElement.getFirstName()))));
        firstName.sendKeys("Random Firstname");

        WebElement lastName = wait.until(ExpectedConditions.elementToBeClickable((By.xpath(inventoryOfElement.getLastName()))));
        lastName.sendKeys("Random Surname");

        WebElement billingCompany = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(inventoryOfElement.getBillingCompany())));
        billingCompany.sendKeys("Billing Company");

        WebElement address = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(inventoryOfElement.getAddress())));
        address.sendKeys("Any address 1/2");

        WebElement city = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(inventoryOfElement.getCity())));
        city.clear();
        city.sendKeys("Any city");

        Select country = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(inventoryOfElement.getCountry()))))        ;
        country.selectByVisibleText("Belgium");

        WebElement stateProvince = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(inventoryOfElement.getStateProvince())));
        stateProvince.sendKeys("pomorskie");

        WebElement postalCode = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(inventoryOfElement.getPostalCode())));
        postalCode.sendKeys("12-345");

        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(inventoryOfElement.getEmailAddress())));
        email.sendKeys("testemail@testemail.com");

        WebElement phoneNumber = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(inventoryOfElement.getPhoneNumber())));
        phoneNumber.sendKeys("+48 111222111");

        WebElement submitOrder = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(inventoryOfElement.getSubmitOrder())));
        Actions submitActions = new Actions(driver);
        submitActions.moveToElement(submitOrder).click().build().perform();
    }
}