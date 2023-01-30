package pertini.test;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.Strings;


public class InformationsTest extends BaseTest{
    /**
 * Testing AboutUs functionality
 *
 * Test steps:
 * 1. Navigate to https://pertinitoys.com/
 * 2. Click AboutUs button in the page meny bar
 * 3. In the footer of the page click TermsOfService button
 * 4. Click on Contact button on page menu bar
 * Expected result:
 * 2. Page with following URL is shown; URL: https://pertinitoys.com/page--o-nama
 * 3. Page with following URL is shown; URL: https://pertinitoys.com/page--uslovi-koriscenja
 * 4. Page with following URL is shown; URL: https://pertinitoys.com/page--kontakt
 *
 *
 **/

@Test
public void InformationsTest(){
    driver = openChromeDriver ();
    try {
        print ( "Navigiraj na bebakids.com" );
        BasePage basePage = new BasePage (driver);

        //About Us
        print ( "Click on About us button on page menu bar and verify new page headline" );
        basePage.clickOnAboutUs();

        print ( "Verify page with following URL is shown; URL: https://pertinitoys.com/page--o-nama" );
        assert isCurrentUrlEqualsTo (Strings.ABOUT_US ):"Error. You are noy on AboutUs page";

        //TermsOfService
        print ( "Click on TermsOfService button on page footer bar and verify new page headline" );
        basePage.clickTermsOfServise();

        print ( "Verify page with following URL is shown; URL: https://pertinitoys.com/page--uslovi-koriscenja" );
        assert isCurrentUrlEqualsTo (Strings.TERMS_OF_SERVICE ):"Error. You are noy on TermsOfServise page";

        // Contact
        print ( "Click on Contact button on page menu bar and verify new page headline" );
        basePage.clickOnContact();

        print ( "Verify page with following URL is shown; URL: https://pertinitoys.com/page--kontakt" );
        assert isCurrentUrlEqualsTo (Strings.CONTACT ):"Error. You are noy on Contact page";

    }

    finally {
        driver.quit ();
    }
}
}
