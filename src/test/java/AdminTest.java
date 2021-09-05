import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AdminPage;
import pages.LoginPage;


@Epic("opensource-demo.orangehrmlive.com Tests")
@DisplayName("Admin page Tests")
public class AdminTest extends BaseTest {

    AdminPage adminPage = new AdminPage();
    LoginPage loginPage = new LoginPage();

    @BeforeEach
    public void setUpSuite() {
        loginPage.login();
        adminPage.openAdminPage();
    }

    @Test
    @DisplayName("Add user form test")
    @Description("Add user form elements should be visible")
    public void shouldExistAddUserForm() {
        adminPage.openAddUserForm();
        adminPage.checkAddUserFormExist();
    }

    @Test
    @DisplayName("Add user test")
    @Description("Test reproduce adding user")
    public void shouldAddUser() {
        String username = "Bob Miller";

        //Add user
        adminPage.openAddUserForm();
        adminPage.addUser("John Smith", username, "1_2_3qwe");
        adminPage.checkUserExist(username);

        //Delete user after test
        adminPage.deleteUser(username);
    }

    @Test
    @DisplayName("Delete user test")
    @Description("Test reproduce deleting user")
    public void shouldDeleteUser() {
        String username = "Jack Brown";

        //Add user for delete
        adminPage.openAddUserForm();
        adminPage.addUser("John Smith", username, "1_2_3qwe");

        //Delete user
        adminPage.deleteUser(username);
        adminPage.checkUserNotExist(username);
    }

    @Test
    @DisplayName("Add job test")
    @Description("Test reproduce adding job")
    public void shouldAddJob() {
        String jobTitle = "QA engineer";

        adminPage.openJobsTitles();

        //Add job
        adminPage.openAddJobForm();
        adminPage.addJob(jobTitle);
        adminPage.checkJobExist(jobTitle);

        //Delete job after test
        adminPage.deleteJob(jobTitle);
    }

    @Test
    @DisplayName("Delete job test")
    @Description("Test reproduce deleting job")
    public void shouldDeleteJob() {
        String jobTitle = "Automation QA";

        adminPage.openJobsTitles();

        //Add job for delete
        adminPage.openAddJobForm();
        adminPage.addJob(jobTitle);

        //Delete job
        adminPage.deleteJob(jobTitle);
        adminPage.checkJobNotExist(jobTitle);
    }
}
