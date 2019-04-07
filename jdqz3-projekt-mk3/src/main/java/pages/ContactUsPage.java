package pages;

import elements.Button;
import elements.Label;
import elements.TextInput;
import generators.RandomGenerator;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends BasePage {

    private By nameSelector = By.cssSelector("#name");
    private TextInput name;

    private By emailAddressSelector = By.cssSelector("#email");
    private TextInput email;

    private By subjectSelector = By.cssSelector("#subject");
    private TextInput subject;

    private By commentsSelector = By.cssSelector("#comment");
    private TextInput comments;

//    private By captchaSelector = By.cssSelector("div.rc-anchor-center-item.rc-anchor-checkbox-holder span");
    private By captchaSelector = By.cssSelector("div.rc-anchor-center-container");
    private Button captcha;

    private By sendSelector = By.cssSelector("#submitContact");
    private Button send;

    private By messageSelector = By.cssSelector(".alert-success");
    private Label message;

    public ContactUsPage(WebDriver driver) {

        super(driver);
        this.name = new TextInput(driver,nameSelector);
        this.email = new TextInput(driver,emailAddressSelector);
        this.subject = new TextInput(driver,subjectSelector);
        this.comments = new TextInput(driver,commentsSelector);

    }

    private void insertName(User user) {
        this.name.fillingField(user.getFirstName() + " " + user.getLastName());
    }

    private void insertEmail(User user) {
        this.email.fillingField(user.getEmail());
    }

    public void fillInContactForm(User user){
        insertName(user);
        insertEmail(user);

    }

    public void insertSubject() {
        this.subject.fillingField("ddd");
    }

    public void insertComments(){
        this.comments.fillingField("ddd");
    }

    public void clickCaptcha(){
        this.captcha = new Button(driver, captchaSelector);
        captcha.click();
    }

    public void clickSend(){
        this.send = new Button(driver,sendSelector);
        send.click();
    }

    public String isCorectMessage() {
        this.message = new Label(driver,messageSelector);
        String messageForCorrectAnswer = message.readLabel();
        return messageForCorrectAnswer;
    }

}
