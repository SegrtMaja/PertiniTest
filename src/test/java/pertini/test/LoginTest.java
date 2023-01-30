package pertini.test;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest{
    /**
     * Testing of login  functionality with walid credentials
     *
     * Test steps:
     * 1. Navigate to https://pertinitoys.com/
     * 2. Click on Login button (present on page header)
     * 3. When login form appears enter valid credentials
     * 4. Click on login button
     *
     * Expected result:
     * User profile is present with users Name and e-mail
     */

    @Test
    public void loginTestWithValidCredentials(){
        driver = openChromeDriver ();

        try {
            print ( "1. Navigate to https://pertinitoys.com/" );
            LoginPage loginPage = new LoginPage ( driver );

            print ( "2. Click on Login button (present on page header)" );
            loginPage.clickRegistracijaButton ();

            print ( "3.Enter walid credentials" );
            loginPage.enterLoginEmail ();
            loginPage.enterPassword ();


            print ( "4. Click on login button" );
            loginPage.clickOnLoginButton();
            loginPage.sleep ();

            print ( "5. Verify User profile is displayed , and there is users Name and e-mail ");
            loginPage.isUserProfileDisplayed();
            loginPage.isUserNameDisplayed();
            loginPage.isUserEmailDisplayed();


        }

        finally {
            driver.quit ();
        }
    }

    /**
     * * Testing of login functionality  with invalid e-mail (and "valid password")
     *      *
     *      * Test steps:
     *      * 1. Navigate to https://pertinitoys.com/
     *      * 2. Click on Login button (present on page header)
     *      * 3. When login form appears enter INVALID EMAIL
     *      * 4. Click on login button
     *      *
     *      * Expected result:
     *      * Error message is shown

     */
    @Test
    public void loginTestWithIvalidEMail(){
        driver = openChromeDriver ();

        try {
            print ("Navigate to https://pertinitoys.com/" );
            LoginPage loginPage = new LoginPage ( driver );

            print ( "Enter invalid email");
            loginPage.clickRegistracijaButton();
            loginPage.enterInvalidEmail ();
            loginPage.enterPassword ();

            print ( "Verifying error" );
            loginPage.clickOnLoginButton ();
            loginPage.isErrorMessageForInvalidCredentialsPresent ();



        }

        finally {
            driver.quit ();
        }

    }



    /**
     * * Testing of login functionality  with valid e-mail and invalid password
     *      *
     *      * Test steps:
     *      * 1. Navigate to https://pertinitoys.com/
     *      * 2. Click on Login button (present on page header)
     *      * 3. When login form appears enter VALID EMAIL AND INVALID PASSWORD
     *      * 4. Click on login button
     *      *
     *      * Expected result:
     *      * Error message is shown

     */

    @Test
    public void loginTestWithInvalidPassword(){
        driver = openChromeDriver ();

        try {
            print ("Navigate to https://pertinitoys.com/" );
            LoginPage loginPage = new LoginPage ( driver );

            print ( "Enter invalid password");
            loginPage.clickRegistracijaButton();
            loginPage.enterLoginEmail ();
            loginPage.enterInvalidPassword ();

            print ( "Verifying error" );
            loginPage.clickOnLoginButton ();
            loginPage.isErrorMessageForInvalidCredentialsPresent ();



        }

        finally {
            driver.quit ();
        }

    }

    /**
     * * Testing of login functionality  with invalid credentials
     *      *
     *      * Test steps:
     *      * 1. Navigate to https://pertinitoys.com/
     *      * 2. Click on Login button (present on page header)
     *      * 3. When login form appears enter inVALID EMAIL AND INVALID PASSWORD
     *      * 4. Click on login button
     *      *
     *      * Expected result:
     *      * Error message is shown

     */

    @Test
    public void loginTestWithInvalidCredentials(){
        driver = openChromeDriver ();

        try {
            print ("Navigate to https://pertinitoys.com/" );
            LoginPage loginPage = new LoginPage ( driver );

            print ( "Enter invalid credentials");
            loginPage.clickRegistracijaButton();
            loginPage.enterInvalidEmail();
            loginPage.enterInvalidPassword();

            print ( "Verifying error" );
            loginPage.clickOnLoginButton();
            loginPage.isErrorMessageForInvalidCredentialsPresent();



        }

        finally {
            driver.quit ();
        }

    }
}