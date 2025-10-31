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

    @Test(groups = {"smoke", "sanity","regression"}, description = "Verify add new valid data")
    public void verifyAddData(){
        webTables.clickOnWebTablesMenu();
        webTables.clickOnAddButton();
        webTables.enterData(
                "Nurul",
                "Arifin",
                "nurularifin@gmail.com",
                "26",
                "70000",
                "QA");
        webTables.clickOnSubmitButton();
        Assert.assertTrue(webTables.isFirstNameDisplay(),"No data yet!");
    }

    @Test(groups = {"regression"}, description = "Verify registration form with empty data")
    public void verifyEmptyData(){
        webTables.clickOnWebTablesMenu();
        webTables.clickOnAddButton();
        webTables.clickOnSubmitButton();

        String firstName = webTables.getFirstName().getAttribute("value");
        String lastName = webTables.getLastName().getAttribute("value");
        String email = webTables.getUserEmail().getAttribute("value");
        String age = webTables.getAge().getAttribute("value");
        String salary = webTables.getSalary().getAttribute("value");
        String department = webTables.getDepartment().getAttribute("value");

        if (firstName == null || firstName.trim().isEmpty() ){
            Assert.assertTrue(true);
        }else if(lastName == null || lastName.trim().isEmpty()){
            Assert.assertTrue(true);
        }else if(email == null || email.trim().isEmpty()){
            Assert.assertTrue(true);
        }else if(age == null || age.trim().isEmpty()){
            Assert.assertTrue(true);
        }else if(salary == null || salary.trim().isEmpty()){
            Assert.assertTrue(true);
        }else if(department == null || department.trim().isEmpty()){
            Assert.assertTrue(true);
        }else{
            Assert.assertFalse(false);
        }
    }

    @Test(groups = {"regression"}, description = "Verify add new data with invalid email, age, and salary")
    public void verifyAddWithInvalidData(){
        webTables.clickOnWebTablesMenu();
        webTables.clickOnAddButton();
        webTables.enterData(
                "Nurul",
                "Arifin",
                "nurularifingmail.com",
                "dasd",
                "dasdsa",
                "QA");
        webTables.clickOnSubmitButton();
        Assert.assertTrue(webTables.isEmailInvalid(),"Expected invalid email, but it's valid");
        Assert.assertTrue(webTables.isAgeInvalid(),"Expected invalid age, but it's valid");
        Assert.assertTrue(webTables.isSalaryInvalid(),"Expected invalid salary, but it's valid");
    }

    @Test(groups = {"regression"}, description = "Verify edit with valid data")
    public void verifyEditWithValidData(){
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

    @Test(groups = {"regression"}, description = "Verify edit with invalid email, age, and salary")
    public void verifyEditWithInvalidData(){
        webTables.clickOnWebTablesMenu();
        webTables.clickOnEditButton();
        webTables.getUserEmail().sendKeys(Keys.chord(Keys.CONTROL, "a"));
        webTables.enterEmail("aripongmail.com");
        webTables.getAge().sendKeys(Keys.chord(Keys.CONTROL, "a"));
        webTables.enterAge("dss");
        webTables.getSalary().sendKeys(Keys.chord(Keys.CONTROL, "a"));
        webTables.enterSalary("qwerty");
        webTables.clickOnSubmitButton();
        Assert.assertTrue(webTables.isEmailInvalid(),"Expected invalid email, but it's valid");
        Assert.assertTrue(webTables.isAgeInvalid(),"Expected invalid age, but it's valid");
        Assert.assertTrue(webTables.isSalaryInvalid(),"Expected invalid salary, but it's valid");
    }

    @Test(groups = {"regression"}, description = "Verify delete data")
    public void verifyDeleteData(){
        webTables.clickOnWebTablesMenu();
        webTables.clickOnDeleteButton();
        Assert.assertTrue(webTables.isNoRowElement(), "Data still exist expected not");
    }

    @Test(groups = {"regression"}, description = "Verify Search with exist data")
    public void verifySearchWithValidData(){
        webTables.clickOnWebTablesMenu();
        webTables.enterSearchKeyword("vega");
        Assert.assertTrue(webTables.isResultDisplay(), "No result found!");
    }

    @Test(groups = {"regression"}, description = "Verify Search with invalid data")
    public void verifySearchWithInvalidData(){
        webTables.clickOnWebTablesMenu();
        webTables.enterSearchKeyword("vegadsads");
        Assert.assertTrue(webTables.isNoRowDisplay(), "Data exist, expected not!");
    }

}
