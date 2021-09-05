import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.DashboardPage;
import pages.LoginPage;


@Epic("opensource-demo.orangehrmlive.com Tests")
@DisplayName("Dashboard page Tests")
public class DashboardTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @BeforeEach
    public void setUpSuite() {
        loginPage.login();
        dashboardPage.openDashboardPage();
    }

    @Test
    @DisplayName("Dashboard elements test")
    @Description("Dashboard elements should be visible")
    public void shouldExistDashboardElements() {
        dashboardPage.checkElementsExist();
    }
}
