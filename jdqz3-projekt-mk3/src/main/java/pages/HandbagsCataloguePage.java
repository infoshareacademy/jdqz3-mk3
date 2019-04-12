package pages;

import elements.Button;
import elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class HandbagsCataloguePage extends BasePage {

    private By chicVinategDeVillleBagSelector = By.cssSelector("div#productsContainer div[item-name='Chic vintage DeVille'] div.store-btn-addtocart");
    private By shoppingCart = By.cssSelector("div#miniCartSummary span");
    private By checkout = By.cssSelector("li.checkout-bg a");
    private Button addToCartButton;
    private Button shoppingCartButton;
    private Button checkoutButton;
    private By deleteSelector = By.cssSelector(".removeProductIcon");
    private Button deleteButton;
    private By amountInCart = By.cssSelector("#miniCartSummary a");
    private Label amountInCartLabel;

    public HandbagsCataloguePage(WebDriver driver) {
        super(driver);
        this.addToCartButton = new Button(this.driver, this.chicVinategDeVillleBagSelector);
        this.shoppingCartButton = new Button(this.driver, this.shoppingCart);
    }

    public void addBagToCart() {
        this.addToCartButton.click();
    }

    public void proceedToCheckout() {
        this.shoppingCartButton.safeClick();
        this.checkoutButton = new Button(this.driver, this.checkout);
        this.checkoutButton.clickWithJs();
    }
    public void clickDeleteButton(){
        this.shoppingCartButton.safeClick();
        this.deleteButton = new Button(this.driver, this.deleteSelector);
        this.deleteButton.clickWithJs();
        for (int i = 100; i>0; i--){
            if (Objects.equals("(1)", this.amountInCartLabel = new Label(driver, amountInCart))){
                System.out.println("waiting");
            }
        }
    }
    public String readAmountInCart() {
        this.amountInCartLabel = new Label(driver, amountInCart);
        String amountInCart = amountInCartLabel.readLabel();
        return amountInCart;
    }
}