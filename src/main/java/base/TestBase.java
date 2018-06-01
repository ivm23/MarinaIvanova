package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    @BeforeSuite
    public void setUpConfigs() {
        Configuration.browser = "chrome";
        Configuration.screenshots = false;
    }
}
