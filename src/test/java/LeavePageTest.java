import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Flaky;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LeavePage;
import pages.LoginPage;


@Epic("opensource-demo.orangehrmlive.com Tests")
@DisplayName("Leave page Tests")
public class LeavePageTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    LeavePage leavePage = new LeavePage();

    @BeforeEach
    public void setUpSuite() {
        loginPage.login();
        leavePage.openLeavePage();
    }

    @Test
    @Flaky
    @DisplayName("Assign leave test")
    @Description("Test reproduce assign leave")
    public void shouldAssignLeave() {
        leavePage.openAssignLeavePage();
        leavePage.assignDefaultLeave();
        leavePage.openLeavePage();
        leavePage.checkLeaveExist("John Smith");
    }

    @Test
    @DisplayName("Assign form test")
    @Description("Assign form elements should be visible")
    public void shouldFormElementsExist() {
        leavePage.openAssignLeavePage();
        leavePage.checkFormElementsExist();
    }
}
