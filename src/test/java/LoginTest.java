import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;


@Epic("opensource-demo.orangehrmlive.com Tests")
@DisplayName("Login Tests")
public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Test
    @DisplayName("Login test")
    @Description("Test reproduce log in with correct user")
    public void shouldLogin() {
        loginPage.login();
        loginPage.checkLogIn();
    }

    @Test
    @DisplayName("Login test with incorrect user")
    @Description("Test reproduce log in with incorrect user")
    public void shouldNotLogin() {
        loginPage.login("qwertyzxc", "qwertyzxc");
        loginPage.checkErrorMessage();
    }

    @Test
    @DisplayName("Log out test")
    @Description("Test reproduce log out")
    public void shouldLogOut() {
        loginPage.login();
        loginPage.logOut();
        loginPage.checkLogOut();
    }
}
