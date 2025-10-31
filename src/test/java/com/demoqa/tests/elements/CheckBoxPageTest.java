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

    @Test(groups = {"smoke","regression"}, description = "Verify Check box is checked")
    public void verifyCheckboxChecked(){
        checkBoxPage.clickOnCheckboxMenu();
        Assert.assertTrue(checkBoxPage.isMainTitleDisplay(), "Check box page not displayed!");
        checkBoxPage.clickOnCheckboxHome();
        Assert.assertTrue(checkBoxPage.isCheckboxChecked(), "Fail to checked check box");
    }

    @Test(groups = {"regression"}, description = "Verify Check box is unchecked")
    public void verifyCheckboxUnchecked(){
        checkBoxPage.clickOnCheckboxMenu();
        checkBoxPage.clickOnCheckboxHome();
        checkBoxPage.clickOnCheckboxHome();
        Assert.assertTrue(checkBoxPage.isResultNotDisplay(), "Result div exists expected not.");
    }

    @Test(groups = {"regression"}, description = "Verify Collapse all button working when clicking")
    public void verifyCheckboxMinimize(){
        checkBoxPage.clickOnCheckboxMenu();
        checkBoxPage.clickOnCheckboxHome();
        checkBoxPage.clickOnExpandButton();
        checkBoxPage.clickOnCollapseButton();
        Assert.assertTrue(checkBoxPage.isCollapseBoxDisplay(), "Collapse all not working");
    }

    @Test(groups = {"regression"}, description = "Verify Expand all button working when clicking")
    public void verifyCheckboxMaximize(){
        checkBoxPage.clickOnCheckboxMenu();
        checkBoxPage.clickOnCheckboxHome();
        checkBoxPage.clickOnExpandButton();
        Assert.assertTrue(checkBoxPage.isExpandBoxDisplay(), "Expand all not working");
    }
}