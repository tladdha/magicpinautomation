package com.mp.admin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObject.AdvertisementPage;

public class AdvertisementStepDef {
    WebDriver driver = DriverStep.getInstance().driver;
    AdvertisementPage addPage = new AdvertisementPage(driver);

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
}
