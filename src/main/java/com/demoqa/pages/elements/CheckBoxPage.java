package com.demoqa.pages.elements;

import com.demoqa.base.BasePage;
import com.demoqa.utils.JavaScriptUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    // Getter
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
    public boolean isResultDisplay(){
        return getCheckboxMenu().isDisplayed();
    }

    public void clickOnCheckboxHome(){
        try{
            getCheckboxHome().click();
            LOGGER.info("Clicked on checkbox Home!");
        }catch (Exception e){
            LOGGER.error("Failed to click on the checkbox home!", e);
            throw e;
        }
    }

    public void clickOnCheckboxMenu(){
        try{
            getCheckboxMenu().click();
            LOGGER.info("Clicked on checkbox menu!");
        }catch (Exception e){
            LOGGER.error("Failed to click on the menu", e);
            throw e;
        }
    }

}
