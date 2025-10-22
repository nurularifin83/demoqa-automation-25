package com.demoqa.tests.elements;

import com.demoqa.basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxPageTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUpPage(){
        homePage.clickOnElements();
    }

    @Test(groups = {"smoke", "sanity", "regression"}, description = "Checkbox should be checked")
    public void verifyCheckboxChecked(){
        // Step 1: Open checkbox page
        checkBoxPage.clickOnCheckboxMenu();
        Assert.assertTrue(checkBoxPage.isMainTitleDisplay(), "Checkbox page not displayed!");

        // Step 2: Checkbox checked
        checkBoxPage.clickOnCheckboxHome();

        // Step 3: Verify checkbox checked successfully
        Assert.assertTrue(checkBoxPage.isCheckboxChecked(), "Checkbox should be checked");
    }

    @Test(groups = {"regression"}, description = "Checkbox should be unchecked")
    public void verifyCheckboxUnchecked(){
        checkBoxPage.clickOnCheckboxMenu();
        checkBoxPage.clickOnCheckboxHome();
        checkBoxPage.clickOnCheckboxHome();
        Assert.assertTrue(checkBoxPage.isResultNotDisplay(), "Result div exists but should not be present.");
    }

    @Test(groups = {"regression"}, description = "Checkbox minimize should be collapse")
    public void verifyCheckboxMinimize(){
        checkBoxPage.clickOnCheckboxMenu();
        checkBoxPage.clickOnCheckboxHome();
        checkBoxPage.clickOnExpandButton();
        checkBoxPage.clickOnCollapseButton();
        Assert.assertTrue(checkBoxPage.isCollapseBoxDisplay(), "Collapse box not appear");
    }

    @Test(groups = {"regression"}, description = "Checkbox maximize should be expand")
    public void verifyCheckboxMaximize(){
        checkBoxPage.clickOnCheckboxMenu();
        checkBoxPage.clickOnCheckboxHome();
        checkBoxPage.clickOnExpandButton();
        Assert.assertTrue(checkBoxPage.isExpandBoxDisplay(), "Expand box not appear");
    }
}