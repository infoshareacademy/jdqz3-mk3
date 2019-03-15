package pages;

import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HandbagsCataloguePage extends BasePage {

    private By chicVinategDeVillleBagSelector = By.cssSelector("div#productsContainer div[item-name='Chic vintage DeVille'] div.store-btn-addtocart");
    private By shoppingCart = By.cssSelector("div#miniCartSummary span");
    private By checkout = By.cssSelector("li.checkout-bg a");
    private Button addToCartButton;
    private Button shoppingCartButton;
    private Button checkoutButton;


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
}