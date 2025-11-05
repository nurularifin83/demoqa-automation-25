package com.demoqa.pages.elements;

import com.demoqa.base.BasePage;
import com.demoqa.utils.JavaScriptUtils;
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


    // Getters
    private WebElement getDoubleClickMessage(){
        customWait.waitForVisibilityOfElement(doubleClickMessage);
        return doubleClickMessage;
    }

    private WebElement getDoubleClickBtn(){
       customWait.waitForVisibilityOfElement(doubleClickBtn);
       return doubleClickBtn;
    }

    private WebElement getButtonsMenu(){
        customWait.waitForVisibilityOfElement(buttonsMenu);
        return buttonsMenu;
    }

    // Actions
    public boolean isDoubleClickMessageAppear(){
        try {
            String message = getDoubleClickMessage().getText();
            LOGGER.info("Double click message text: " + message);
            return message.equals("You have done a double click");
        } catch (Exception e) {
            LOGGER.error("Failed to verify double click message", e);
            return false;
        }
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
