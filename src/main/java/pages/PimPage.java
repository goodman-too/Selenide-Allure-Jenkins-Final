package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PimPage extends Header {
    //Locators:
    SelenideElement employeeNameLink = $(byXpath("//table[@id='resultTable']/tbody/tr/td[3]/a"));
    SelenideElement searchButton = $("input#searchBtn");
    SelenideElement subUnitSelect = $("select#empsearch_sub_unit");

    //Employee details form locators:
    SelenideElement firstName = $("input#personal_txtEmpFirstName");
    SelenideElement lastName = $("input#personal_txtEmpLastName");
    SelenideElement employeeId = $("input#personal_txtEmployeeId");
    SelenideElement maritalStatus = $("select#personal_cmbMarital");
    SelenideElement birthDate = $("input#personal_DOB");
    SelenideElement nationality = $("select#personal_cmbNation");


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
    }
}
