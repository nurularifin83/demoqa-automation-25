package com.demoqa.tests.elements;

import com.demoqa.basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinksPageTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUpPage(){
        homePage.clickOnElements();
    }

    @Test(groups = {"smoke","regression1"}, description = "Verify click on Home link")
    public void verifyClickOnHome(){
        linksPage.clickOnLinksMenu();
        linksPage.clickOnHomeLink();
        String actualUrl = linksPage.clickOnHomeAndGetNewTabUrl();
        String expectedUrl = "https://demoqa.com/";

        Assert.assertEquals(actualUrl, expectedUrl, "Home link did not open the expected URL");
    }

    @Test(groups = {"regression1"}, description = "Verify click on HomeIDJtt")
    public void verifyClickOnHomeIDJtt(){
        linksPage.clickOnLinksMenu();
        linksPage.clickOnHomelDJttLink();
        String actualUrl = linksPage.clickOnHomeAndGetNewTabUrl();
        String expectedUrl = "https://demoqa.com/";

        Assert.assertEquals(actualUrl, expectedUrl, "Home link did not open the expected URL");
    }

    @Test(groups = {"regression1"}, description = "Verify click on Created link")
    public void verifyClickOnCreatedLink(){
        linksPage.clickOnLinksMenu();
        linksPage.clickOnCreatedLink();
        String expectedText = linksPage.isTextResponseAppear();
        Assert.assertTrue(expectedText.contains("Created"),
                "Expected 'Created' in response, but got: " + expectedText);
    }

    @Test(groups = {"regression1"}, description = "Verify click on Moved link")
    public void verifyClickOnMovedLink(){
        linksPage.clickOnLinksMenu();
        linksPage.clickOnNoContent();
        String expectedText = linksPage.isTextResponseAppear();
        Assert.assertTrue(expectedText.contains("No Content"),
                "Expected 'No Content' in response, but got: " + expectedText);
    }

    @Test(groups = {"regression1"}, description = "Verify click on Moved Permanently link")
    public void verifyClickOnNoContentLink(){
        linksPage.clickOnLinksMenu();
        linksPage.clickOnMoved();
        String expectedText = linksPage.isTextResponseAppear();
        Assert.assertTrue(expectedText.contains("Moved Permanently"),
                "Expected 'Moved Permanently' in response, but got: " + expectedText);
    }

    @Test(groups = {"regression1"}, description = "Verify click on Bad Request link")
    public void verifyClickOnBadRequestLink(){
        linksPage.clickOnLinksMenu();
        linksPage.clickOnBadRequest();
        String expectedText = linksPage.isTextResponseAppear();
        Assert.assertTrue(expectedText.contains("Bad Request"),
                "Expected 'Bad Request' in response, but got: " + expectedText);
    }

    @Test(groups = {"regression1"}, description = "Verify click on Unauthorized link")
    public void verifyClickOnUnauthorizedLink(){
        linksPage.clickOnLinksMenu();
        linksPage.clickOnUnauthorizedLink();
        String expectedText = linksPage.isTextResponseAppear();
        Assert.assertTrue(expectedText.contains("Unauthorized"),
                "Expected 'Unauthorized' in response, but got: " + expectedText);
    }

    @Test(groups = {"regression1"}, description = "Verify click on Forbidden link")
    public void verifyClickOnForbiddenLink(){
        linksPage.clickOnLinksMenu();
        linksPage.clickOnForbidden();
        String expectedText = linksPage.isTextResponseAppear();
        Assert.assertTrue(expectedText.contains("Forbidden"),
                "Expected 'Forbidden' in response, but got: " + expectedText);
    }

    @Test(groups = {"regression1"}, description = "Verify click on Not Found link")
    public void verifyClickOnNotFoundLink(){
        linksPage.clickOnLinksMenu();
        linksPage.clickOnNotFound();
        String expectedText = linksPage.isTextResponseAppear();
        Assert.assertTrue(expectedText.contains("Not Found"),
                "Expected 'Not Found' in response, but got: " + expectedText);
    }
}
