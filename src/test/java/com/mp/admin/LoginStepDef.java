package com.mp.admin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;
import Objects.LoginPage;

public class LoginStepDef {

    public static WebDriver driver;
    LoginPage login;
   @Given("Launch the admin portal")
    public void launch_the_admin_portal() {
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.navigate().to("https://admin-test.magicpinapp.net/login");
       driver.manage().window().maximize();
   }
    @When("Entering valid {string} and {string} credentials")
    public void entering_valid_and_credentials(String string, String string2) {
        login = new LoginPage(driver);
        login.enterUserEmail(string);
        login.enterUserPassword(string2);
    }
    @When("Tap on Login")
    public void tap_on_login() {
        login = new LoginPage(driver);
        login.tapOnLogin();
    }

    @Then("Validate the page should be users page")
    public void validate_the_page_should_be_users_page() {

        List<WebElement> userTabs = driver.findElements(By.xpath("//div[@class='MuiGrid-root MuiGrid-container']//span[@class='MuiButton-label']"));
        for (WebElement num : userTabs) {
            String loggedInUsr = num.getText();
            if(loggedInUsr!=null){
                System.out.println("User Sections are: "+loggedInUsr);
            }else {
                System.out.println("Something wrong!!");
            }

        }
        driver.quit();
    }

    @Then("Verify the error message {string}")
    public void verifyTheErrorMessage(String arg0) {
       login = new LoginPage(driver);
       login.verifyErrorMessage(arg0);
    }

    @When("Tap on forgot password hyperlink")
    public void tapOnForgotPasswordHyperlink() {
       login = new LoginPage(driver);
       login.tapOnForgotPasswordHyperlink();

    }

    @And("Entering email id {string}")
    public void enteringEmailId(String arg0) {
       login = new LoginPage(driver);
       login.enterUserEmail(arg0);

    }

    @And("Tap on Reset Password Button")
    public void tapOnResetPasswordButton() {
       login = new LoginPage(driver);
       login.tapOnResetPasswordBtn();
    }

    @Then("Validate the email validation Error message {string}")
    public void validateTheEmailValidationErrorMessage(String arg0) {
      login = new LoginPage(driver);
      login.validateEmailErrorText(arg0);
    }

    @Then("Validate the success message for Reset Email {string} {string}")
    public void validateTheSuccessMessageForResetEmail(String arg0, String arg1) {
        login = new LoginPage(driver);
        login.validateSuccessMessageResetPass(arg0, arg1);
    }

    @Then("Verify the email and password validations {string} {string}")
    public void verifyTheEmailAndPasswordValidations(String arg0, String arg1) {
       login = new LoginPage(driver);
       login.verifyTheEmailAndPasswordValidations(arg0,arg1);
    }
    @Then("User should get logged in to the Admin portal {string}")
    public void userShouldGetLoggedInToTheAdminPortal(String arg0) {
        login = new LoginPage(driver);
        login.validateUserLoginState(arg0);
    }
}