package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class ShoppingPage extends BasePage {

    WebDriver driver=null;

    //WebElements
    @FindBy(xpath = "//a[@href='shop']")
    WebElement productsButton;

    @FindBy(xpath = "//input[@id='checkboxprogram2']")
    WebElement filterForGirls;

    @FindBy(id="checkbox8kolek")
    WebElement filterOlderThan5Years;

    @FindBy(xpath =  "//a[@href='/product--bildo-lol-kuhinja-dga']")
    WebElement chosenToy;

    @FindBy(xpath = "//a[@class='btn green-bck add-to-cart hvr-icon-bounce']")
    WebElement addToCart;

    @FindBy(xpath = "//a[@href='/checkout.php']")
    WebElement cartImg;

    @FindBy(xpath = "//span[@href='/checkout.php']")
    WebElement noOfItemsOnCartImg;

    @FindBy(xpath = "//a[@href='/product--bildo-lol-kuhinja-dga']")
    WebElement productInCart;

    @FindBy (xpath = "//label[@for='checkboxprogram2']")
    WebElement checkedfilterForGirls;

    @FindBy (xpath = "//input[@id='checkbox8kolek']")
    WebElement chekedfilterOlderThan5Years;




    //Constructor
    public ShoppingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements ( driver, this );
    }

    //Methods
    public void clickProductButton(){
        assert isElementPresent ( productsButton ):"Error. Products button is not visible.";
        productsButton.click ();
        sleep ();
    }


    public void clickFilterForGirls(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript ( "arguments[0].scrollIntoView();", filterForGirls );
        assert isElementPresent ( filterForGirls ):"Error. Filter form is not present.";
        JavascriptExecutor js1 = (JavascriptExecutor)driver;
        js1.executeScript("arguments[0].click();", filterForGirls);
        sleep ();

    }

    public void clickFilterOlderThan5Years(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript ( "arguments[0].scrollIntoView();", filterOlderThan5Years);
        assert isElementPresent ( filterOlderThan5Years ):"Error. Filter form is not present.";
        JavascriptExecutor js1 = (JavascriptExecutor)driver;
        js1.executeScript("arguments[0].click();", filterOlderThan5Years);
        sleep ();

    }

    public void clickOnChosenToy(){
        assert isElementPresent (chosenToy):"Error. Artikal is no longer available.";
        chosenToy.click ();
    }

    public void clickAddToCart(){
        assert isElementPresent ( addToCart ):"Error. Add to cart button is not visible";
        addToCart.click ();
    }
    public void clickCartImg(){
        assert isElementPresent ( cartImg ):"Error. Cart Image is not visible.";
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", cartImg);

    }

    public String getNoOfItemsInCart() {
        print("getNoOfItemsInCart");
        return noOfItemsOnCartImg.getText();
    }


    public void areFiltersChecked(){
        print ( "Checking is filter for girls checked" );
        assert isElementPresent ( checkedfilterForGirls ):"Error. Filter not checked.";
        print ( "Checking is filter older that 5 years checked" );
        assert isElementPresent ( chekedfilterOlderThan5Years):"Error. Filter not checked.";
    }

    public void isShoppingPageLoaded(){
        print ( "Is shopping page loaded" );
        String currentURL = driver.getCurrentUrl();
        assert currentURL.equals("https://pertinitoys.com/checkout.php"): "Error. You are not on shopping page";
    }

    public void isWantedToyInCart(){

        print ( "Is wanted toy in cart" );
        String nameOfProductInCart = productInCart.getText();
        assert nameOfProductInCart.contains("BILDO LOL Kuhinja (") : "Error. Wanted toy is not in cart.";

    }



}
