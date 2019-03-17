package pages;

import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    private By handbagsSelector = By.xpath("//div[contains(@class, 'mainmenu')]//a[text()='Handbags']");
    private Button handBagsCategoryTab;

    private By beachBagsSelector = By.cssSelector("div.mainmenu [href='/shop/category/beachbags.html/ref=c:50']");
    private Button beachBags;

    private By laptopBagsSelector = By.cssSelector("div.mainmenu [href='/shop/category/laptop-bags.html/ref=c:51']");
    private Button laptopBags;

    private By bagsSelector = By.cssSelector("div.mainmenu [href='/shop/category/bags.html/ref=c:51,52'");
    private Button bags;

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

    public void chooseMyAccount(){
        this.myAccountButton = new Button(driver, myAccountSelector);
        myAccountButton.safeClick();
    }

    public void chooseRegisterButton(){
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