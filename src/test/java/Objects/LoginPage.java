package Objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    // create constructor always
    public LoginPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Initialise all WebElements here..
    @FindBy(name = "email")
    WebElement emailField_textBox;
    @FindBy(name = "password")
    WebElement passField_textBox;
    @FindBy(xpath = "//span[text()='Login']")
    WebElement login_Btn;
    @FindBy(xpath="//div[@role='alert']//p")
    WebElement errorPath_text;
    @FindBy(xpath = "//a[@href=\"/forgotpassword\"]")
    WebElement forgotPass_link;
    @FindBy(xpath = "//button//span[text()=\"Reset Password\"]")
    WebElement resetPass_btn;
    @FindBy(xpath = "//h6[text()=\"Email\"]//parent::div//p")
    WebElement emailError_Text;
    @FindBy(xpath = "//p[contains(text(),\"password\")]")
    WebElement successReset_text;
    @FindBy(xpath = "//h6[text()=\"Password\"]//parent::div//p")
    WebElement passError_Text;
    @FindBy(xpath = "//p[text()='SYSTEM MANAGEMENT']")
    WebElement loggedInText;


    // Create All identification methods here...
    public void waitTillElementVisible(WebElement type){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(type));
    }

    public void enterUserEmail(String email){
        try {
            //waitTillElementVisible(emailField_textBox);
            emailField_textBox.sendKeys(email);
        }catch (Exception e){
            System.out.println("Search Box for Email is not found.. "+e.getMessage());
        }
    }
    public void enterUserPassword(String pass){
        try {
            waitTillElementVisible(emailField_textBox);
            passField_textBox.sendKeys(pass);
        }catch (Exception e){
            System.out.println("Search Box for Password is not found.. "+e.getMessage());
        }
    }
    public void tapOnLogin(){
        try {
            login_Btn.click();
        }catch (Exception e){
            System.out.println("Login Button on screen is not found.. "+e.getMessage());
        }
    }
    public void verifyErrorMessage(String message){
        try {
            waitTillElementVisible(errorPath_text);
            String errText = errorPath_text.getText();
            Assert.assertEquals(errText, message, "Error Message Text not Matched..");
            driver.quit();
        }catch (Exception e){
            Assert.fail("Error message over screen not found..");
            System.out.println("Error message over screen not found.. "+e.getMessage());
            driver.quit();
        }
    }
    public void validateSuccessMessageResetPass(String expectedMessage, String expectedConfirmPopup){
        try {
            waitTillElementVisible(errorPath_text);
            String actualSuccessText = errorPath_text.getText();
            Assert.assertEquals(actualSuccessText, expectedConfirmPopup, "Success text not matched with expected..");
            waitTillElementVisible(successReset_text);
            String actualConfirmText = successReset_text.getText();
            Assert.assertEquals(actualConfirmText, expectedMessage, "Confirmation text not matched with expected..");
            driver.quit();
        }catch (Exception e){
            Assert.fail("Reset Password confirmation not provided by application..");
            System.out.println("Reset Password confirmation not provided by application "+ e.getMessage());
            driver.quit();
        }
    }

    public void verifyTheEmailAndPasswordValidations(String expEmailText, String expPassText){
        try{
            waitTillElementVisible(emailError_Text);
            String actEmailText = emailError_Text.getText();
            Assert.assertEquals(actEmailText, expEmailText, "Expected email validation text not match with Actual..");
            waitTillElementVisible(passError_Text);
            String actPassText = passError_Text.getText();
            Assert.assertEquals(actPassText,expPassText, "Expected password validation text not match with Actual..");
            driver.quit();
        }catch (Exception e){
            Assert.fail("Error text for email or Password not found..");
            System.out.println("Error text for email or Password not found "+e.getMessage());
            driver.quit();
        }
    }

    public void tapOnForgotPasswordHyperlink(){
        try {
            waitTillElementVisible(forgotPass_link);
            forgotPass_link.click();
        }catch (Exception e)
        {
            Assert.fail("forgot Password hyperlink not found..");
            System.out.println("Forgot Password link not found.. "+e.getMessage());
        }
    }

    public void tapOnResetPasswordBtn(){
        try{
            waitTillElementVisible(resetPass_btn);
            resetPass_btn.click();
        }catch (Exception e){
            Assert.fail("Reset Password not found..");
            System.out.println("Reset Password.. "+e.getMessage());
        }
    }
    public void validateEmailErrorText(String expectedText){
        try{
            waitTillElementVisible(emailError_Text);
            String actualText = emailError_Text.getText();
            Assert.assertEquals(actualText,expectedText, "Expected email error text not match with Actual..");
            driver.quit();
        }catch (Exception e){
            Assert.fail("Email Error Text not found..");
            System.out.println("Email Error Text not found "+e.getMessage());
            driver.quit();
        }
    }
    public void validateUserLoginState(String string){
        try {
            waitTillElementVisible(loggedInText);
            String logText = loggedInText.getText();
            Assert.assertEquals(logText, string, "After logged in text not match with Expected text..");
        }catch (Exception e){
            Assert.fail("After Log in text not found..");
            System.out.println("After Log in text not found "+e.getMessage());
        }
    }
}