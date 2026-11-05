package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SetValueOptions;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private final SelenideElement usernameInputField = $("#user-name");
    private final SelenideElement passwordInputField = $("#password");
    private final SelenideElement loginBtn = $("#login-button");
    private final SelenideElement errorAlert = $("[data-test='error']");

    @Step("Open login page")
    public LoginPage openPage() {
        open("/");
        return this;
    }

    @Step("Set username")
    public LoginPage insertUsername(String login) {
        usernameInputField.setValue(login);
        return this;
    }

    //Method doesn't have annotation for password not to leak to the report json
    public LoginPage insertPassword(String password) {
        Allure.step("Set password", () -> {
            passwordInputField.setValue(
                    SetValueOptions.withText(password).sensitive()
            );
        });
        return this;
    }

    @Step("Click login button")
    public LoginPage clickLoginBtn() {
        loginBtn.click();
        return this;
    }

    @Step("Check error message {0} is shown")
    public LoginPage shouldHaveError(String text) {
        errorAlert.shouldBe(visible).shouldHave(exactText(text));
        return this;
    }
}