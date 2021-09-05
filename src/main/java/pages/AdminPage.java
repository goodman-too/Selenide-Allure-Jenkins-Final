package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class AdminPage extends BasePage {
    //Locators:
    private SelenideElement addUserButton = $("input#btnAdd");
    private SelenideElement jobButton = $("a#menu_admin_Job");
    private SelenideElement jobTitlesButton = $("a#menu_admin_viewJobTitleList");

    //Add user locators:
    private SelenideElement userRoleSelect = $("select#systemUser_userType");
    private SelenideElement employeeNameField = $("input#systemUser_employeeName_empName");
    private SelenideElement usernameField = $("input#systemUser_userName");
    private SelenideElement statusSelect = $("select#systemUser_status");
    private SelenideElement passwordField = $("input#systemUser_password");
    private SelenideElement confirmPasswordField = $("input#systemUser_confirmPassword");
    private SelenideElement saveButton = $("input#btnSave");
    private SelenideElement deleteUserButton = $("input#btnDelete");
    private SelenideElement dialogDeleteUserButton = $("input#dialogDeleteBtn");

    //Jobs locators:
    private SelenideElement jobTitleField = $("input#jobTitle_jobTitle");
    private SelenideElement saveJobButton = $("input#btnSave");
    private SelenideElement addJobButton = $("input#btnAdd");
    private SelenideElement deleteJobButton = $("input#btnDelete");
    private SelenideElement dialogDeleteJobButton = $("input#dialogDeleteBtn");


    @Step("Open add user form")
    public void openAddUserForm() {
        addUserButton.click();
    }

    @Step("Add user")
    public void addUser(String employeeName, String username, String password) {
        employeeNameField.setValue(employeeName);
        usernameField.setValue(username);
        passwordField.setValue(password);
        confirmPasswordField.setValue(password);
        saveButton.click();
    }

    @Step("Check user is visible")
    public void checkUserExist(String username) {
        $(byText(username)).shouldBe(visible);
    }

    @Step("Check user is not visible")
    public void checkUserNotExist(String username) {
        $(byText(username)).shouldNotBe(visible);
    }

    @Step("Delete user")
    public void deleteUser(String username) {
        $(byXpath("//a[text()='" + username + "']/../..//input[@type='checkbox']")).click();
        deleteUserButton.click();
        dialogDeleteUserButton.click();
    }

    @Step("Check add user form elements are visible")
    public void checkAddUserFormExist() {
        userRoleSelect.shouldBe(visible);
        employeeNameField.shouldBe(visible);
        usernameField.shouldBe(visible);
        statusSelect.shouldBe(visible);
        passwordField.shouldBe(visible);
        confirmPasswordField.shouldBe(visible);
    }

    @Step("Open job titles page")
    public void openJobsTitles() {
        jobButton.hover();
        jobTitlesButton.click();
    }

    @Step("Open add job form")
    public void openAddJobForm() {
        addJobButton.click();
    }

    @Step("Add job")
    public void addJob(String jobTitle) {
        jobTitleField.setValue(jobTitle);
        saveJobButton.click();
    }

    @Step("Delete job")
    public void deleteJob(String jobTitle) {
        $(byXpath("//a[text()='" + jobTitle + "']/../..//input[@type='checkbox']")).click();
        deleteJobButton.click();
        dialogDeleteJobButton.click();
    }

    @Step("Check job is visible")
    public void checkJobExist(String jobTitle) {
        $(byText(jobTitle)).shouldBe(visible);
    }

    @Step("Check job is not visible")
    public void checkJobNotExist(String jobTitle) {
        $(byText(jobTitle)).shouldNotBe(visible);
    }
}
