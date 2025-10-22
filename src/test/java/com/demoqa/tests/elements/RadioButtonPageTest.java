package com.demoqa.tests.elements;

import com.demoqa.basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonPageTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void testSetUp(){
        homePage.clickOnElements();
    }

    @Test(groups = {"smoke", "sanity","regression"}, description = "Radio button impressive should be selected")
    public void verifyRadioButtonImpressiveClicked(){
        radioButtonPage.clickOnRadioMenu();
        Assert.assertTrue(radioButtonPage.isMainTitleDisplay(), "The page not opened");
        radioButtonPage.clickOnImpressiveRadioButton();
        Assert.assertTrue(radioButtonPage.isTextDisplay(), "No text is appear");
    }

    @Test(groups = {"regression"}, description = "Radio button Yes should be selected")
    public void verifyRadioButtonYesClicked(){
        radioButtonPage.clickOnRadioMenu();
        radioButtonPage.clickOnImpressiveRadioButton();
        radioButtonPage.clickOnYesRadioButton();
        Assert.assertTrue(radioButtonPage.isYesTextDisplay(), "No result to display");
    }

}
