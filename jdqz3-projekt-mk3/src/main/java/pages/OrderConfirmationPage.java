package pages;

import elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage extends BasePage {
    private By orderConfirmation = By.xpath("//div[@id='main-content']//h1");
    private Label orderConfirmationLabel;


    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
        this.orderConfirmationLabel = new Label(driver, orderConfirmation);
    }

    public String orderConfirmationLabel() {
        return this.orderConfirmationLabel.readLabel();
    }
}