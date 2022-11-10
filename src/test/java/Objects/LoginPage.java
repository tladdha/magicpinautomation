package Objects;


import org.asynchttpclient.netty.channel.ConnectionSemaphore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    // create constructor always
    public LoginPage (WebDriver driver){
        this.driver = driver;
    }

    // Intialise all xpaths here
    By emailFeild_textBox = By.name("email");
    By passFeild_textBox = By.name("password");
    By login_Btn = By.xpath("//span[text()='Login']");
    By errorPath_text = By.xpath("//div[@role='alert']//p");
    By forgotPass_link = By.xpath("//a[@href=\"/forgotpassword\"]");
    By resetPass_btn = By.xpath("//button//span[text()=\"Reset Password\"]");
    By emailError_Text = By.xpath("//h6[text()=\"Email\"]//parent::div//p");
    By successReset_text = By.xpath("//p[contains(text(),\"password\")]");
    By passError_Text = By.xpath("//h6[text()=\"Password\"]//parent::div//p");
    // Create methods here
    public void waitTillElementVisible(By type){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(type));
    }

    public void enterUserEmail(String email){
        try {
            driver.findElement(emailFeild_textBox).sendKeys(email);
        }catch (Exception e){
            System.out.println("Search Box for Email is not found.. "+e.getMessage());
        }

    }
    public void enterUserPassword(String pass){
        try {
            driver.findElement(passFeild_textBox).sendKeys(pass);
        }catch (Exception e){
            System.out.println("Search Box for Password is not found.. "+e.getMessage());
        }
    }
    public void tapOnLogin(){
        try {
            driver.findElement(login_Btn).click();
        }catch (Exception e){
            System.out.println("Login Button on screen is not found.. "+e.getMessage());
        }

    }
    public void verifyErrorMessage(String message){
        try {
            waitTillElementVisible(errorPath_text);
            String errText = driver.findElement(errorPath_text).getText();
            Assert.assertEquals(errText, message);
            driver.quit();
        }catch (Exception e){
            Assert.fail("Error message over screen not found..");
            System.out.println("Error message over screen not found.. "+e.getMessage());
        }
    }
    public void validateSuccessMessageResetPass(String expectedMessage, String expectedConfirmPopup){
        try {
            waitTillElementVisible(errorPath_text);
            String actualSuccessText = driver.findElement(errorPath_text).getText();
            Assert.assertEquals(actualSuccessText, expectedConfirmPopup);
            waitTillElementVisible(successReset_text);
            String actualConfirmText = driver.findElement(successReset_text).getText();
            Assert.assertEquals(actualConfirmText, expectedMessage);
            driver.quit();
        }catch (Exception e){
            Assert.fail("Reset Password confirmation not provided by application..");
            System.out.println("Reset Password confirmation not provided by application "+ e.getMessage());
        }
    }

    public void verifyTheEmailAndPasswordValidations(String expEmailText, String expPassText){
        try{
            waitTillElementVisible(emailError_Text);
            String actEmailText = driver.findElement(emailError_Text).getText();
            Assert.assertEquals(actEmailText, expEmailText);

            waitTillElementVisible(passError_Text);
            String actPassText = driver.findElement(passError_Text).getText();
            Assert.assertEquals(actPassText,expPassText);
            driver.quit();
        }catch (Exception e){
            Assert.fail("Error text for email or Password not found..");
            System.out.println("Error text for email or Password not found "+e.getMessage());
        }


    }

    public void tapOnForgotPasswordHyperlink(){
        try {
            waitTillElementVisible(forgotPass_link);
            driver.findElement(forgotPass_link).click();
        }catch (Exception e)
        {
            Assert.fail("forgot Password hyperlink not found..");
            System.out.println("Forgot Passoword link not found.. "+e.getMessage());
        }
    }

    public void tapOnResetPasswordBtn(){
        try{
            waitTillElementVisible(resetPass_btn);
            driver.findElement(resetPass_btn).click();
        }catch (Exception e){
            Assert.fail("Reset Password not found..");
            System.out.println("Reset Password.. "+e.getMessage());
        }
    }
    public void validateEmailErrorText(String expectedText){
        waitTillElementVisible(emailError_Text);
        String actualText = driver.findElement(emailError_Text).getText();
        Assert.assertEquals(actualText,expectedText);

    }

}
