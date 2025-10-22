package com.demoqa.tests.elements;

import com.demoqa.basetest.BaseTest;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTablesPageTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUpPage(){
        homePage.clickOnElements();
    }

    @Test(groups = {"smoke", "sanity","regression"}, description = "Verify add user with valid data")
    public void verifyAddData(){
        webTables.clickOnWebTablesMenu();
        webTables.clickOnAddButton();
        webTables.enterFirstName("Nurul");
        webTables.enterLastName("Arifin");
        webTables.enterEmail("arifin@gmail.com");
        webTables.enterAge("27");
        webTables.enterSalary("7000000");
        webTables.enterDepartment("QA");
        webTables.clickOnSubmitButton();
        Assert.assertTrue(webTables.isFirstNameDisplay(),"No data yet!");
    }

    @Test(groups = {"sanity","regression"}, description = "Verify edit user with valid data")
    public void verifyEditData(){
        webTables.clickOnWebTablesMenu();
        webTables.clickOnEditButton();
        webTables.getLastName().click();
        webTables.getLastName().sendKeys(Keys.chord(Keys.CONTROL, "a"));
        webTables.enterLastName("Aripon");
        webTables.getUserEmail().click();
        webTables.getUserEmail().sendKeys(Keys.chord(Keys.CONTROL, "a"));
        webTables.enterEmail("aripon@gmail.com");
        webTables.clickOnSubmitButton();
        Assert.assertTrue(webTables.isFirstNameDisplay(),"No data yet!");
    }

    @Test(groups = {"regression"}, description = "Verify delete data")
    public void verifyDeleteData(){
        webTables.clickOnWebTablesMenu();
        webTables.clickOnDeleteButton();
        Assert.assertTrue(webTables.isNoRowElement(), "Data still exist expected not");
    }

    @Test(groups = {"regression"}, description = "Search valid data and the data should appear")
    public void verifySearchWithValidData(){
        webTables.clickOnWebTablesMenu();
        webTables.enterSearchKeyword("vega");
        Assert.assertTrue(webTables.isResultDisplay(), "No result found!");
    }

    @Test(groups = {"regression"}, description = "Search invalid data and the data should not appear")
    public void verifySearchWithInvalidData(){
        webTables.clickOnWebTablesMenu();
        webTables.enterSearchKeyword("vegadsads");
        Assert.assertTrue(webTables.isNoRowDisplay(), "Data exist, expected not!");
    }

}
