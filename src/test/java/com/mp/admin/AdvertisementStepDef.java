package com.mp.admin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObject.AdvertisementPage;
import pageObject.UsersPage;

public class AdvertisementStepDef {
    WebDriver driver = DriverStep.getInstance().driver;
    AdvertisementPage addPage = new AdvertisementPage(driver);
    UsersPage userPage = new UsersPage(driver);
    @Then("Add new Advertisement {string}")
    public void addNewAdvertisement(String arg0) {
        addPage.addNewAdvertisement(arg0);
    }


    @When("User taps on Main Advertisement Section")
    public void userTapsOnMainAdvertisementSection() {
        addPage.tapOnTheAdvertisementOptions();
    }

    @And("Rename Advertisement from {string} to {string}")
    public void renameAdvertisementFromTo(String fromText, String toText) {
        addPage.renameAnAdvertisementName(fromText,toText);

    }

    @Then("Verify the name changed to {string}")
    public void verifyTheNameChangedTo(String arg0) {
        addPage.verifyTheNameChanged(arg0);
    }



    @Then("Verify the {string} Add becomes {string}")
    public void verifyTheAddBecomes(String arg0, String arg1) {
        addPage.verifyTheButtonStatus(arg0,arg1);
    }

    @And("Tap on status button of add {string}")
    public void tapOnStatusButtonOfAdd(String arg0) {
        addPage.tapOnTheInactiveAddButton(arg0);
    }

    @And("Tap on the delete option of an inactive add {string}")
    public void tapOnTheDeleteOptionOfAnInactiveAdd(String arg0) {
        addPage.tapOnTheDeleteAddButton(arg0);
    }

    @Then("verify the add with name {string} not present")
    public void verifyTheAddWithNameNotPresent(String arg0) {
        addPage.verifyTheAddWithNameNotPresent(arg0);
    }

    @When("Navigate to home page")
    public void navigateToHomePage() {
        userPage.goToHomePage();
    }
}
