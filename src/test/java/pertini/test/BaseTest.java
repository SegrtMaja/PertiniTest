package pertini.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {

    WebDriver driver = null;


    //   Method for opening  Chrome driver

    public WebDriver openChromeDriver() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Svetlana&Maja&Jefto\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        print ( "Opening Chrome Driver" );
        ChromeOptions options = new ChromeOptions ();
        options.addArguments ( new String[]{"--ignore-certificate-errors"} );
        options.addArguments ( new String[]{"--disable-popup-blocking"} );
        options.addArguments ( new String[]{"--incognito"} );
        ChromeDriver driver = new ChromeDriver ( options );
        driver.get ( "https://pertinitoys.com/" );
        BasePage basePage = new BasePage (driver);
        basePage.sleep ();
        return driver;
    }
    public void print(String text) {

        System.out.println (text);
    }

    public  boolean isCurrentUrlEqualsTo(String expectedUrl){
        print ( "isCurrentUrlEqualsTo ( " + expectedUrl + " ) ");
        String currentUrl = driver.getCurrentUrl ();
        print ( "User is on " + currentUrl );
        boolean b = currentUrl.equals ( expectedUrl );
        return b;

    }
    public boolean verifySearchItemIsShown(String search, WebDriver driver){
        List<WebElement> searchItems = driver.findElements ( By.xpath ( "//div[@class='search-input-field']")  );
        ArrayList<String> searchItemText = new ArrayList<> ();
        for(WebElement item: searchItems){
            String text = item.getText ();
            searchItemText.add ( text );
        }
        return searchItemText.contains ( search );
    }
}