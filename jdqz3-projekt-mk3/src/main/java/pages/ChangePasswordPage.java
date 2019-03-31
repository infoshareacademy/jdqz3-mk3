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

    private Label emptyPasswordMessage;
    private By emptyPasswordMessageSelector = By.xpath("//div[@id='formError']");

    public ChangePasswordPage(WebDriver driver) {
        super(driver);
        this.currentPassword = new TextInput(driver, currentPasswordSelector);
        this.newPassword = new TextInput(driver, newPasswordSelector);
        this.repeatPassword = new TextInput(driver, repeatPasswordSelector);
    }

    public void fillCurrentPassword(User user) {
        currentPassword.fillingField(user.getPassword());
    }

    public void fillNewPassword(User user) {
        newPassword.fillingField(user.getPassword());
    }

    public void fillRepeatPassword(User user) {
        repeatPassword.fillingField(user.getPassword());
    }

    public void newPasswordWithEmptyValue(User user) {
        newPassword.fillingField("");
    }

    public void repeatPasswordWithEmptyValue(User user) {
        repeatPassword.fillingField("");
    }

    public void fillPasswordFormWithTeSamePassword(User user) {
        fillCurrentPassword(user);
        fillNewPassword(user);
        fillRepeatPassword(user);
    }

    public void fillPasswordFormWithEmptyValues(User user) {
        fillCurrentPassword(user);
        newPasswordWithEmptyValue(user);
        repeatPasswordWithEmptyValue(user);
    }

    public void fillPasswordForm(User user, User user2) {
        fillCurrentPassword(user);
        fillNewPassword(user2);
        fillRepeatPassword(user2);
    }

    public void confirmPasswordChange() {
        this.changePassword = new Button(driver, changePasswordSelector);
        changePassword.click();
    }

    public void fillNewPasswordWithTheSameValues(User user) {
        fillPasswordFormWithTeSamePassword(user);
        confirmPasswordChange();
    }

    public void fillNewPasswordWithEmptyValues(User user) {
        fillPasswordFormWithEmptyValues(user);
    }

    public void fillNewPasswordWithValues(User user, User user2) {
        fillPasswordForm(user, user2);
        confirmPasswordChange();
    }

    public String readPasswordMessage() {
        this.passwordMessage = new Label(driver, passwordMessageSelector);
        return passwordMessage.readLabel();
    }

    public String readEmptyPasswordMessage() {
        this.emptyPasswordMessage = new Label(driver, emptyPasswordMessageSelector);
        return emptyPasswordMessage.readLabel();
    }
}
