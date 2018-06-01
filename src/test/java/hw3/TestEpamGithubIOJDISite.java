package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pageObject.HomePageForHW3;

public class TestEpamGithubIOJDISite {

    private WebDriver driver;
    private HomePageForHW3 homePage;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        homePage = PageFactory.initElements(driver, HomePageForHW3.class);
    }
    //15. Close Browser
    @AfterClass
    public void afterClass() {
        driver.close();
    }

    //1. Create a new test
    @Test
    public void HomePageValidation() {
        //2. Open test site by URL
        homePage.open(driver, "https://epam.github.io/JDI/index.html");

        //3. Assert Browser title
       homePage.checkHomePageTitle(driver, "Home Page");

        //4. Perform login
        homePage.login("epam", "1234");


        //5. Assert User name in the left-top side of screen that user is loggined
        homePage.checkUserName("PITER CHAILOVSKII");

        //6. Assert Browser title
        homePage.checkHomePageTitle(driver, "Home Page");

        //7. Assert that there are 4 items on the header section are displayed and they have proper texts
        homePage.checkNumberOfItemsInHeaderSectionIsFour(4);
        homePage.checkItemsOnHeaderSectionAreDisplayed();
        homePage.checkItemsOnHeaderSectionHaveProperTexts();

        //8. Assert that there are 4 images on the Home Page and they are displayed
        homePage.checkNumberOfImagesOnHomePageIsFour(4);
        homePage.checkImagesOnHomePageAreDisplayed();

        //9. Assert that there are 4 texts on the Home Page under icons and they have proper text
        homePage.checkNumberOfTextsOnHomePageUnderIconsIsFour(4);
        homePage.checkTextsOnHomePageUnderIconsHaveProperTexts();

        //10. Assert a text of the main header
        homePage.checkTextsOfMainHeaderAreCorrect();

        //11. Assert a text of the sub header
        homePage.checkTextOfSubHeaderIsCorrect("JDI GITHUB");

        //12. Assert that JDI GITHUB is a link and has a proper URL
        homePage.checkJDIIsLinkAndHasProperURL("https://github.com/epam/JDI");

        //13. Assert that there is Left Section
        homePage.checkLeftSectionIsDisplayed();

        //14. Assert that there is Footer
        homePage.checkFooterIsDisplayed();

    }

}
