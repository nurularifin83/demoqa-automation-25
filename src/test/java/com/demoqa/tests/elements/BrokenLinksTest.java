package com.demoqa.tests.elements;

import com.demoqa.basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinksTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUpPage(){
        homePage.clickOnElements();
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify open the page and image is valid")
    public void verifyValidImage(){
        brokenLinksPage.clickOnBrokenLinksMenu();
        // 1. Check image is displayed
        Assert.assertTrue(brokenLinksPage.getValidImage().isDisplayed(),
                "Image should be visible");

        // 2. Check src attribute
        Assert.assertTrue(brokenLinksPage.getImageSrc().contains("/images/Toolsqa.jpg"),
                "Image SRC should be correct");
    }
}
