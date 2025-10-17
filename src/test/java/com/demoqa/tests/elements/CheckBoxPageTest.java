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

    @Test(groups = {"sanity1"})
    public void testCheckBox(){
        checkBoxPage.clickOnCheckboxMenu();
        checkBoxPage.clickOnCheckboxHome();
        Assert.assertTrue(checkBoxPage.isResultDisplay(), "No result is appear!");
    }
}