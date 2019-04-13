package pages;

import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected String url;
    protected String window;

    private By myUserAccountSelector = By.cssSelector("li.click_menu");
    private Button myAccountButton;

    private By myAccSelector = By.xpath("//div[contains(@class, 'header-top-left')]//a[text()='My Account']");
    private Button myAccButton;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        if (this.window == null) {
            window = this.driver.getWindowHandle();
        }
        this.driver.manage().window().maximize();
        waitForPage();
    }

    private void waitForPage() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        JavascriptExecutor runner = (JavascriptExecutor)driver;
        wait.until((ExpectedCondition<Boolean>) driver -> (runner.executeScript("return document.readyState").equals("complete")));
    }

    public void close() {
        this.driver.quit();
    }

    private void chooseMyUserAccount(){
        this.myAccountButton = new Button(driver, myUserAccountSelector);
        myAccountButton.safeClick();
    }

    private void chooseMyAccButton(){
        this.myAccButton = new Button(driver, myAccSelector);
        myAccButton.clickWithJs();
    }
    public void gotToMyAcc(){
        chooseMyUserAccount();
        chooseMyAccButton();
    }
}