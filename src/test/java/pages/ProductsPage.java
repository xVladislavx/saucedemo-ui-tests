package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

public class ProductsPage {
    private final SelenideElement productPageTitle = $("[data-test='title']");

    public ProductsPage shouldHaveTitle(String titleText) {
        productPageTitle.shouldHave(exactText(titleText));
        return this;
    }
}