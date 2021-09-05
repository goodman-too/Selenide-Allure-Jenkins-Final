package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class RecruitmentPage extends BasePage {
    //Locators:
    private SelenideElement addCandidateButton = $("input#btnAdd");
    private SelenideElement deleteCandidateButton = $("input#btnDelete");
    private SelenideElement dialogDeleteCandidateButton = $("input#dialogDeleteBtn");

    //Add candidate locators:
    private SelenideElement firstNameField = $("input#addCandidate_firstName");
    private SelenideElement lastNameField = $("input#addCandidate_lastName");
    private SelenideElement emailField = $("input#addCandidate_email");
    private SelenideElement vacancySelect = $("select#addCandidate_vacancy");
    private SelenideElement saveButton = $("input#btnSave");


    @Step("Add default candidate")
    public void addDefaultCandidate() {
        firstNameField.setValue("John");
        lastNameField.setValue("Cooper");
        emailField.setValue("john_cooper@gmail.com");
        vacancySelect.selectOption(1);
        saveButton.click();
    }

    @Step("Check candidate is visible")
    public void checkCandidateExist(String firstName, String lastName) {
        $(byText(firstName + " " + lastName)).shouldBe(visible);
    }

    @Step("Open add candidate form")
    public void openAddCandidateForm() {
        addCandidateButton.click();
    }

    @Step("Delete candidate")
    public void deleteCandidate(String firstName, String lastName) {
        $(byXpath("//a[text()='" + firstName + "  " + lastName + "']/../..//input[@type='checkbox']")).click();
        deleteCandidateButton.click();
        dialogDeleteCandidateButton.click();
    }

    @Step("Check candidate is not visible")
    public void checkCandidateNotExist(String firstName, String lastName) {
        $(byText(firstName + " " + lastName)).shouldNotBe(visible);
    }
}
