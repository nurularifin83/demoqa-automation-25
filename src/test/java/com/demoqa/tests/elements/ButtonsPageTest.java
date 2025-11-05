package com.demoqa.tests.elements;

import com.demoqa.basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsPageTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUpPage(){
        homePage.clickOnElements();
    }

    @Test(groups = {"smoke"}, description = "Verify page is opened and button working")
    public void verifyDoubleClickButton(){
        buttonsPage.clickOnButtonsMenu();
        buttonsPage.doubleClick();
        Assert.assertTrue(buttonsPage.isDoubleClickMessageAppear(), "Error, message not appear");
    }
}
