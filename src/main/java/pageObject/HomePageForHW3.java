package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class HomePageForHW3 {

    @FindBy(css = ".profile-photo")
    private WebElement userIcon;

    @FindBy(css = "#Name")
    private WebElement loginInput;

    @FindBy(css = "#Password")
    private WebElement passwordInput;

    @FindBy(css = "form button[type='submit']")
    private WebElement loginButton;

    @FindBy(css = ".profile-photo span")
    private WebElement userName;

    @FindBy(css = ".nav > li")
    private List<WebElement> itemsOnHeaderSection;

    @FindBy(css = ".icons-benefit")
    private List<WebElement> imagesOnHomePage;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> textsUnderIcons;

    @FindBy(css = ".main-title")
    private  WebElement mainHeaderTitle;

    @FindBy(css = ".main-txt")
    private WebElement mainHeaderText;

    @FindBy(css = ".text-center > a")
    private WebElement subHeaderText;

    @FindBy(css = "div[name='navigation-sidebar']")
    private WebElement leftSection;

    @FindBy(css = "footer")
    private WebElement footer;

    public void open(WebDriver driver, String url) {
        driver.navigate().to(url);
    }

    public void checkHomePageTitle(WebDriver driver, String title) {
        assertEquals(driver.getTitle(), title);
    }

    public void login(String userName, String password) {
        userIcon.click();
        loginInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void checkUserName(String name) {
        assertEquals(userName.getText(), name);
    }

   public void checkNumberOfItemsInHeaderSectionIsFour(int countOfItems) {
        assertEquals(itemsOnHeaderSection.size(), countOfItems);
    }

    public void checkItemsOnHeaderSectionAreDisplayed() {
        for (WebElement item : itemsOnHeaderSection) {
            Assert.assertTrue(item.isDisplayed());
        }
    }

    public void checkItemsOnHeaderSectionHaveProperTexts() {
        assertEquals(itemsOnHeaderSection.get(0).getText(), "HOME");
        assertEquals(itemsOnHeaderSection.get(1).getText(), "CONTACT FORM");
        assertEquals(itemsOnHeaderSection.get(2).getText(), "SERVICE");
        assertEquals(itemsOnHeaderSection.get(3).getText(), "METALS & COLORS");
    }

    public void checkNumberOfImagesOnHomePageIsFour(int countOfImages) {
        assertEquals(imagesOnHomePage.size(), countOfImages);
    }

    public void checkImagesOnHomePageAreDisplayed() {
        for (WebElement element : imagesOnHomePage) {
            Assert.assertTrue(element.isDisplayed());
        }
    }

    public void checkNumberOfTextsOnHomePageUnderIconsIsFour(int countOfTexts) {
        assertEquals(textsUnderIcons.size(), countOfTexts);
    }

    public void checkTextsOnHomePageUnderIconsHaveProperTexts() {
        assertEquals(textsUnderIcons.get(0).getText(), "To include good practices\nand ideas from successful\n"
                + "EPAM project");
        assertEquals(textsUnderIcons.get(1).getText(), "To be flexible and\ncustomizable");
        assertEquals(textsUnderIcons.get(2).getText(), "To be multiplatform");
        assertEquals(textsUnderIcons.get(3).getText(), "Already have good base\n(about 20 internal and\n" +
                "some external projects),\nwish to get more…");
    }

    public void checkTextsOfMainHeaderAreCorrect() {
        assertEquals(mainHeaderTitle.getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(mainHeaderText.getText(),
                "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
                        "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
                        "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI " +
                        "UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT " +
                        "IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
    }

    public void checkTextOfSubHeaderIsCorrect(String text) {
        Assert.assertTrue(subHeaderText.isDisplayed());
        assertEquals(subHeaderText.getText(), text);
    }

    public void checkJDIIsLinkAndHasProperURL(String url) {
        assertEquals(subHeaderText.getAttribute("href"), url);
    }

    public void checkLeftSectionIsDisplayed() {
        Assert.assertTrue(leftSection.isDisplayed());
    }

    public void checkFooterIsDisplayed() {
        Assert.assertTrue(footer.isDisplayed());
    }
}
