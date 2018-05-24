package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.util.List;

public class TestEpamGithubIOJDISite {

    private final String URL_FOR_TEST = "https://epam.github.io/JDI/index.html";

    //1. Create a new test
    @Test
    public void HomePageValidation() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Open test site by URL
        driver.navigate().to(URL_FOR_TEST);
        assertEquals(driver.getCurrentUrl(), URL_FOR_TEST);

        //3. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //4. Perform login
        WebElement userIcon = driver.findElement(By.cssSelector(".profile-photo"));
        userIcon.click();

        driver.findElement(By.cssSelector("#Name")).sendKeys("epam");
        driver.findElement(By.cssSelector("#Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".form-horizontal button[type = 'submit']")).click();

        //5. Assert User name in the left-top side of screen that user is loggined
        WebElement userName = driver.findElement(By.cssSelector(".profile-photo span"));
        assertEquals(userName.getText(), "PITER CHAILOVSKII");

        //6. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //7. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> itemsOnHeaderSection = driver.findElements(By.cssSelector(".nav > li"));
        assertEquals(itemsOnHeaderSection.size(), 4);

        for (WebElement item : itemsOnHeaderSection) {
            Assert.assertTrue(item.isDisplayed());
        }

        assertEquals(itemsOnHeaderSection.get(0).getText(), "HOME");
        assertEquals(itemsOnHeaderSection.get(1).getText(), "CONTACT FORM");
        assertEquals(itemsOnHeaderSection.get(2).getText(), "SERVICE");
        assertEquals(itemsOnHeaderSection.get(3).getText(), "METALS & COLORS");

        //8. Assert that there are 4 images on the Home Page and they are displayed
        List<WebElement> imagesOnHomePage = driver.findElements((By.cssSelector(".benefit-icon")));
        assertEquals(imagesOnHomePage.size(), 4);

        for (WebElement image : imagesOnHomePage) {
            Assert.assertTrue(image.isDisplayed());
        }

        //9. Assert that there are 4 texts on the Home Page under icons and they have proper text
        List<WebElement> textsUnderIcons = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(textsUnderIcons.size(), 4);

        for (WebElement text : textsUnderIcons) {
            Assert.assertTrue(text.isDisplayed());
        }

        assertEquals(textsUnderIcons.get(0).getText(), "To include good practices\n" + "and ideas from successful\n" +
                "EPAM project");
        assertEquals(textsUnderIcons.get(1).getText(), "To be flexible and\n" + "customizable");
        assertEquals(textsUnderIcons.get(2).getText(), "To be multiplatform");
        assertEquals(textsUnderIcons.get(3).getText(), "Already have good base\n" +
                "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…");

        //10. Assert a text of the main header
        WebElement mainHeaderTitle = driver.findElement(By.cssSelector(".main-title"));
        Assert.assertTrue(mainHeaderTitle.isDisplayed());
        assertEquals(mainHeaderTitle.getText(), "EPAM FRAMEWORK WISHES…");

        WebElement mainHeaderText = driver.findElement(By.cssSelector(".main-txt"));
        Assert.assertTrue(mainHeaderText.isDisplayed());
        assertEquals(mainHeaderText.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR" +
                " INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION" +
                " ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT" +
                " IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //11. Assert a text of the sub header
        WebElement subHeaderText = driver.findElement(By.cssSelector(".text-center > a"));
        Assert.assertTrue(subHeaderText.isDisplayed());
        assertEquals(subHeaderText.getText(), "JDI GITHUB");

        //12. Assert that JDI GITHUB is a link and has a proper URL
        Assert.assertTrue(subHeaderText.isDisplayed());
        assertEquals(subHeaderText.getAttribute("href"), "https://github.com/epam/JDI");

        //13. Assert that there is Left Section
        Assert.assertTrue(driver.findElement(By.cssSelector("div[name='navigation-sidebar']")).isDisplayed());

        //14. Assert that there is Footer
        Assert.assertTrue(driver.findElement(By.cssSelector("footer")).isDisplayed());

        //15. Close Browser
        driver.close();
    }

}
