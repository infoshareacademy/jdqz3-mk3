package pages;

import elements.Button;
import elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class MainMenu extends BasePage {

    private By handBagSelector = By.xpath("//div[contains(@class, 'mainmenu')]//a[text()='Handbags']");
    private Button handBags;
    private By handBagsWordSelector = By.xpath("//div[contains(@class, 'mainmenu')]//a[text()='Handbags']");
    private Label handBagsWord;
    private By beachBagsWordSelector = By.xpath("//div[contains(@class, 'mainmenu')]//a[text()='Beach bags']");
    private Label beachBagsWord;
    private By laptopBagsWordSelector = By.xpath("//div[contains(@class, 'mainmenu')]//a[text()='Laptop bags']");
    private Label laptopBagsWord;
    private By bagsWordSelector = By.xpath("//div[contains(@class, 'mainmenu')]//a[text()='Bags']");
    private Label bagsWord;

    public MainMenu(WebDriver driver) {
        super(driver);

    }
    public boolean isHandbagpresent() {
        try {
            this.handBagsWord = new Label(this.driver, this.handBagsWordSelector);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    public boolean isBeachBagsPresent() {
        try {
            this.beachBagsWord = new Label(this.driver, this.beachBagsWordSelector);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    public boolean isLaptopBagsPresent() {
        try {
            this.laptopBagsWord = new Label(this.driver, this.laptopBagsWordSelector);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    public boolean isBagsPresent() {
        try {
            this.bagsWord = new Label(this.driver, this.bagsWordSelector);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    public void clickHandBagCategory(){
        this.handBags = new Button(driver, handBagSelector);
        handBags.click();
    }
}
