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

    @Test(groups = {"sanity121"})
    public void testRadioButton(){
        radioButtonPage.clickOnRadioMenu();
        radioButtonPage.clickOnRadioButton();
        Assert.assertTrue(radioButtonPage.isTextDisplay(), "No text is appear");
    }
}
