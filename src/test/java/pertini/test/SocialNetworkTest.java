package pertini.test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.BasePage;


public class SocialNetworkTest extends BaseTest{
    /**
     * Testing connecting to social network
     *
     * Test steps:
     * 1. Navigate to https://pertinitoys.com/
     * 2. On left sidebar of HomePage click on FaceBook icon
     * 3. On left sidebar of HomePage click on Youtube icon
     *
     * Expected result:
     * 2.FaceBook page of Pertini store is shown
     * 3.YouTube channel profile of Pertini store is shown
     */

    @Test
    public void povezimoSeSaDrustvenimMrezamaTest(){
        WebDriver driver =  openChromeDriver ();
        try {
            print ( "Navigate to https://pertinitoys.com/" );
            BasePage basePage = new BasePage (driver);
            print ( "Click on FaceBook icon" );
            basePage.socialNetworkFaceBook();
            print ( "Click on YouTube icon" );
            basePage.socialNetworkYT ();


        }
        finally {
            driver.quit ();
        }
    }
}

