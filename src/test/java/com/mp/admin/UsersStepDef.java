package com.mp.admin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObject.UsersPage;


public class UsersStepDef {
    WebDriver driver = DriverStep.getInstance().driver;
    UsersPage usersPage = new UsersPage(driver);
    @And("Click on all Subscription Plans")
    public void clickOnAllSubscriptionPlans() {
//        usersPage = new UsersPage(driver);
        usersPage.clickOnAllAvailableSubscriptionPlan();
    }

    @And("Tap on details section for the user")
    public void tapOnDetailsSectionForTheUser() {
//        usersPage = new UsersPage(driver);
        usersPage.tapOnDetailsSectionForTheUser();
    }
    @And("Tap on Add Boards link")
    public void tapOnAddBoardsLink() {
//        usersPage = new UsersPage(driver);
        usersPage.tapOnAddBoardsLink();
    }
    @And("Enter <{string}> Board and then tap on Add boards button")
    public void enterBoardAndThenTapOnAddBoardsButton(String arg0) {
        usersPage.enterBoardCountAndTapOnAddButton(arg0);
    }

    @And("Tap on confirmation pop-up")
    public void tapOnConfirmationPopUp() {
        usersPage.tapOnConfirmationPop_Up();
    }

    @Then("Verify Board Addition Confirmation {string}")
    public void verifyBoardAdditionConfirmation(String arg0) {
        usersPage.verifySuccessBoardPopUp(arg0);
    }

    @When("Shorting user by name as DESC")
    public void shortingUserByNameAsDESC() {
        usersPage.sortUserByNameAsDESC();
    }

    @And("Tap on Delete user button")
    public void tapOnDeleteUserButton() {
        usersPage.tapOnDeleteUsersButton();
    }

    @When("Tap on Free user section")
    public void tapOnFreeUserSection() {
        usersPage.tapOnFreeUserSection();
    }

    @And("Tap on Change to Grandfather Button")
    public void tapOnChangeToGrandfatherButton() {
        usersPage.tapOnChangeToGrandfatherBtn();
    }

    @And("Select Duration {string}")
    public void selectDuration(String arg0) {
        usersPage.selectDurationForTrial(arg0);
    }

    @Then("Verify Confirmation Text {string}")
    public void verifyConfirmationText(String arg0) {
        usersPage.verifyConfirmationMessage(arg0);
    }

    @When("Tap on Trial user section")
    public void tapOnTrialUserSection() {
        usersPage.tapOnTheTrialSection();
    }
    @And("Tap on the change to Free button")
    public void tapOnTheChangeToFreeButton() {
        usersPage.tapOnTheChangeToFreeButton();
    }
    @When("Tap on Grandfather user section")
    public void tapOnGrandfatherUserSection() {
        usersPage.tapOnTheGrandfatherSection();
    }

    @When("Tap on Main Users section")
    public void tapOnMainUsersSection() {
        usersPage.tapOnMainUsersSection();

    }

    @When("Waiting for first row appears")
    public void waitingForFirstRowAppears() {
        usersPage.waitingForFirstRowToBeAppears();
    }



//    @Then("Verify User Deletion Confirmation {string}")
//    public void verifyUserDeletionConfirmation(String arg0) {
//        usersPage.verifyUserDeletionConfirmation(arg0);
//    }
}
