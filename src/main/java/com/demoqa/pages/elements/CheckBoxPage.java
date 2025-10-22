package com.demoqa.pages.elements;

import com.demoqa.base.BasePage;
import com.demoqa.utils.JavaScriptUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckBoxPage extends BasePage {

    private JavaScriptUtils scriptUtils;

    // Constructors
    public CheckBoxPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        this.scriptUtils = new JavaScriptUtils(driver);
    }

    // Select web elements
    @FindBy(xpath = "//div[@class='display-result mt-4']")
    private  WebElement result;

    @FindBy(xpath = "//li[@id='item-1']//span[text()='Check Box']")
    private WebElement checkboxMenu;

    @FindBy(xpath = "//label[@for='tree-node-home']")
    private WebElement checkboxHome;

    @FindBy(xpath = "//div[@id='result']")
    private WebElement noOutput;

    @FindBy(xpath = "//button[@class='rct-option rct-option-expand-all']")
    private WebElement buttonExpand;

    @FindBy(xpath = "//button[@class='rct-option rct-option-collapse-all']")
    private WebElement buttonCollapse;

    @FindBy(xpath = "(//li[@class='rct-node rct-node-parent rct-node-expanded'])[1]")
    private WebElement expandBox;

    @FindBy(xpath = "(//li[@class='rct-node rct-node-parent rct-node-collapsed'])[1]")
    private WebElement collapseBox;

    @FindBy(xpath = "//h1[text()='Check Box']")
    private WebElement mainTitle;

    // Getter
    public WebElement getMainTitle(){
        customWait.waitForVisibilityOfElement(mainTitle);
        return mainTitle;
    }

    public WebElement getCollapseBox(){
        customWait.waitForVisibilityOfElement(collapseBox);
        return collapseBox;
    }

    public WebElement getExpandBox(){
        customWait.waitForVisibilityOfElement(expandBox);
        return expandBox;
    }

    public WebElement getButtonCollapse(){
        customWait.waitForVisibilityOfElement(buttonCollapse);
        return buttonCollapse;
    }

    public WebElement getButtonExpand(){
        customWait.waitForVisibilityOfElement(buttonExpand);
        return buttonExpand;
    }

    public WebElement getNoOutput(){
        customWait.waitForVisibilityOfElement(noOutput);
        return noOutput;
    }

    public WebElement getResult(){
        customWait.waitForVisibilityOfElement(result);
        return result;
    }

    public WebElement getCheckboxHome(){
        customWait.waitForVisibilityOfElement(checkboxHome);
        return checkboxHome;
    }

    public WebElement getCheckboxMenu(){
        customWait.waitForVisibilityOfElement(checkboxMenu);
        return checkboxMenu;
    }

    // Actions
    public boolean isMainTitleDisplay(){
        return getMainTitle().isDisplayed();
    }

    public boolean isCollapseBoxDisplay(){
        return getCollapseBox().isDisplayed();
    }

    public boolean isExpandBoxDisplay(){
        return getExpandBox().isDisplayed();
    }

    public void clickOnCollapseButton(){
        try {
            scriptUtils.clickElementJS(getButtonCollapse());
            LOGGER.info("Click on collapse button successfully!");
        } catch (Exception e) {
            LOGGER.error("Failed when try to click on collapse button", e);
            throw e;
        }
    }

    public void clickOnExpandButton(){
        try {
            scriptUtils.clickElementJS(getButtonExpand());
            LOGGER.info("Click on expand button successfully!");
        } catch (Exception e) {
            LOGGER.error("Failed when try to click on expand button", e);
            throw e;
        }
    }

    public boolean isResultNotDisplay(){
        try {
            return !getNoOutput().isDisplayed();
        } catch (NoSuchElementException e) {
            return true; // Element truly doesn’t exist
        }
    }

    public boolean isCheckboxChecked(){
        return getCheckboxMenu().isDisplayed();
    }

    public void clickOnCheckboxHome(){
        try{
            scriptUtils.clickElementJS(getCheckboxHome());
            LOGGER.info("Clicked on checkbox Home!");
        }catch (Exception e){
            LOGGER.error("Failed to click on the checkbox home!", e);
            throw e;
        }
    }

    public void clickOnCheckboxMenu(){
        try{
            scriptUtils.clickElementJS(getCheckboxMenu());
            LOGGER.info("Clicked on checkbox menu!");
        }catch (Exception e){
            LOGGER.error("Failed to click on the menu", e);
            throw e;
        }
    }

}
