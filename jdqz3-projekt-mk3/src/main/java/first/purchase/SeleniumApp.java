package first.purchase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumApp {

    public static void main(String[] args) {

        PurchaseSelectors selectors = new PurchaseSelectors();

        String url = "http://demo.shopizer.com:8080/shop";
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement beachBag = driver.findElement(By.xpath(selectors.getBeachBagsLink()));
        beachBag.click();

        WebElement retroStyleBag = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selectors.getRetroStyleBag())));
        retroStyleBag.click();

        WebElement shoppingCart = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selectors.getShoppingCart())));
        Actions cartActions = new Actions(driver);
        cartActions.moveToElement(shoppingCart).build().perform();

        WebElement checkout = wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector(selectors.getCheckout()))));
        Actions checkoutActions = new Actions(driver);
        checkoutActions.moveToElement(checkout).click().build().perform();

        WebElement proceedToCheckout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selectors.getProceedToCheckout())));
        Actions proceedActions = new Actions(driver);
        proceedActions.moveToElement(proceedToCheckout).click().build().perform();

        WebElement firstName = wait.until(ExpectedConditions.elementToBeClickable((By.xpath(selectors.getFirstName()))));
        firstName.sendKeys("Random Firstname");

        WebElement lastName = wait.until(ExpectedConditions.elementToBeClickable((By.xpath(selectors.getLastName()))));
        lastName.sendKeys("Random Surname");

        WebElement billingCompany = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selectors.getBillingCompany())));
        billingCompany.sendKeys("Billing Company");

        WebElement address = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selectors.getAddress())));
        address.sendKeys("Any address 1/2");

        WebElement city = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selectors.getCity())));
        city.clear();
        city.sendKeys("Any city");

        Select country = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selectors.getCountry()))))        ;
        country.selectByVisibleText("Belgium");

        WebElement stateProvince = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selectors.getStateProvince())));
        stateProvince.sendKeys("pomorskie");

        WebElement postalCode = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selectors.getPostalCode())));
        postalCode.sendKeys("12-345");

        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selectors.getEmailAddress())));
        email.sendKeys("testemail@testemail.com");

        WebElement phoneNumber = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selectors.getPhoneNumber())));
        phoneNumber.sendKeys("+48 111222111");

        WebElement submitOrder = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selectors.getSubmitOrder())));
        Actions submitActions = new Actions(driver);
        submitActions.moveToElement(submitOrder).click().build().perform();

        driver.quit();
    }
}