package com.demoqa.pages.elements;

import com.demoqa.base.BasePage;
import com.demoqa.utils.JavaScriptUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonPage extends BasePage {

    private JavaScriptUtils scriptUtils;

    // Constructors
    public RadioButtonPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        this.scriptUtils = new JavaScriptUtils(driver);
    }

    // Select web elements
    @FindBy(xpath = "//li//span[text()='Radio Button']")
    private WebElement radioButtonMenu;

    @FindBy(xpath = "//label[text()='Impressive']")
    private WebElement impressiveRadioButton;

    @FindBy(xpath = "//span[@class='text-success' and text()='Impressive']")
    private WebElement impressiveText;

    @FindBy(xpath = "//label[@for='yesRadio' and text()='Yes']")
    private WebElement yesText;

    // getter
    private WebElement getYesText(){
        customWait.waitForVisibilityOfElement(yesText);
        return yesText;
    }

    private WebElement getImpressiveText(){
        customWait.waitForVisibilityOfElement(impressiveText);
        return impressiveText;
    }

    private WebElement getImpressiveRadioButton(){
        customWait.waitForVisibilityOfElement(impressiveRadioButton);
        return impressiveRadioButton;
    }

    private WebElement getRadioButtonMenu(){
        customWait.waitForVisibilityOfElement(radioButtonMenu);
        return radioButtonMenu;
    }

    // Actions
    public boolean isYesTextDisplay(){
        return getYesText().isDisplayed();
    }

    public void clickOnYesRadioButton(){
        try{
            scriptUtils.clickElementJS(getYesText());
            LOGGER.info("Clicked on Yes radio button!");
        }catch (Exception e){
            LOGGER.error("Failed to click on Yes radio button!", e);
            throw e;
        }
    }

    public boolean isTextDisplay(){
        return getImpressiveText().isDisplayed();
    }

    public void clickOnImpressiveRadioButton(){
        try{
            scriptUtils.clickElementJS(getImpressiveRadioButton());
            LOGGER.info("Clicked on Impressive radio button!");
        }catch (Exception e){
            LOGGER.error("Failed to click on impressive radio button!", e);
            throw e;
        }
    }

    public void clickOnRadioMenu(){
        try{
            getRadioButtonMenu().click();
            LOGGER.info("Clicked on radio menu!");
        }catch (Exception e){
            LOGGER.error("Failed to click on menu!", e);
            throw e;
        }
    }
}
