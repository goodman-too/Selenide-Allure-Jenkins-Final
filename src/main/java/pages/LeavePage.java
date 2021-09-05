package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LeavePage extends BasePage {
    //Locators:
    private SelenideElement assignLeaveButton = $("a#menu_leave_assignLeave");
    private SelenideElement allLeaveCheckbox = $("input#leaveList_chkSearchFilter_checkboxgroup_allcheck");
    private SelenideElement searchButton = $("input#btnSearch");

    //Assign leave form locators:
    private SelenideElement employeeNameField = $("input#assignleave_txtEmployee_empName");
    private SelenideElement leaveTypeSelect = $("select#assignleave_txtLeaveType");
    private SelenideElement formDateField = $("input#assignleave_txtFromDate");
    private SelenideElement toDateField = $("input#assignleave_txtToDate");
    private SelenideElement assignButton = $("input#assignBtn");


    @Step("Assign default leave")
    public void assignDefaultLeave() {
        employeeNameField.setValue("John Smith");
        leaveTypeSelect.selectOption(1);
        formDateField.setValue("2000-10-20");
        toDateField.setValue("2000-10-25");
        assignButton.click();
    }

    @Step("Check leave is visible")
    public void checkLeaveExist(String employeeName) {
        allLeaveCheckbox.click();
        searchButton.click();
        $(byText(employeeName)).shouldBe(visible);
    }

    @Step("Check assign leave form elements are visible")
    public void checkFormElementsExist() {
        employeeNameField.shouldBe(visible);
        leaveTypeSelect.shouldBe(visible);
        formDateField.shouldBe(visible);
        toDateField.shouldBe(visible);
    }

    @Step("Open assign leave page")
    public void openAssignLeavePage() {
        assignLeaveButton.click();
    }
}
