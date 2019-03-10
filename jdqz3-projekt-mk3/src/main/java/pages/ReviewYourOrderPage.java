package pages;

import elements.Button;
import elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReviewYourOrderPage extends BasePage{
    private By proceedToCheckout = By.xpath("//a[contains(text(), 'Proceed to checkout')]");
    private Button proceedToCheckoutButton;
    private By bagName = By.cssSelector("#mainCartTable>tbody>tr>td>div>div>span>strong");
    private Label bagNameLabel;
    private By bagPrice = By.xpath("//table[@id='mainCartTable']//td[3]//strong");
    private Label bagPriceLabel;


    public ReviewYourOrderPage(WebDriver driver) {
        super(driver);
        this.proceedToCheckoutButton = new Button(driver, proceedToCheckout);
        this.bagNameLabel = new Label(driver, bagName);
        this.bagPriceLabel = new Label(driver, bagPrice);
    }

    public void orderToCheckout() {
        this.proceedToCheckoutButton.click();
    }

    public String isCartContentCorrect() {
        String bagName = bagNameLabel.readLabel();
        return bagName;
    }
    public String isPriceInCartCorect() {
        String bagPrice = bagPriceLabel.readLabel();
        return bagPrice;
    }
}