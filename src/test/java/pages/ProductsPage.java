package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

public class ProductsPage {
    private final SelenideElement productPageTitle = $("[data-test='title']");

    @Step("Product page should have title {0}")
    public ProductsPage shouldHaveTitle(String titleText) {
        productPageTitle.shouldHave(exactText(titleText));
        return this;
    }
}