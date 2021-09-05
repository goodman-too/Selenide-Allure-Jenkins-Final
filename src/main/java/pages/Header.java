package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;


public class Header {
    //Locators:
    SelenideElement profileMenuButton = $("a#welcome");
    SelenideElement logoutButton = $("a[href='/index.php/auth/logout']");

    //Main menu locators:
    SelenideElement adminButton = $("a#menu_admin_viewAdminModule");
    SelenideElement pimButton = $("a#menu_pim_viewPimModule");
    SelenideElement dashboardButton = $("a#menu_dashboard_index");
    SelenideElement recruitmentButton = $("a#menu_recruitment_viewRecruitmentModule");
    SelenideElement leaveButton = $("a#menu_leave_viewLeaveModule");


    @Step("Log out")
    public void logOut() {
        profileMenuButton.click();
        logoutButton.click();
    }

    @Step("Open admin page")
    public void openAdminPage() {
        adminButton.click();
    }

    @Step("Open dashboard page")
    public void openDashboardPage() {
        dashboardButton.click();
    }

    @Step("Open PIM page")
    public void openPimPage() {
        pimButton.click();
    }

    @Step("Open recruitment page")
    public void openRecruitmentPage() {
        recruitmentButton.click();
    }

    @Step("Open leave page")
    public void openLeavePage() {
        leaveButton.click();
    }
}
