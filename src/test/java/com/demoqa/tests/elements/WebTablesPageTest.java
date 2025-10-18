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

    @Test(groups =  "sanity1dsad")
    public void testWebTables(){
        webTables.clickOnWebTablesMenu();
        webTables.clickOnAddButton();
        webTables.enterFirstName("Nurul");
        webTables.enterLastName("Arifin");
        webTables.enterEmail("arifin@gmail.com");
        webTables.enterAge("27");
        webTables.enterSalary("7000000");
        webTables.enterDepartment("QA");
        webTables.clickOnSubmitButton();

        webTables.clickOnEditButton();
        webTables.getLastName().click();
        webTables.getLastName().sendKeys(Keys.chord(Keys.CONTROL, "a"));
        webTables.enterLastName("Aripon");
        webTables.getUserEmail().click();
        webTables.getUserEmail().sendKeys(Keys.chord(Keys.CONTROL, "a"));
        webTables.enterEmail("aripon@gmail.com");
        webTables.clickOnSubmitButton();
        Assert.assertTrue(webTables.isFirstNameDisplay(),"No data yet!");

        webTables.clickOnDeleteButton();
    }
}
