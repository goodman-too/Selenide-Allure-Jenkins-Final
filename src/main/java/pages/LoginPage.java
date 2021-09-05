package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {
    //Locators:
    private SelenideElement loginField = $("input#txtUsername");
    private SelenideElement passwordField = $("input#txtPassword");
    private SelenideElement loginButton = $("input#btnLogin");
    private SelenideElement errorMessage = $("span#spanMessage");


    private static final String URL = "https://opensource-demo.orangehrmlive.com/";
    private static final String LOGIN = "Admin";
    private static final String PASSWORD = "admin123";

    @Step("Log in")
    public void login(String login, String password) {
        open(URL);
        loginField.setValue(login);
        passwordField.setValue(password);
        loginButton.click();
    }

    @Step("Log in")
    public void login() {
        open(URL);
        loginField.setValue(LOGIN);
        passwordField.setValue(PASSWORD);
        loginButton.click();
    }

    @Step("Check log in")
    public void checkLogIn() {
        profileMenuButton.shouldBe(visible);
    }

    @Step("Check log out")
    public void checkLogOut() {
        loginField.shouldBe(visible);
    }

    @Step("Check error message when incorrect user")
    public void checkErrorMessage() {
        errorMessage.shouldBe(visible);
    }
}
