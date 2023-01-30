package pertini.test;


import org.testng.annotations.Test;
import pages.BasePage;
import pages.SearchPage;
import pages.ShoppingPage;

public class ShoppingTest extends BaseTest {
    /**
     *
     * Validating filter and add to cart functionality
     *
     * Test steps:
     * 1. Navigate to https://pertinitoys.com/
     * 2. On page menu click on 'Products button'
     * 3. On left side menu check filters 'for girls' and 'older than 5 years'
     * 4. Click on wanted toy
     * 5. Navigate to CartPage(click on cart icon)
     *
     *
     * Expected results
     *  Filters are ckecked
     *  Number on cartIcon is 1
     *  Shopping page is shown
     *  Wanted toy is in cart page
     */

    @Test
    public void filterAndAddToCartTest(){
        driver = openChromeDriver ();
        try {

            //Opening Home and ShoppingPage
            print ( "Navigate to https://pertinitoys.com/" );
            ShoppingPage shoppingPage = new ShoppingPage ( driver );
            shoppingPage.sleep ();

            print ( "On page menu click on 'Products button'" );
            shoppingPage.clickProductButton ();

            print ( "On left side menu check filters 'for girls' and 'older than 5 years'");
            shoppingPage.clickFilterForGirls();
            shoppingPage.clickFilterOlderThan5Years ();

            //Filter functionality
            print ( "Verify that filters are checked");
            shoppingPage.areFiltersChecked ();

            //Add to cart functionality
            print ( "Click on wanted toy" );
            shoppingPage.clickOnChosenToy ();
            shoppingPage.clickAddToCart ();
            shoppingPage.sleep ();

            print ( "Verifying that number on shopping cart icon is 1" );
            String noOfArticalsInCart = shoppingPage.getNoOfItemsInCart ();
            assert noOfArticalsInCart.equals("1") : "Error. No of articals in cart is not one.";

            print ( "Click on cart and veryfying URL of page and that wanted toy is in cart ");

            shoppingPage.clickCartImg();
            shoppingPage.sleep();

            shoppingPage.isShoppingPageLoaded ();
            shoppingPage.isWantedToyInCart ();


        }

        finally {
            driver.quit ();
        }
    }


}
