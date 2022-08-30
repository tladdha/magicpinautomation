package com.mp.admin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDef {

    public static WebDriver driver;

   @Given("Launch the admin portal")
    public void launch_the_admin_portal() {
       System.setProperty("webdriver.chrome.driver","/Users/tusharladdha/Documents/drivers/chromedriver");
       driver = new ChromeDriver();

       driver.navigate().to("https://admin-test.magicpinapp.net/login");
       driver.manage().window().maximize();
       System.out.println("Given Successful");


   }
    @When("Entering valid {string} and {string} credentials")
    public void entering_valid_and_credentials(String string, String string2) {
        WebElement emailFeild = driver.findElement(By.name("email"));
        emailFeild.sendKeys(string);
        WebElement passFeild = driver.findElement(By.name("password"));
        passFeild.sendKeys(string2);
    }
    @When("Tap on Login")
    public void tap_on_login() {
        WebElement loginBtn = driver.findElement(By.xpath("//span[text()='Login']"));
        loginBtn.click();
        System.out.println("When Successful");
    }
    @Then("User should get logged in to the Admin portal")
    public void user_should_get_logged_in_to_the_admin_portal() {

    }
    @Then("Validate the page should be users page")
    public void validate_the_page_should_be_users_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.quit();
    }

}
