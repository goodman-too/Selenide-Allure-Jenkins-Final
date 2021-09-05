package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PimPage extends BasePage {
    //Locators:
    private SelenideElement employeeNameLink = $(byXpath("//table[@id='resultTable']/tbody/tr/td[3]/a"));
    private SelenideElement searchButton = $("input#searchBtn");
    private SelenideElement subUnitSelect = $("select#empsearch_sub_unit");

    //Employee details form locators:
    private SelenideElement firstName = $("input#personal_txtEmpFirstName");
    private SelenideElement lastName = $("input#personal_txtEmpLastName");
    private SelenideElement employeeId = $("input#personal_txtEmployeeId");
    private SelenideElement maritalStatus = $("select#personal_cmbMarital");
    private SelenideElement birthDate = $("input#personal_DOB");
    private SelenideElement nationality = $("select#personal_cmbNation");


    @Step("Open employee details page")
    public void openEmployeeDetails() {
        subUnitSelect.selectOption("  Sales");
        searchButton.click();
        employeeNameLink.click();
    }

    @Step("Check employee details elements are visible")
    public void checkEmployeeDetailsFormExist() {
        firstName.shouldBe(visible);
        lastName.shouldBe(visible);
        employeeId.shouldBe(visible);
        maritalStatus.shouldBe(visible);
        birthDate.shouldBe(visible);
        nationality.shouldBe(visible);
    }
}
