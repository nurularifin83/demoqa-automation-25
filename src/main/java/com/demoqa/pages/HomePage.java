package com.demoqa.pages;

import com.demoqa.base.BasePage;
import com.demoqa.utils.JavaScriptUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    // Variables
    private JavaScriptUtils scriptUtils;

    // Constructors
    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        this.scriptUtils = new JavaScriptUtils(driver);
    }

    // Select web element
    @FindBy(xpath = "//div[@class='card-body']//h5[text()='Elements']")
    private WebElement elements;

    // Getter
    public WebElement getElements(){
        customWait.waitForElementToBeClickable(elements);
        return elements;
    }

    // Page actions
    public void clickOnElements(){
        try{
            scriptUtils.clickElementJS(getElements());
            LOGGER.info("Clicked on elements.");
        }catch (Exception e){
            LOGGER.error("Failed to click on elements.", e);
            throw e;
        }
    }
}
