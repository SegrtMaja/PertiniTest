package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    WebDriver driver = null;


    //WebElements on Login page

    @FindBy(id = "submit-login")
    WebElement loginButton;

    @FindBy(xpath = "//input[@name= 'login-email']")
    WebElement loginEmail;

    @FindBy(xpath = "//input[@name='login-pass']")
    WebElement password;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    WebElement errorMessageInvalidCredentials;

    @FindBy(xpath= "//div[@class='col-md-4 personal-data']" )
    WebElement userAccount;

    @FindBy (xpath = "//h3[@class='profile-username']")
    WebElement userName;

    @FindBy (xpath = "//a[@class='pull-right']")
    WebElement userEMail;


    //Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements ( driver, this );
    }

    //Methods

    public void clickOnLoginButton(){
        isElementPresent ( loginButton );
        loginButton.click ();
    }
    public void enterLoginEmail(){
        assert isElementPresent ( loginEmail ):"Error. Login Modal is not open.";
        loginEmail.click ();
        loginEmail.sendKeys ( Strings.LOGIN_EMAIL );
    }
    public void enterInvalidEmail(){
        assert isElementPresent ( loginEmail ):"Error. Login Modal is not open.";
        loginEmail.click ();
        loginEmail.sendKeys ( Strings.INVALID_EMAIL );
    }
    public void enterPassword(){
        assert isElementPresent ( password ):"Error. Login Modal is not open.";
        password.click ();
        password.sendKeys ( Strings.PASSWORD );
    }
    public void enterInvalidPassword(){
        assert isElementPresent ( password ):"Error. Login Modal is not open.";
        password.click ();
        password.sendKeys ( Strings.INVALID_PASSWORD);
    }

    public void isErrorMessageForInvalidCredentialsPresent(){
        assert isElementPresent ( errorMessageInvalidCredentials ):"Error. Error message is not shown.";
    }

    public void isUserProfileDisplayed(){
        assert isElementPresent(userAccount): "Error. User account not displayed";
    }

    public void isUserNameDisplayed(){
        assert isElementPresent(userName):"Error. UserName not displayed";
    }

    public void isUserEmailDisplayed(){
        assert isElementPresent(userEMail):"Error. Users E-Mail is not displayed";
    }





}