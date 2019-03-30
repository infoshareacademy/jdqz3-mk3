package pages;

import elements.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends BasePage {

    private By nameSelector = By.cssSelector("div.controls input[title='Name is required']");
    private TextInput name;

    private By emailAddressSelector = By.cssSelector("div.controls input[name='email']");
    private TextInput email;

    private By subjectSelector = By.cssSelector("div.controls input[name='subject']");
    private TextInput subject;

    private By commentsSelector = By.cssSelector("div.controls input[name='comment']");
    private TextInput comments;

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

}
