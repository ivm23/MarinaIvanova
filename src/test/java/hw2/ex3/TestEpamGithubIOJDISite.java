package hw2.ex3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pageObject.HomePage;

import static java.lang.System.setProperty;

public class TestEpamGithubIOJDISite {

    private WebDriver driver;
    private String driverPath = "chromedriver.exe";
    private HomePage homePage;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @AfterClass
    public void afterClass() {
        System.out.println(driver.getTitle());
    }

    @BeforeSuite
    public void beforeSuite(){
        setProperty("webdriver.chrome.driver", driverPath);
    }

    //15. Close Browser
    @AfterSuite
    public void afterSuite() {
        driver.close();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println(System.currentTimeMillis());
    }

    //1. Create a new test
    @Test
    public void HomePageValidation() {
        //2. Open test site by URL
        homePage.open(driver);

        //3. Assert Browser title
       homePage.checkHomePageTitle(driver);

        //4. Perform login
        homePage.login("epam", "1234");


        //5. Assert User name in the left-top side of screen that user is loggined
        homePage.checkUserName();

        //6. Assert Browser title
        homePage.checkHomePageTitle(driver);

        //7. Assert that there are 4 items on the header section are displayed and they have proper texts
        homePage.checkNumberOfItemsInHeaderSectionIsFour();
        homePage.checkItemsOnHeaderSectionAreDisplayed();
        homePage.checkItemsOnHeaderSectionHaveProperTexts();

        //8. Assert that there are 4 images on the Home Page and they are displayed
        homePage.checkNumberOfImagesOnHomePageIsFour();
        homePage.checkImagesOnHomePageAreDisplayed();

        //9. Assert that there are 4 texts on the Home Page under icons and they have proper text
        homePage.checkNumberOfTextsOnHomePageUnderIconsIsFour();
        homePage.checkTextsOnHomePageUnderIconsHaveProperTexts();

        //10. Assert a text of the main header
        homePage.checkTextsOfMainHeaderAreCorrect();

        //11. Assert a text of the sub header
        homePage.checkTextOfSubHeaderIsCorrect();

        //12. Assert that JDI GITHUB is a link and has a proper URL
        homePage.checkJDIIsLinkAndHasProperURL();

        //13. Assert that there is Left Section
        homePage.checkLeftSectionIsDisplayed();

        //14. Assert that there is Footer
        homePage.checkFooterIsDisplayed();

    }

}
