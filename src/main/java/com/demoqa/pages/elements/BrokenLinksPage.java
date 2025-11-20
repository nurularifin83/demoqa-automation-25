package com.demoqa.pages.elements;

import com.demoqa.base.BasePage;
import com.demoqa.utils.JavaScriptUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrokenLinksPage extends BasePage {

    JavaScriptUtils scriptUtils;

    public BrokenLinksPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        this.scriptUtils = new JavaScriptUtils(driver);
    }

    // Select elements
    @FindBy(xpath = "(//li[@id='item-6'])[1]")
    private WebElement brokenLinksMenu;

    @FindBy(xpath = "(//img[@src='/images/Toolsqa.jpg'])[2]")
    private WebElement validImage;

    // Getter
    public WebElement getBrokenLinksMenu(){
        customWait.waitForVisibilityOfElement(brokenLinksMenu);
        return brokenLinksMenu;
    }

    public WebElement getValidImage(){
        customWait.waitForVisibilityOfElement(validImage);
        return validImage;
    }

    public String getImageSrc() {
        return validImage.getAttribute("src");
    }

    // Actions
    public void clickOnBrokenLinksMenu(){
        try{
            getBrokenLinksMenu().click();
            LOGGER.info("Clicked on the Broken Links menu.");
        }catch (Exception e){
            LOGGER.error("Failed to click on the menu!");
            throw e;
        }
    }


}
