import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.RecruitmentPage;


@Epic("opensource-demo.orangehrmlive.com Tests")
@DisplayName("Recruitment page Tests")
public class RecruitmentTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    RecruitmentPage recruitmentPage = new RecruitmentPage();

    @BeforeEach
    public void setUpSuite() {
        loginPage.login();
        recruitmentPage.openRecruitmentPage();
    }

    @Test
    @DisplayName("Add candidate test")
    @Description("Test reproduce adding candidate")
    public void shouldAddCandidate() {
        String firstName = "John";
        String lastName = "Cooper";

        //Add candidate
        recruitmentPage.openAddCandidateForm();
        recruitmentPage.addDefaultCandidate();
        recruitmentPage.openRecruitmentPage();
        recruitmentPage.checkCandidateExist(firstName, lastName);

        //Delete candidate after test
        recruitmentPage.deleteCandidate(firstName, lastName);

    }

    @Test
    @DisplayName("Delete candidate test")
    @Description("Test reproduce deleting candidate")
    public void shouldDeleteCandidate() {
        String firstName = "John";
        String lastName = "Cooper";

        //Add candidate for delete
        recruitmentPage.openAddCandidateForm();
        recruitmentPage.addDefaultCandidate();
        recruitmentPage.openRecruitmentPage();

        //Delete candidate
        recruitmentPage.deleteCandidate(firstName, lastName);
        recruitmentPage.checkCandidateNotExist(firstName, lastName);
    }
}
