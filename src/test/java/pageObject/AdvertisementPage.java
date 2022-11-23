package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdvertisementPage {
    WebDriver driver;
    public AdvertisementPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[text()='Add Media Option']/parent::button")
    WebElement advertisementAdd_text;
    @FindBy(xpath = "//p[text()=\"Advertisement Options\"]//parent::span/parent::a")
    WebElement mainAdvertisement_text;

    @FindBy(xpath = "//tr[1]//td[contains(text(),\"users\")]")
    WebElement firstLine_text;

    @FindBy(id = "outlined-number")
    WebElement inputField_box;
    @FindBy(xpath = "//span[text()='Add Option']/parent::button")
    WebElement addOption_button;

    @FindBy(xpath = "//span[text()= \"Update Name\"]/parent::button")
    WebElement updateName_button;

    public void verifyElementPresentOnScreen(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void addNewAdvertisement(String text){
        verifyElementPresentOnScreen(advertisementAdd_text);
        advertisementAdd_text.click();
        verifyElementPresentOnScreen(inputField_box);
        inputField_box.sendKeys(text);
        verifyElementPresentOnScreen(addOption_button);
        addOption_button.click();
    }
    public void tapOnTheAdvertisementOptions(){
        verifyElementPresentOnScreen(mainAdvertisement_text);
        mainAdvertisement_text.click();
        verifyElementPresentOnScreen(firstLine_text);
    }
    public void renameAnAdvertisementName(String fromText, String toText){
        WebElement pathFrom = driver.findElement(By.xpath("//a[text()= '"+fromText+"']/parent::td/parent::tr//td[4]//button"));
        pathFrom.click();
        verifyElementPresentOnScreen(inputField_box);
        inputField_box.sendKeys(toText);
        verifyElementPresentOnScreen(updateName_button);
        updateName_button.click();
    }
    public void verifyTheNameChanged(String fromText){
        try{
            Thread.sleep(5000);
            verifyElementPresentOnScreen(firstLine_text);
            Assert.assertTrue(driver.findElements( By.xpath("//a[text()='"+fromText+"']")).size() != 0);
        }catch (Exception e){
            Assert.fail("Not able to find Advertisement with renamed name : "+fromText+" :"+e.getMessage());
        }
    }
}
