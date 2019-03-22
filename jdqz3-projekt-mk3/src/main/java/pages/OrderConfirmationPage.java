package pages;

import elements.Button;
import elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage extends BasePage {
    private By orderConfirmation = By.xpath("//div[@id='main-content']//h1");
    private Label orderConfirmationLabel;

    private By myAccountSelector = By.cssSelector("li.click_menu");
    private Button myAccountButton;

    private By signInSelector = By.xpath("//a[@id='registerLink' and contains(text(),'Sign in')]");
    private Button signInButton;


    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
        this.orderConfirmationLabel = new Label(driver, orderConfirmation);
    }

    public String orderConfirmationLabel() {
        return this.orderConfirmationLabel.readLabel();
    }

    public void chooseMyAccount() {
        this.myAccountButton = new Button(driver, myAccountSelector);
        myAccountButton.safeClick();
    }

    public void chooseSignInLink() {
        chooseMyAccount();
        this.signInButton = new Button(driver, signInSelector);
        signInButton.click();
    }

}


