package hw2.ex3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObject.HomePageForHW3;

import java.util.HashMap;

import static java.lang.System.setProperty;

public class TestEpamGithubIOJDISite {

    private WebDriver driver;
    private String driverPath = "chromedriver.exe";
    private HomePageForHW3 homePage;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        homePage = PageFactory.initElements(driver, HomePageForHW3.class);
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

    @BeforeSuite
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", driverPath);
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println(System.currentTimeMillis());
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println(driver.getTitle());
    }

    @Test
    public void simpleSeleniumTest() {
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", "target");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        driver.navigate().to("https://epam.github.io/JDI/index.html");
        Assert.assertEquals(driver.getTitle(), "Home Page");

        WebElement userIcon = driver.findElement(By.cssSelector(".profile-photo"));
        userIcon.click();

        driver.findElement(By.cssSelector("#Name")).sendKeys("epam");
        driver.findElement(By.cssSelector("#Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".form-horizontal button[type = 'submit']")).click();

        WebElement userName = driver.findElement(By.cssSelector(".profile-photo span"));
        Assert.assertTrue(userName.isDisplayed());
        Assert.assertEquals(userName.getText(), "PITER CHAILOVSKII");
    }

}
