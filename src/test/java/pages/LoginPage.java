package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private final String url = "https://www.saucedemo.com/";

    private final SelenideElement usernameInputField = $("#user-name");
    private final SelenideElement passwordInputField = $("#password");
    private final SelenideElement loginBtn = $("#login-button");
    private final SelenideElement errorAlert = $("[data-test='error']");

    public LoginPage openPage() {
        open(this.url);
        return this;
    }

    public LoginPage insertUsername(String login) {
        usernameInputField.setValue(login);
        return this;
    }

    public LoginPage insertPassword(String password) {
        passwordInputField.setValue(password);
        return this;
    }

    public LoginPage clickLoginBtn() {
        loginBtn.click();
        return this;
    }

    public LoginPage shouldHaveError(String text) {
        errorAlert.shouldBe(visible).shouldHave(exactText(text));
        return this;
    }
}