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
    }

    public void fillPasswordChangeFormWithTeSamePassword(User user) {
        this.currentPassword = new TextInput(driver, currentPasswordSelector);
        currentPassword.fillingField(user.getPassword());
        this.newPassword = new TextInput(driver, newPasswordSelector);
        newPassword.fillingField(user.getPassword());
        this.repeatPassword = new TextInput(driver, repeatPasswordSelector);
        repeatPassword.fillingField(user.getPassword());
    }

    public void fillPasswordFormWithEmptyValues(User user) {
        this.currentPassword = new TextInput(driver, currentPasswordSelector);
        currentPassword.fillingField(user.getPassword());
        this.newPassword = new TextInput(driver, newPasswordSelector);
        newPassword.fillingField("");
        this.repeatPassword = new TextInput(driver, repeatPasswordSelector);
        repeatPassword.fillingField("");
    }

    public void confirmPasswordChange() {
        this.changePassword = new Button(driver, changePasswordSelector);
        changePassword.click();
    }

    public void fillNewPasswordWithTheSameValues(User user) {
        fillPasswordChangeFormWithTeSamePassword(user);
        confirmPasswordChange();
    }

    public void fillNewPasswordWithEmptyValues(User user) {
        fillPasswordFormWithEmptyValues(user);
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
