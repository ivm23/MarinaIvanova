package hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestTextBeforePicturesOnIndexPage {

    @DataProvider(parallel = true)
    public Object[][] textData() {
        return new Object[][]{
                {1, "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project"},
                {2, "To be flexible and\n" +
                        "customizable"},
                {3, "To be multiplatform"},
                {4, "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…"}
        };
    }

    @Test(dataProvider="textData")
    public void checkTextBeforePictures(int index, String text) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://epam.github.io/JDI/index.html");
        Assert.assertEquals(driver.findElement(By.xpath("(//span[@class='benefit-txt'])[" + index + "]")).getText(), text);
    }
}
