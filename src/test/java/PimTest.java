import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.PimPage;


@Epic("opensource-demo.orangehrmlive.com Tests")
@DisplayName("PIM page Tests")
public class PimTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    PimPage pimPage = new PimPage();

    @BeforeEach
    public void setUpSuite() {
        loginPage.login();
        pimPage.openPimPage();
    }

    @Test
    @DisplayName("Employee details form test")
    @Description("Employee details elements should be visible")
    public void shouldEmployeeDetailsFormExist() {
        pimPage.openEmployeeDetails();
        pimPage.checkEmployeeDetailsFormExist();
    }
}
