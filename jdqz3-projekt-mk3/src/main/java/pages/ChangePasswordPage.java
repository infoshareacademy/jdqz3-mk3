package pages;

import elements.Button;
import elements.TextInput;
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

    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

}
