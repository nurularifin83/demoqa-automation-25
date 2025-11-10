package com.demoqa.pages.elements;

import com.demoqa.base.BasePage;
import com.demoqa.utils.JavaScriptUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class ButtonsPage extends BasePage {

    private JavaScriptUtils scriptUtils;

    // Constructors
    public ButtonsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        this.scriptUtils = new JavaScriptUtils(driver);
    }

    // Select web elements
    @FindBy(xpath = "//li[@id='item-4']//span[text()='Buttons']")
    private WebElement buttonsMenu;

    @FindBy(xpath = "//button[@id='doubleClickBtn']")
    private WebElement doubleClickBtn;

    @FindBy(xpath = "//p[@id='doubleClickMessage']")
    private WebElement doubleClickMessage;

    @FindBy(xpath = "//button[@id='rightClickBtn']")
    private WebElement rightClickBtn;

    @FindBy(xpath = "//p[@id='rightClickMessage']")
    private WebElement rightClickMessage;

    @FindBy(xpath = "//button[text()='Click Me']")
    private WebElement clickMe;

    @FindBy(xpath = "//p[@id='dynamicClickMessage']")
    private WebElement dynamicClickMessage;

    // Getters
    private WebElement getDynamicClickMessage(){
        By locator = By.xpath("//p[@id='dynamicClickMessage']");
        customWait.waitForVisibility(locator);
        return driver.findElement(locator);
    }

    private WebElement getClickMe(){
        customWait.waitForVisibilityOfElement(clickMe);
        return clickMe;
    }

    private WebElement getRightClickMessage(){
        By locator = By.xpath("//p[@id='rightClickMessage']");
        customWait.waitForVisibility(locator);
        return driver.findElement(locator);
    }

    private WebElement getRightClickBtn(){
        By locator = By.xpath("//button[@id='rightClickBtn']");
        customWait.waitForVisibility(locator);
        return driver.findElement(locator);
    }

    private WebElement getDoubleClickMessage(){
        By locator = By.xpath("//p[@id='doubleClickMessage']");
        customWait.waitForVisibility(locator);
        return driver.findElement(locator);
    }

    private WebElement getDoubleClickBtn(){
        By locator = By.xpath("//button[@id='doubleClickBtn']");
        customWait.waitForVisibility(locator);
        return driver.findElement(locator);
    }

    private WebElement getButtonsMenu(){
        customWait.waitForVisibilityOfElement(buttonsMenu);
        return buttonsMenu;
    }

    // Actions
    public boolean isClickMeMessageAppear(){
        return getDynamicClickMessage().isDisplayed();
    }

    public void clickMe(){
        try {
            getClickMe().click();
            LOGGER.info("Successfully performed click me.");
        }catch (Exception e){
            LOGGER.error("Failed to perform click me", e);
            throw e;
        }
    }

    public boolean isRightClickMessageAppear(){
        return getRightClickMessage().isDisplayed();
    }

    public void rightClick(){
        try{
            WebElement button = getRightClickBtn();
            Actions actions = new Actions(driver);
            actions.contextClick(button).perform();
            LOGGER.info("Successfully performed right click on the button.");
        }catch (Exception e){
            LOGGER.error("Failed to perform right click", e);
            throw e;
        }
    }

    public boolean isDoubleClickMessageAppear(){
        return getDoubleClickMessage().isDisplayed();
    }

    public void doubleClick(){
        try{
            Actions actions = new Actions(driver);
            actions.doubleClick(getDoubleClickBtn()).perform();
            LOGGER.info("Clicked on double click button");
        }catch (Exception e){
            LOGGER.error("Failed to click on double click button", e);
            throw e;
        }
    }

    public void clickOnButtonsMenu(){
        try{
            getButtonsMenu().click();
            LOGGER.info("Clicked on buttons menu");
        }catch (Exception e){
            LOGGER.error("Failed to click on button ", e);
            throw e;
        }
    }

}
