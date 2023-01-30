package pertini.test;

import org.testng.annotations.Test;
import pages.SearchPage;
import pages.Strings;

import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseTest{
    /** Search for toy using search text field
     Test steps:
     1. Navigate to https://pertinitoys.com/
     2. Click the Search text field
     3. Type in the toys name
     4. Click the Search button
     Expected results:
     1. Verify that we are on a Search result page
     2. We are on a Search result page which contains toys name
     */

    @Test
    public void searchForAnEventTest(){
        driver = openChromeDriver();

        try {
            SearchPage searchPage = new SearchPage(driver);
            searchPage.clickSearchButton();
            searchPage.enterTextInSearchField("lego disney miki i prijatelji");


            //Verify that we are on search result page"
            assertTrue (searchPage.isCurrentUrlEqualsTo(Strings.LEGO_DISNEY));

            //Verify that page contains toys name
            searchPage.isToysNameDisplayed();


        }

        finally {
            driver.quit();
        }
    }

}
