package hw4;

import base.TestBase;
import enums.Users;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.DifferentElementsPageHW4TestCase1;

public class TestCase1EpamJDISiteWithSelenide extends TestBase {

    private DifferentElementsPageHW4TestCase1 page;

    @BeforeMethod
    public void beforeMethod() {
        page = new DifferentElementsPageHW4TestCase1("https://epam.github.io/JDI/index.html");
    }

    @Test
    public void differentElementsPageValidation() {
        //1. Open test site by URL
        page.open();

        //2. Assert Browser title
        page.checkHomePageTitle();

        //3. Perform login
        page.login(Users.PITER_CHAILOVSKII.login, Users.PITER_CHAILOVSKII.password);

        //4. Assert User name in the left-top side of screen that user is loggined
        page.checkUserName(Users.PITER_CHAILOVSKII.name);

        //5. Check interface on Home page, it contains all needed elements.
        page.checkHomePageInterface();

        //6. Click on "Service" subcategory in the header and check that drop down contains options
        page.openAndCheckServiceMenu();

        //7. Click on Service subcategory in the left section and check that drop down contains options
        page.checkLeftServiceMenu();

        //8. Open through the header menu Service -> Different Elements Page
        page.openDifferentElementsPage();

        //9. Check interface on Different elements page, it contains all needed elements
        page.checkDifferentElementsPageInterface();

        //10. Assert that there is Right Section
        page.checkRightSelectionIsVisible();

        //11. Assert that there is Left Section
        page.checkLeftSelectionIsVisible();

        //12. Select checkboxes (Water, Wind)
        page.selectCheckBox("Water");
        page.selectCheckBox("Wind");

        //13. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        page.checkLogRowsForCheckboxes("Water", "true");
        page.checkLogRowsForCheckboxes("Wind", "true");

        //14. Select radio
        page.selectRadio("Selen");

        //15. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        page.checkLogRowsForRadios("Selen");

        //16. Select in dropdown
        page.selectDropDown("Yellow");

        //17. Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        page.checkLogRowsForDropDown("Yellow");

        //18. Unselect and assert checkboxes
        page.selectCheckBox("Water");
        page.selectCheckBox("Wind");

        //19. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        page.checkLogRowsForCheckboxes("Water", "false");
        page.checkLogRowsForCheckboxes("Wind", "false");


    }
}
