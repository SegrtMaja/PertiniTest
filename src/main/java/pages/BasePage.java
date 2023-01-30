package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BasePage {

    WebDriver driver=null;


    //Web elements that are common

    @FindBy(xpath = "//button[@class='search-icon']")
    WebElement searchButton;

    @FindBy(xpath= "//div[@class='search-input-field']")
    WebElement searchTextField;

    @FindBy(xpath= "//div[@class='col-xs-6 text-right']0")
    WebElement registracijaButton;

    @FindBy(xpath = "//a[@class='fa fa-facebook']")
    WebElement socialNetFB;

    @FindBy(xpath = "//a[@class='fa fa-youtube']")
    WebElement socialNetYT;

    @FindBy(xpath= "//div[@class='x1heor9g x1qlqyl8 x1pd3egz x1a2a7pz']")
    WebElement FBPageName;

    @FindBy(xpath = "//div[@id='text-container']")
    WebElement YTPageName;

    @FindBy(xpath = "//a[@href='/page--o-nama']")
    WebElement aboutUsButton;

    @FindBy(xpath = "//div[@class='col-xs-12 cat-title-tab']")
    WebElement aboutUsPageName;

    @FindBy(xpath = "//div[@class='col-xs-8'']")
    WebElement aboutUsText;

    @FindBy(xpath = "//a[@href='/page--kontakt']")
    WebElement contact;

    @FindBy(xpath = "//div[@class='col-md-6']")
    WebElement contactPageName;

    @FindBy(xpath = "//a[@href='/page--uslovi-koriscenja']")
    WebElement termsOfServis;

    @FindBy(xpath = "//div[@class='col-md-12']")
    WebElement termesOfServisPageName;


    //Constructor

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements ( driver, this );
    }

    public BasePage() {
    }


    //Methods

    public void clickSearchButton(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", searchButton);
        waitForElement ( searchButton );
    }

    public void enterTextInSearchField(String text) {
        searchTextField.sendKeys ( text );
        searchTextField.sendKeys ( Keys.ENTER );
    }

    public void clickRegistracijaButton(){
        assert isElementPresent ( registracijaButton ):"Error. Registracija button is not present.";
        registracijaButton.click ();
    }

    public void socialNetworkFaceBook(){

        assert isElementPresent ( socialNetFB ):"Error. Connect to Face Book button is not present";
        socialNetFB.click ();
        List<String> tabs = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        sleep ();

        print ( "Verifying opening of stores FaceBook page" );
        assert isElementPresent (FBPageName ):"Error. You are not on FaceBook page. ";
        assert isCurrentUrlEqualsTo ( Strings.FACEBOOK ):"Error. You are not on FaceBook page";
        driver.close();
        driver.switchTo().window(tabs.get(0));


    }

    public void socialNetworkYT(){
        socialNetYT.click ();

        List<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        print ( "Verifying opening of stores YouTube page" );
        assert isElementPresent (YTPageName ):"Error. You are not on YouTube page. ";
        assert isCurrentUrlEqualsTo ( Strings.YOUTUBE ):"Error. You are not on YouTube page. ";
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    public void clickOnAboutUs(){
        assert isElementPresent ( aboutUsButton ):"Error. About us buttnon not shown";
        aboutUsButton.click ();
        sleep ();
        waitForElement ( aboutUsPageName );
        assert isElementPresent(aboutUsPageName): "Error. You are not on AboutUs page";
    }

    public void clickOnContact(){
        driver.close ();
        List<String> tabs = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        assert isElementPresent ( contact ):"Error. Contact buton is not visible";
        contact.click ();
        List<String> tabs1 = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window(tabs1.get(1));
        sleep ();
        assert isElementPresent(contactPageName):"Error, you are not on Contact page";

    }
    public void clickTermsOfServise(){
        assert isElementPresent ( termsOfServis):"Error. Terms of servise button is not visible";
        termsOfServis.click ();
        List<String> tabs = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        waitForElement (termesOfServisPageName );
        assert isElementPresent(termesOfServisPageName):"Error. You are not on terms of service page";
    }



    public void print(String text) {

        System.out.println (text);
    }

    public void sleep() {

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isElementPresent(WebElement element) {
        print("isElementPresent");
        try {
            boolean isPresent=element.isDisplayed();
            return true;
        }catch (Exception e){
            print ( e.getMessage () );
            print ( "Element is not present on page" );
            return false;
        }
    }

    public void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait ( driver, 15 );
        wait.until( ExpectedConditions.visibilityOf (element) );
    }

    public  boolean isCurrentUrlEqualsTo(String expectedUrl){
        print ( "isCurrentUrlEqualsTo ( " + expectedUrl + " ) ");
        String currentUrl = driver.getCurrentUrl ();
        print ( "User is on " + currentUrl );
        boolean b = currentUrl.equals ( expectedUrl );
        return b;

    }

}
