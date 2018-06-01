package hw4;

import base.TestBase;
import enums.Users;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.DatesPageHW4TestCase2;

import javax.jws.soap.SOAPBinding;

public class TestCase2EpamJDISiteWithSelenide extends TestBase {
    private DatesPageHW4TestCase2 datesPage;

    @BeforeMethod
    public void beforeMethod() {
        datesPage = new DatesPageHW4TestCase2("https://epam.github.io/JDI/index.html");
    }

    @Test
    public void DatesPageValidation() {
        //1.  Open test site by URL
        datesPage.open();

        //2. Assert Browser title
        datesPage.checkHomePageTitle();

        //3.Perform login
        datesPage.login(Users.PITER_CHAILOVSKII.login, Users.PITER_CHAILOVSKII.password);

        //4. Assert User name in the left-top side of screen that user is loggined
        datesPage.checkUserName(Users.PITER_CHAILOVSKII.name);

        //5. Open through the header menu Service -> Dates Page
        datesPage.openDatesPage();

        //6. Set Range sliders. left sliders - the most left position, right slider - the most rigth position
        datesPage.setRangeSliders(0, 100);

        //7. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.CheckContentLogRowsForSlider("(To):100", "(From):0");


        //8. Set Range sliders. left sliders - the most left position, right slider - the most left position.
        datesPage.setRangeSliders(0, 0);

        //9. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.CheckContentLogRowsForSlider("(To):0", "(From):0");

        //10. Set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
        datesPage.setRangeSliders(100, 100);

        //11. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.CheckContentLogRowsForSlider("(From):100", "(To):100");

        //12. Set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
        datesPage.setRangeSliders(30, 70);

        //13. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.CheckContentLogRowsForSlider("(To):70", "(From):30");
    }
}
