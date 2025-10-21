package com.demoqa.pages.elements;

import com.demoqa.base.BasePage;
import com.demoqa.utils.JavaScriptUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage extends BasePage {

    private JavaScriptUtils scriptUtils;

    // Constructors
    public TextBoxPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        this.scriptUtils = new JavaScriptUtils(driver);
    }

    // Select web element
    @FindBy(xpath = "//li[@id='item-0']//span[text()='Text Box']")
    private WebElement textBoxMenu;

    @FindBy(xpath = "//input[@id='userName']")
    private WebElement userName;

    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement userEmail;

    @FindBy(xpath = "//textarea[@id='currentAddress']")
    private WebElement currentAddress;

    @FindBy(xpath = "//textarea[@id='permanentAddress']")
    private WebElement permanentAddress;

    @FindBy(xpath = "//p[@id='name']")
    private WebElement isNameDisplayed;

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='text-field-container']")
    private WebElement textFieldContainer;

    @FindBy(xpath = "//div[@id='output']")
    private WebElement emptyOutput;

    // Getter
    public WebElement getEmptyOutput(){
        customWait.waitForVisibilityOfElement(emptyOutput);
        return emptyOutput;
    }

    public WebElement getPermanentAddress(){
        customWait.waitForVisibilityOfElement(permanentAddress);
        return permanentAddress;
    }

    public WebElement getCurrentAddress(){
        customWait.waitForVisibilityOfElement(currentAddress);
        return currentAddress;
    }

    public WebElement getUserEmail(){
        customWait.waitForVisibilityOfElement(userEmail);
        return userEmail;
    }

    public WebElement getUserName(){
        customWait.waitForVisibilityOfElement(userName);
        return userName;
    }

    public WebElement getTextBoxMenu(){
        customWait.waitForVisibilityOfElement(textBoxMenu);
        return textBoxMenu;
    }

    public WebElement getIsNameDisplayed(){
        try{
            customWait.waitForVisibilityOfElement(isNameDisplayed);
            return isNameDisplayed;
        }catch (NoSuchElementException | TimeoutException e){
            return null;
        }
    }

    public WebElement getSubmitButton(){
        customWait.waitForVisibilityOfElement(submitButton);
        return submitButton;
    }

    // Page Actions
    public boolean isOutputEmpty() {
        try {
            // Wait until the element is present in DOM (not necessarily visible)
            String text = getEmptyOutput().getText().trim();
            return text.isEmpty();
        } catch (NoSuchElementException | TimeoutException e) {
            // Element not found or not yet loaded = considered empty
            return true;
        }
    }

    public void scrollTextBoxForm(){
        scriptUtils.scrollToElement(textFieldContainer);
    }

    public void clickOnSubmitButton(){
        try{
            scriptUtils.clickElementJS(getSubmitButton());
            LOGGER.info("Clicked on submit button.");
        } catch (Exception e) {
            LOGGER.error("Failed to click on submit button.", e);
            throw e;
        }
    }

    public boolean isNameDisplayed(){
        return getIsNameDisplayed().isDisplayed();
    }

    public void enterPermanentAddress(String permanentAddress){
        try{
            getPermanentAddress().sendKeys(permanentAddress);
            LOGGER.info("Enter a permanent address: {}", permanentAddress);
        } catch (Exception e){
            LOGGER.error("Failed to input permanent address!", e);
            throw e;
        }
    }

    public void enterCurrentAddress(String currentAddress){
        try{
            getCurrentAddress().sendKeys(currentAddress);
            LOGGER.info("Enter a current address: {}", currentAddress);
        } catch (Exception e){
            LOGGER.error("Failed to input current address!", e);
            throw e;
        }
    }

    public void enterUserEmail(String email){
        try{
            getUserEmail().sendKeys(email);
            LOGGER.info("Enter a email: {}", email);
        } catch (Exception e){
            LOGGER.error("Failed to input username!", e);
            throw e;
        }
    }

    public void enterUsername(String username){
        try{
            getUserName().sendKeys(username);
            LOGGER.info("Enter a username: {}", username);
        } catch (Exception e) {
            LOGGER.error("Failed to input username!", e);
            throw e;
        }
    }

    public void clickOnTextBoxMenu(){
        try{
            getTextBoxMenu().click();
            LOGGER.info("Clicked on text box menu.");
        } catch (Exception e) {
            LOGGER.error("Failed to click on textbox.", e);
            throw e;
        }
    }

}
