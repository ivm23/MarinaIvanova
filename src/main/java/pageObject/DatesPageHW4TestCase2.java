package pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.AssertJUnit.assertEquals;


public class DatesPageHW4TestCase2 {

    private final int SLIDER_RANGE = 100;
    private final String URL;

    private SelenideElement userName = $(".profile-photo span");
    private SelenideElement userIcon = $(".profile-photo");
    private SelenideElement loginInput = $("#Name");
    private SelenideElement passwordInput = $("#Password");
    private SelenideElement loginButton = $(".form-horizontal button[type = 'submit']");
    private SelenideElement serviceDropDown = $(".dropdown");
    private SelenideElement refDatesPage = $("a[href = 'dates.html']");
    private SelenideElement slider = $(".uui-slider");
    private SelenideElement firstSlider = $("a[style^='left']:first-child");
    private SelenideElement lastSlider = $("a[style^='left']:last-child");

    private SelenideElement firstLogRow = $(".info-panel-body-log li:nth-child(1)");
    private SelenideElement secondLogRow = $(".info-panel-body-log li:nth-child(2)");


    public DatesPageHW4TestCase2(String url) {
        URL = url;
    }

    public void open() {
        Selenide.open(URL);
    }

    public void checkHomePageTitle() {
        assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    public void login(String login, String password) {
        userIcon.click();
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void checkUserName(String userName) {
        this.userName.shouldBe(Condition.visible);
        this.userName.shouldHave(text(userName));
    }

    public void openDatesPage() {
        serviceDropDown.click();
        refDatesPage.click();
    }

    public void setRangeSliders(int minValue, int maxValue) {
        int sliderWidth = slider.getSize().width;
        if (minValue > Integer.parseInt(lastSlider.getText())) {
            Selenide.actions().dragAndDropBy(lastSlider, (sliderWidth * (maxValue - Integer.parseInt(lastSlider.getText()) - 1)) / SLIDER_RANGE, 0).perform();
            Selenide.actions().dragAndDropBy(firstSlider, (sliderWidth * (minValue - Integer.parseInt(firstSlider.getText()) - 1)) / SLIDER_RANGE, 0).perform();

        } else {
            Selenide.actions().dragAndDropBy(firstSlider, (sliderWidth * (minValue - Integer.parseInt(firstSlider.getText()) - 1)) / SLIDER_RANGE, 0).perform();
            Selenide.actions().dragAndDropBy(lastSlider, (sliderWidth * (maxValue - Integer.parseInt(lastSlider.getText()) - 1)) / SLIDER_RANGE, 0).perform();
        }
    }

    public void CheckContentLogRowsForSlider(String text1, String text2) {
        firstLogRow.shouldHave(text(text1));
        secondLogRow.shouldHave(text(text2));
    }

}
