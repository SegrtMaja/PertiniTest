package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage {

    //Constructor
    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    //WebElements
    @FindBy(xpath = "//a[@href='/product--lego-disney-miki-i-prijatelji-branitelji-zamka-lfv']")
    WebElement legoToy;

    public void isToysNameDisplayed(){
        assert isElementPresent(legoToy):"Error. Toy is not on the page";
    }


}
