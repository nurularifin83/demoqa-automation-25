package com.demoqa.tests.elements;

import com.demoqa.basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxPageTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUpPage(){
        homePage.clickOnElements();
    }

    @Test(groups = { "sanity", "regression" }, description = "Verify textbox form with valid data")
    public void testTextBox(){
        textBoxPage.clickOnTextBoxMenu();
        textBoxPage.scrollTextBoxForm();
        textBoxPage.enterUsername("Nurul Arifin");
        textBoxPage.enterUserEmail("arifin@gmail.com");
        textBoxPage.enterCurrentAddress("Dsn. Ujung Blang, Ajee pagar air.");
        textBoxPage.enterPermanentAddress("Jl. Kapten Yusuf No. 16");
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(textBoxPage.isNameDisplayed(), "Element is not available.");
    }

    @Test(groups = {"regression"}, description = "Verify textbox form with empty data")
    public void verifyFormValidations(){
        textBoxPage.clickOnTextBoxMenu();
        textBoxPage.scrollTextBoxForm();
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(textBoxPage.isOutputEmpty(),
                "❌ Expected 'Name' element to be hidden or not exist, but it appeared on the page! " + textBoxPage.getEmptyOutput().getText());
    }
}
