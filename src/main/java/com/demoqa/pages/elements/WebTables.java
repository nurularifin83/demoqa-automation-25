package com.demoqa.pages.elements;

import com.demoqa.base.BasePage;
import com.demoqa.utils.JavaScriptUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTables extends BasePage {

    private JavaScriptUtils scriptUtils;

    // Constructors
    public WebTables(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        this.scriptUtils = new JavaScriptUtils(driver);
    }

    // Select web elements
    @FindBy(xpath = "//span[text()='Web Tables']")
    private WebElement webTablesMenu;

    @FindBy(xpath = "//button[@id='addNewRecordButton']")
    private WebElement addNewRecordButton;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement userEmail;

    @FindBy(xpath = "//input[@id='age']")
    private WebElement age;

    @FindBy(xpath = "//input[@id='salary']")
    private WebElement salary;

    @FindBy(xpath = "//input[@id='department']")
    private WebElement department;

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "(//div[@class='rt-tr-group'])[4]")
    private WebElement firstNameColumn;

    @FindBy(xpath = "//span[@id='delete-record-4']")
    private WebElement deleteButton;

    @FindBy(xpath = "//span[@id='edit-record-4']")
    private WebElement editButton;

    // Getter
    private WebElement getEditButton(){
        customWait.waitForVisibilityOfElement(editButton);
        return editButton;
    }

    private WebElement getDeleteButton(){
        customWait.waitForVisibilityOfElement(deleteButton);
        return deleteButton;
    }

    private WebElement getFirstNameColumn(){
        customWait.waitForVisibilityOfElement(firstNameColumn);
        return firstNameColumn;
    }

    private WebElement getSubmitButton(){
        customWait.waitForVisibilityOfElement(submitButton);
        return submitButton;
    }

    private WebElement getDepartment(){
        customWait.waitForVisibilityOfElement(department);
        return department;
    }

    private WebElement getSalary(){
        customWait.waitForVisibilityOfElement(salary);
        return salary;
    }

    private WebElement getAge(){
        customWait.waitForVisibilityOfElement(age);
        return age;
    }

    public WebElement getUserEmail(){
        customWait.waitForVisibilityOfElement(userEmail);
        return userEmail;
    }

    public WebElement getLastName(){
        customWait.waitForVisibilityOfElement(lastName);
        return lastName;
    }

    private WebElement getFirstName(){
        customWait.waitForVisibilityOfElement(firstName);
        return firstName;
    }

    private WebElement getAddNewRecordButton(){
        customWait.waitForVisibilityOfElement(addNewRecordButton);
        return addNewRecordButton;
    }

    private WebElement getWebTablesMenu(){
        customWait.waitForVisibilityOfElement(webTablesMenu);
        return webTablesMenu;
    }

    // Actions
    public void clickOnDeleteButton(){
        try{
            getDeleteButton().click();
            LOGGER.info("Clicked on delete button!");
        }catch (Exception e){
            LOGGER.error("Failed to click on delete button!", e);
            throw e;
        }
    }

    public void clickOnEditButton(){
        try{
            getEditButton().click();
            LOGGER.info("Clicked on edit button!");
        }catch (Exception e){
            LOGGER.error("Failed to click on edit button!", e);
            throw e;
        }
    }

    public boolean isFirstNameDisplay(){
        return getFirstNameColumn().isDisplayed();
    }

    public void clickOnSubmitButton(){
        try{
            getSubmitButton().click();
            LOGGER.info("Clicked on submit button!");
        }catch (Exception e){
            LOGGER.error("Failed to click on submit button!", e);
            throw e;
        }
    }

    public void enterDepartment(String department){
        try{
            getDepartment().sendKeys(department);
            LOGGER.info("Enter department: {}", department);
        }catch (Exception e){
            LOGGER.error("Failed input department!", e);
            throw e;
        }
    }

    public void enterSalary(String salary){
        try{
            getSalary().sendKeys(salary);
            LOGGER.info("Enter salary: {}", salary);
        }catch (Exception e){
            LOGGER.error("Failed input salary!", e);
            throw e;
        }
    }

    public void enterAge(String age){
        try{
            getAge().sendKeys(age);
            LOGGER.info("Enter age: {}", age);
        }catch (Exception e){
            LOGGER.error("Failed input age!", e);
            throw e;
        }
    }

    public void enterEmail(String email){
        try{
            getUserEmail().sendKeys(email);
            LOGGER.info("Enter user email: {}", email);
        }catch (Exception e){
            LOGGER.error("Failed input user email!", e);
            throw e;
        }
    }

    public void enterLastName(String lastName){
        try{
            getLastName().sendKeys(lastName);
            LOGGER.info("Enter last name: {}", lastName);
        }catch (Exception e){
            LOGGER.error("Failed input last name!", e);
            throw e;
        }
    }

    public void enterFirstName(String name){
        try{
            getFirstName().sendKeys(name);
            LOGGER.info("Enter first name: {}", name);
        }catch (Exception e){
            LOGGER.error("Failed input first name!", e);
            throw e;
        }
    }

    public void clickOnAddButton(){
        try{
            getAddNewRecordButton().click();
            LOGGER.info("Clicked on Add button!");
        }catch (Exception e){
            LOGGER.error("Failed to click on Add button!", e);
            throw e;
        }
    }

    public void clickOnWebTablesMenu(){
        try{
            getWebTablesMenu().click();
            LOGGER.info("Clicked on the menu!");
        }catch (Exception e){
            LOGGER.error("Failed to clicked on menu!", e);
            throw e;
        }
    }
}
