package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTest {
    @Test
    public void successfulLogin() {
        String login = "standard_user";
        String password = "secret_sauce";

        LoginPage loginPage = new LoginPage();

        loginPage.openPage()
                .insertUsername(login)
                .insertPassword(password)
                .clickLoginBtn();
        ProductsPage productsPage = new ProductsPage();
        productsPage.shouldHaveTitle("Products");
    }

    @Test
    public void loginWithLockedOutUser() {
        String login = "locked_out_user";
        String password = "secret_sauce";
        String alertText = "Epic sadface: Sorry, this user has been locked out.";

        LoginPage loginPage = new LoginPage();
        loginPage.openPage()
        .insertUsername(login)
        .insertPassword(password)
        .clickLoginBtn()
        .shouldHaveError(alertText);
    }
}