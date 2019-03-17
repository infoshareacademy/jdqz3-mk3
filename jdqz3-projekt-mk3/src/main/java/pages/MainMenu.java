package pages;

import elements.Button;
import elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class MainMenu extends BasePage {

    private By handBagsWordSelector = By.xpath("//h2[@class='shop-banner-title lead' and text()='Handbags']");
    private Label handBagsWord;

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
}
