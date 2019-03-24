package pages;

import elements.Button;
import elements.Label;
import elements.TextInput;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePasswordPage extends BasePage {

    private TextInput currentPassword;
    private By currentPasswordSelector = By.cssSelector("input[name='currentPassword']");

    private TextInput newPassword;
    private By newPasswordSelector = By.cssSelector("input[name='password']");

    private TextInput repeatPassword;
    private By repeatPasswordSelector = By.cssSelector("input[name='checkPassword']");

    private Button changePassword;
    private By changePasswordSelector = By.cssSelector("input[name='changePassword'");

    private Label passwordMessage;
    private By passwordMessageSelector = By.xpath("//div[@id='password.errors']");

    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    public void fillPasswordChangeForm(User user) {
        this.currentPassword = new TextInput(driver, currentPasswordSelector);
        String oldPassword = user.getPassword();
        currentPassword.fillingField(oldPassword);

        String newlyGeneratedPassword = user.getPassword();
        this.newPassword = new TextInput(driver, newPasswordSelector);
        newPassword.fillingField(newlyGeneratedPassword);
        this.repeatPassword = new TextInput(driver, repeatPasswordSelector);
        repeatPassword.fillingField(newlyGeneratedPassword);

    }

    public void confirmPasswordChange() {
        this.changePassword = new Button(driver, changePasswordSelector);
        changePassword.click();
    }

    public void changePassword(User user) {
        fillPasswordChangeForm(user);
        confirmPasswordChange();
    }

    public String readPasswordMessage() {
        this.passwordMessage = new Label(driver, passwordMessageSelector);
        return passwordMessage.readLabel();
    }

}
