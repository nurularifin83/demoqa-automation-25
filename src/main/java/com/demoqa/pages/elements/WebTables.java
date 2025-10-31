package com.demoqa.pages.elements;

import com.demoqa.base.BasePage;
import com.demoqa.utils.JavaScriptUtils;
import org.openqa.selenium.*;
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

    @FindBy(xpath = "//span[@id='delete-record-3']")
    private WebElement deleteButton;

    @FindBy(xpath = "//span[@id='edit-record-3']")
    private WebElement editButton;

    @FindBy(xpath = "//input[@id='searchBox']")
    private WebElement searchBox;

    @FindBy(xpath = "//div[@class='rt-td' and text()='Vega']")
    private WebElement searchResult;

    @FindBy(xpath = "//div[@class='rt-noData' and text()='No rows found']")
    private WebElement noRowsFound;

    @FindBy(xpath = "//h1[text()='Web Tables']")
    private WebElement mainTitle;

    // Getter
    public WebElement getMainTitle(){
        customWait.waitForVisibilityOfElement(mainTitle);
        return mainTitle;
    }

    public WebElement getNoRowsFound(){
        customWait.waitForVisibilityOfElement(noRowsFound);
        return noRowsFound;
    }

    public WebElement getSearchResult(){
        customWait.waitForVisibilityOfElement(searchResult);
        return searchResult;
    }

    public WebElement getSearchBox(){
        customWait.waitForVisibilityOfElement(searchBox);
        return searchBox;
    }

    public WebElement getEditButton(){
        customWait.waitForVisibilityOfElement(editButton);
        return editButton;
    }

    public WebElement getDeleteButton(){
        customWait.waitForVisibilityOfElement(deleteButton);
        return deleteButton;
    }

    public WebElement getFirstNameColumn(){
        customWait.waitForVisibilityOfElement(firstNameColumn);
        return firstNameColumn;
    }

    public WebElement getSubmitButton(){
        customWait.waitForVisibilityOfElement(submitButton);
        return submitButton;
    }

    public WebElement getDepartment(){
        customWait.waitForVisibilityOfElement(department);
        return department;
    }

    public WebElement getSalary(){
        customWait.waitForVisibilityOfElement(salary);
        return salary;
    }

    public WebElement getAge(){
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

    public WebElement getFirstName(){
        customWait.waitForVisibilityOfElement(firstName);
        return firstName;
    }

    public WebElement getAddNewRecordButton(){
        customWait.waitForVisibilityOfElement(addNewRecordButton);
        return addNewRecordButton;
    }

    public WebElement getWebTablesMenu(){
        customWait.waitForVisibilityOfElement(webTablesMenu);
        return webTablesMenu;
    }

    // Actions
    public boolean isAgeInvalid() {
        return isFieldInvalid(getAge());
    }

    public boolean isSalaryInvalid() {
        return isFieldInvalid(getSalary());
    }

    public boolean isEmailInvalid() {
        return isFieldInvalid(getUserEmail());
    }

    public boolean isFieldInvalid(WebElement element){
        Boolean isValid = (Boolean) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].checkValidity();", element);
        return isValid == null || !isValid ;
    }

    public boolean isMainTitleDisplay(){
        return getMainTitle().isDisplayed();
    }

    public boolean isNoRowElement(){
        try {
            return !getDeleteButton().isDisplayed(); // visible → false, not visible → true
        } catch (NoSuchElementException | TimeoutException e) {
            return true; // element truly not found or not visible
        }
    }

    public boolean isNoRowDisplay(){
        return getNoRowsFound().isDisplayed();
    }

    public boolean isResultDisplay(){
        return getSearchResult().isDisplayed();
    }

    public void enterSearchKeyword(String keyword){
        try{
            getSearchBox().sendKeys(keyword);
            LOGGER.info("Enter keyword: {}", keyword);
        }catch (Exception e){
            LOGGER.error("Failed to input keyword!", e);
            throw e;
        }
    }

    public void clickOnDeleteButton(){
        try{
            scriptUtils.clickElementJS(getDeleteButton());
            LOGGER.info("Clicked on delete button!");
        }catch (Exception e){
            LOGGER.error("Failed to click on delete button!", e);
            throw e;
        }
    }

    public void clickOnEditButton(){
        try{
            scriptUtils.clickElementJS(getEditButton());
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
            scriptUtils.clickElementJS(getSubmitButton());
            LOGGER.info("Clicked on submit button!");
        }catch (Exception e){
            LOGGER.error("Failed to click on submit button!", e);
            throw e;
        }
    }

    public void enterData(String firstName, String lastName, String email, String age, String salary, String department){
        try{
            getFirstName().sendKeys(firstName);
            getLastName().sendKeys(lastName);
            getUserEmail().sendKeys(email);
            getAge().sendKeys(age);
            getSalary().sendKeys(salary);
            getDepartment().sendKeys(department);
            LOGGER.info("Enter First Name: {}", firstName);
            LOGGER.info("Enter Last Name: {}", lastName);
            LOGGER.info("Enter Email: {}", email);
            LOGGER.info("Enter Age: {}", age);
            LOGGER.info("Enter Salary: {}", salary);
            LOGGER.info("Enter Department: {}", department);
        }catch (Exception e){
            LOGGER.error("Fail to input data!", e);
            throw e;
        }
    }

    public void enterSalary(String salary){
        try{
            getSalary().sendKeys(salary);
            LOGGER.info("Enter user salary: {}", salary);
        }catch (Exception e){
            LOGGER.error("Failed input user salary!", e);
            throw e;
        }
    }

    public void enterAge(String age){
        try{
            getAge().sendKeys(age);
            LOGGER.info("Enter user age: {}", age);
        }catch (Exception e){
            LOGGER.error("Failed input user age!", e);
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

    public void clickOnAddButton(){
        try{
            scriptUtils.clickElementJS(getAddNewRecordButton());
            LOGGER.info("Clicked on Add button!");
        }catch (Exception e){
            LOGGER.error("Failed to click on Add button!", e);
            throw e;
        }
    }

    public void clickOnWebTablesMenu(){
        try{
            scriptUtils.clickElementJS(getWebTablesMenu());
            LOGGER.info("Clicked on the menu!");
        }catch (Exception e){
            LOGGER.error("Failed to clicked on menu!", e);
            throw e;
        }
    }
}
