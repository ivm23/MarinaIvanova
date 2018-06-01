package pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.AssertJUnit.assertEquals;

public class DifferentElementsPageHW4TestCase1 {

    private final String URL;

    private SelenideElement userName = $(".profile-photo span");
    private SelenideElement userIcon = $(".profile-photo");
    private SelenideElement loginInput = $("#Name");
    private SelenideElement passwordInput = $("#Password");
    private SelenideElement loginButton = $(".form-horizontal button[type = 'submit']");
    private SelenideElement serviceDropDown = $(".dropdown");
    private SelenideElement rightSection = $("div[name='log-sidebar']");
    private SelenideElement leftSection = $("div[name='navigation-sidebar']");
    private SelenideElement topLogRow = $(".info-panel-body-log li:first-child");
    private SelenideElement refDifferentElementsPage = $("a[href = 'different-elements.html']");
    private SelenideElement logRows = $(".info-panel-body-log");
    private SelenideElement homePageTitleText = $(".main-title");
    private SelenideElement homePageCenterText = $(".main-txt");

    private ElementsCollection serviceDropDownMenu = $$(".dropdown-menu li > a");
    private ElementsCollection serviceLeftDropDownMenu = $$(".sub li > a");
    private ElementsCollection homePagePictures = $$(".row .benefit");
    private ElementsCollection homePageTextUnderPictures = $$(".row .benefit-txt");
    private ElementsCollection checkboxesOnDifferentElementsPage = $$(".label-checkbox");
    private ElementsCollection radiosOnDifferentElementsPage = $$(".label-radio");
    private ElementsCollection dropdownOnDifferentElementsPage = $$(".colors");
    private ElementsCollection buttonsOnDifferentElementsPage = $$("div.main-content-hg .uui-button");
    private ElementsCollection colors = $$(".uui-form-element > option");

    public DifferentElementsPageHW4TestCase1(String url) {
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

    //4 - pictures, 4 texts under them, 2 text above
    public void checkHomePageInterface() {
        homePagePictures.shouldHaveSize(4);
        homePageTextUnderPictures.shouldHaveSize(4);
        homePageTitleText.shouldBe(visible);
        homePageCenterText.shouldBe(visible);
    }

    public void openAndCheckServiceMenu() {
        serviceDropDown.click();

        serviceDropDownMenu.shouldHave(texts("SUPPORT", "DATES", "COMPLEX TABLE",
                "SIMPLE TABLE", "USER TABLE", "TABLE WITH PAGES", "DIFFERENT ELEMENTS", "PERFORMANCE"));
    }

    public void checkLeftServiceMenu() {

        serviceLeftDropDownMenu.shouldHave(texts("SUPPORT", "DATES", "COMPLEX TABLE",
                "SIMPLE TABLE", "USER TABLE", "TABLE WITH PAGES", "DIFFERENT ELEMENTS", "PERFORMANCE"));
    }

    public void openDifferentElementsPage() {
        refDifferentElementsPage.click();
    }

    //4 checkboxes, 4 radios, 1 dropdown, 2 buttons
    public void checkDifferentElementsPageInterface() {
        checkboxesOnDifferentElementsPage.shouldHaveSize(4);
        radiosOnDifferentElementsPage.shouldHaveSize(4);
        dropdownOnDifferentElementsPage.shouldHaveSize(1);
        buttonsOnDifferentElementsPage.shouldHaveSize(2);
    }

    public void checkRightSelectionIsVisible() {
        rightSection.shouldBe(visible);
    }

    public void checkLeftSelectionIsVisible() {
        leftSection.shouldBe(visible);
    }

    public void selectCheckBox(String text) {
        int index = 0;
        for (SelenideElement checkbox : checkboxesOnDifferentElementsPage) {
            if (checkbox.getText().equals(text))
                checkboxesOnDifferentElementsPage.get(index).click();

            ++index;
        }
    }

    public void checkLogRowsForCheckboxes(String text, String selected) {
        logRows.shouldHave(text(text), text(selected));
    }


    public void selectRadio(String text) {
        int index = 0;
        for (SelenideElement radio : radiosOnDifferentElementsPage) {
            if (radio.getText().equals(text))
                radiosOnDifferentElementsPage.get(index).click();

            ++index;
        }
    }

    public void checkLogRowsForRadios(String text) {
        topLogRow.shouldHave(text(text));
    }

    public void selectDropDown(String colorName) {
        int index = 0;
        for (SelenideElement color : colors) {

            if (color.getText().equals(colorName))
                colors.get(index).click();

            ++index;
        }

    }

    public void checkLogRowsForDropDown(String colorName) {
        topLogRow.shouldHave(text(colorName));
    }
}
