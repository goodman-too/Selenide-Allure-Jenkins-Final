package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage extends BasePage {
    //Locators:
    private SelenideElement quickLaunchFieldset = $("fieldset#panel_resizable_0_0");
    private SelenideElement chartFieldset = $("fieldset#panel_resizable_1_0");
    private SelenideElement legendFieldset = $("fieldset#panel_resizable_1_1");
    private SelenideElement leaveRequestFieldset = $("fieldset#panel_resizable_1_2");


    @Step("Check dashboard elements are visible")
    public void checkElementsExist() {
        quickLaunchFieldset.shouldBe(visible);
        chartFieldset.shouldBe(visible);
        legendFieldset.shouldBe(visible);
        leaveRequestFieldset.shouldBe(visible);
    }
}
