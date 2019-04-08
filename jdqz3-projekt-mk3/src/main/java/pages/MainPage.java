package pages;

import elements.Button;
import elements.TextInput;
import models.Bag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    private By handbagsSelector = By.xpath("//div[contains(@class, 'mainmenu')]//a[text()='Handbags']");
    private Button handBagsCategoryTab;

    private By myAccountSelector = By.cssSelector("li.click_menu");
    private Button myAccountButton;

    private By registerSelector = By.xpath("//div[contains(@class, 'header-top-left')]//a[text()='Register']");
    private Button registerButton;

    private By signInSelector = By.xpath("//a[@id='registerLink' and contains(text(),'Sign in')]");
    private Button signInButton;

    public MainPage(WebDriver driver) {
        super(driver);
        this.url = "http://demo.shopizer.com:8080/shop/";
        this.driver.get(this.url);
        this.handBagsCategoryTab = new Button(this.driver, this.handbagsSelector);
    }

    public void chooseHandbagsCategory(){
        this.handBagsCategoryTab.click();
    }

    private void chooseMyAccount(){
        this.myAccountButton = new Button(driver, myAccountSelector);
        myAccountButton.safeClick();
    }

    private void chooseRegisterButton(){
        this.registerButton = new Button(driver, registerSelector);
        registerButton.clickWithJs();
    }

    public void chooseSignInLink() {
        this.signInButton = new Button(driver, signInSelector);
        signInButton.click();
    }

    public void enterRegistrationPage(){
        chooseMyAccount();
        chooseRegisterButton();
    }

    public void enterSignInPage(){
        chooseMyAccount();
        chooseSignInLink();
    }
}