package pages;

import elements.Button;
import elements.Label;
import elements.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReviewYourOrderPage extends BasePage{
    private By proceedToCheckout = By.xpath("//a[contains(text(), 'Proceed to checkout')]");
    private Button proceedToCheckoutButton;
    private By bagName = By.cssSelector("#mainCartTable>tbody>tr>td>div>div>span>strong");
    private Label bagNameLabel;
    private By bagPrice = By.xpath("//table[@id='mainCartTable']//td[3]//strong");
    private Label bagPriceLabel;

    private By deleteItem = By.cssSelector("a.removeProductIcon");
    private Button deleteItemButton;
    private By amountInCart = By.cssSelector("#miniCartSummary strong");
    private Label amountInCartLabel;
    private By quantity = By.cssSelector("input[name='quantity']");
    private TextInput quantityInput;
    private By recalculate = By.xpath("//a[text()='Recalculate']");
    private Button recalculateButtom;

    public ReviewYourOrderPage(WebDriver driver) {
        super(driver);
        this.proceedToCheckoutButton = new Button(driver, proceedToCheckout);
        this.bagNameLabel = new Label(driver, bagName);
        this.bagPriceLabel = new Label(driver, bagPrice);
        this.deleteItemButton = new Button(driver, deleteItem);
        this.amountInCartLabel = new Label(driver, amountInCart);
        this.quantityInput = new TextInput(driver, quantity);
        this.recalculateButtom = new Button(driver,recalculate);
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
    public void clickDeleteFromCart()
    {
        this.deleteItemButton.click();
    }

    public String readAmountInCart() {
        String amountInCart = amountInCartLabel.readLabel();
        return amountInCart;
    }

    public String changeQuantity(String newQuantity){
        this.quantityInput = quantityInput.fillingField(newQuantity);
        return newQuantity;
    }

    public void recalculateClick(){
        this.recalculateButtom.clickWithJs();
    }


}