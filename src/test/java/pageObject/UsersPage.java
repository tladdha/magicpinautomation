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
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UsersPage {
    WebDriver driver;
    private static String[] plans = {"All Subscriptions", "Free", "Trial","Monthly","Lifetime","Grandfather"};

    public UsersPage(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    // define all web-elements here..
    @FindBy(xpath="//div[@class='MuiGrid-root MuiGrid-container']//span[@class='MuiButton-label']/parent::button")
    List<WebElement> multibutton_leble;

    @FindBy(xpath = "//tr[1]//button//span[text()=\"Details\"]/parent::button")
    WebElement firstLineUser_row;
    @FindBy(linkText = "+ Add Boards")
    WebElement addBoard_link;
    @FindBy(xpath = "//label[text()=\"Boards\"]/parent::div/div/input")
    WebElement addBoard_inputField;
    @FindBy(xpath = "//span[text()=\"Add Boards\"]/parent::button")
    WebElement  addBoard_btn;
    @FindBy(xpath = "//span[text()=\"Confirm\"]/parent::button")
    WebElement confirm_button;
    @FindBy(xpath = "//div[@role=\"alert\"]//div/p")
    WebElement success_popup;
    @FindBy(xpath = "//h4[contains(text(),\"boards\")]")
    WebElement addBoardPopUp_Text;
    @FindBy(xpath = "//span[@role=\"button\" and text()=\"Name\"]")
    WebElement nameColumn_text;
    @FindBy(xpath = "//span[text()=\"Delete User\"]/parent::button")
    WebElement deleteUsers_btn;
    @FindBy(xpath = "//*[contains(text(),\"Successfully\")]")
    WebElement deleteConfirmation_Text;
    @FindBy(xpath = "//span[text()=\"Free\"]/parent::button")
    WebElement freeSubscription_btn;
    @FindBy(xpath = "//span[text()=\"Change to Grandfather\"]/parent::button")
    WebElement changeToGrandfather_btn;
    @FindBy(xpath = "//div[@role=\"button\" and text()=\"Forever\"]")
    WebElement duration_dropDown;
    @FindBy(xpath="//div[contains(text(),'!')]")
    WebElement errorPath_text;
    @FindBy(xpath = "//span[text()=\"Trial\"]/parent::button")
    WebElement trial_button;
    @FindBy(xpath = "//span[text()=\"Grandfather\"]/parent::button")
    WebElement grandfather_button;
    @FindBy(xpath = "//span[text()=\"Change to Free\"]/parent::button")
    WebElement changeToFree_button;


    //Define all identification methods here...

    public void verifyElementPresentOnScreen(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void verifyAllSubscriptionsUnderUserScreen(){
        multibutton_leble.forEach(myElement -> {
            try {
                verifyElementPresentOnScreen(myElement);
                String subscriptionPlan = myElement.getText();
                Assert.assertTrue("Subscription Plan not found..", subscriptionPlan != null);
            }catch (Exception e){
                Assert.fail("Subscription Plan not found..");
            }
        });
        driver.quit();
    }

    public void clickOnAllAvailableSubscriptionPlan(){
        try {
            for (String Plan:plans) {
                WebElement cPlan = driver.findElement(By.xpath("//span[text()='"+Plan+"']/parent::button"));
                cPlan.click();
            }
            driver.quit();
        }catch (Exception e)
        {
            Assert.fail("User Plan not found.."+e.getMessage());
        }

    }
    public void tapOnDetailsSectionForTheUser(){
        try{
            verifyElementPresentOnScreen(firstLineUser_row);
            firstLineUser_row.click();
        }catch (Exception e){
            Assert.fail("First line of user not found.."+e.getMessage());
        }
    }
    public void tapOnAddBoardsLink(){
        try{
            Thread.sleep(3000);
            verifyElementPresentOnScreen(addBoard_link);
            addBoard_link.click();
        }catch (Exception e)
        {
            Assert.fail("Add Board Link not found.."+e.getMessage());
        }
    }
    public void enterBoardCountAndTapOnAddButton(String x){
        try{
//            Thread.sleep(3000);
            verifyElementPresentOnScreen(addBoard_inputField);
            addBoard_inputField.clear();
            addBoard_inputField.sendKeys(x);
            addBoardPopUp_Text.click();
            addBoard_btn.click();
        }catch (Exception e){
            Assert.fail("Something went wrong for entering board count and tapping on Add button "+e.getMessage());
        }
    }
    public void tapOnConfirmationPop_Up(){
        try{
            verifyElementPresentOnScreen(confirm_button);
//            DevTools devTools = ((HasDevTools) driver).getDevTools();
//            devTools.createSession();
//            devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()) );
//            devTools.addListener(Network.responseReceived(), response -> {
//                Response res = response.getResponse();
//                System.out.println("response url : "+res.getUrl());
//                System.out.println("response status : "+res.getStatus());
//                System.out.println("response Body : "+res.toString());
//            });
//            devTools.addListener(Network.requestWillBeSent(), request -> {
//                Request res = request.getRequest();
//                System.out.println("request url : "+res.getUrl());
//                System.out.println("request Body : "+res.toString());
//            });
            confirm_button.click();

        }catch (Exception e){
            Assert.fail("Confirmation popup not appeared.."+e.getMessage());
        }
    }
    public void verifySuccessBoardPopUp(String eText){
        try{
            verifyElementPresentOnScreen(success_popup);
            String aText = success_popup.getText();
            Assert.assertEquals("Success Message for Board addition is not matched..",aText, eText);
            driver.quit();
        }catch (Exception e){
            Assert.fail("Success popup not appeared.."+e.getMessage());
            driver.quit();
        }
    }
    public void sortUserByNameAsDESC(){
        try{
            verifyElementPresentOnScreen(nameColumn_text);
            nameColumn_text.click();
            verifyElementPresentOnScreen(firstLineUser_row);
            nameColumn_text.click();
            verifyElementPresentOnScreen(firstLineUser_row);
        }catch (Exception e){
            Assert.fail("Sorting of user not happens properly by name.."+e.getMessage());
        }

    }
    public void tapOnDeleteUsersButton(){
        try{
            Thread.sleep(4000);
            verifyElementPresentOnScreen(deleteUsers_btn);
            deleteUsers_btn.click();
        }catch (Exception e){
            Assert.fail("Delete button not loaded properly.."+e.getMessage());
        }
    }
    public void verifyUserDeletionConfirmation(String eText){
        try{
            verifyElementPresentOnScreen(deleteConfirmation_Text);
            Assert.assertEquals(eText+" - Text not found!", eText, deleteConfirmation_Text.getText());
            //Assert.assertTrue(eText+" - Text not found!", driver.getPageSource().contains(eText));
            driver.quit();
        }catch (Exception e){
            Assert.fail("Delete Confirmation Text not found! "+e.getMessage());
        }
    }
    public void tapOnFreeUserSection(){
        try{
            verifyElementPresentOnScreen(freeSubscription_btn);
            freeSubscription_btn.click();
            verifyElementPresentOnScreen(firstLineUser_row);
        }catch (Exception e){
            Assert.fail("Something went wrong on tap of Free Subscription plan.."+e.getMessage());
        }
    }
    public void tapOnChangeToGrandfatherBtn(){
        try{
            verifyElementPresentOnScreen(changeToGrandfather_btn);
            Thread.sleep(4000);
            changeToGrandfather_btn.click();
        }catch (Exception e){
            Assert.fail("Change to grandfather btn not appears.."+e.getMessage());
        }
    }
    public void selectDurationForTrial(String str){
        try{
            verifyElementPresentOnScreen(duration_dropDown);
            duration_dropDown.click();
            WebElement duration = driver.findElement(By.xpath("//li[text()='"+str+"']"));
            duration.click();
            confirm_button.click();
        }catch (Exception e)
        {
            Assert.fail("Something went wrong while selecting the duration.."+e.getMessage());
        }
    }
    public void verifyConfirmationMessage(String msg){
        try{
            verifyElementPresentOnScreen(errorPath_text);
            Assert.assertEquals("Text for confirmation not matching",msg,errorPath_text.getText());
            driver.quit();
        }catch (Exception e)
        {
            Assert.fail("Something went wrong while selecting the duration.."+e.getMessage());
        }
    }
    public void tapOnTheTrialSection(){
        try{
            verifyElementPresentOnScreen(trial_button);
            trial_button.click();
            verifyElementPresentOnScreen(firstLineUser_row);
        }catch(Exception e){
            Assert.fail("Something went wrong while loading the users from Trial section.."+e.getMessage());
        }
    }
    public void tapOnTheChangeToFreeButton(){
        try{
            verifyElementPresentOnScreen(changeToFree_button);
            Thread.sleep(4000);
            changeToFree_button.click();
        }catch(Exception e){
            Assert.fail("Something went wrong while loading change to free button "+e.getMessage());
        }
    }
    public void tapOnTheGrandfatherSection(){
        try{
            verifyElementPresentOnScreen(grandfather_button);
            grandfather_button.click();
            verifyElementPresentOnScreen(firstLineUser_row);
        }catch (Exception e){
            Assert.fail("Something went wrong while loading the grandfather section list.. "+e.getMessage());
        }
    }

}
