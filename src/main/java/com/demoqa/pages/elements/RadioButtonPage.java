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

    // getter
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
    public boolean isTextDisplay(){
        return getImpressiveText().isDisplayed();
    }

    public void clickOnRadioButton(){
        try{
            getImpressiveRadioButton().click();
            LOGGER.info("Clicked on radio button!");
        }catch (Exception e){
            LOGGER.error("Failed to click on radio button!", e);
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
