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

    @Test(groups = { "smoke","sanity", "regression" }, description = "Verify add new valid data")
    public void verifyAddValidData(){
        // Step 1: Open login page
        textBoxPage.clickOnTextBoxMenu();
        Assert.assertTrue(textBoxPage.isMainTitleDisplay(), "Text Box not displayed!");
        textBoxPage.scrollTextBoxForm();
        textBoxPage.enterUsername("Nurul Arifin");
        textBoxPage.enterUserEmail("arifin@gmail.com");
        textBoxPage.enterCurrentAddress("Dsn. Ujung Blang, Ajee pagar air.");
        textBoxPage.enterPermanentAddress("Jl. Kapten Yusuf No. 16");
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(textBoxPage.isNameDisplayed(), "Element is not available.");
    }

    @Test(groups = {"regression"}, description = "Verify add new data with empty textfields")
    public void verifyFormValidations(){
        textBoxPage.clickOnTextBoxMenu();
        textBoxPage.scrollTextBoxForm();
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(textBoxPage.isOutputEmpty(),
                "❌ Expected 'Name' element to be hidden or not exist, but it appeared on the page! " + textBoxPage.getEmptyOutput().getText());
    }

    @Test(groups = "regression", description = "Verify add new data with invalid email format")
    public void verifyAddDataWithInvalidEmail(){
        textBoxPage.clickOnTextBoxMenu();
        textBoxPage.scrollTextBoxForm();
        textBoxPage.enterUsername("Nurul Arifin");
        textBoxPage.enterUserEmail("arifingmail.com");
        textBoxPage.enterCurrentAddress("Dsn. Ujung Blang, Ajee pagar air.");
        textBoxPage.enterPermanentAddress("Jl. Kapten Yusuf No. 16");
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(textBoxPage.isEmailFieldErrorVisible(), "Expected class 'field-error' appear, but the sad thing is not!");
    }
}
