package com.demoqa.pages.elements;

import com.demoqa.base.BasePage;
import com.demoqa.utils.JavaScriptUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LinksPage extends BasePage {

    private JavaScriptUtils scriptUtils;

    // Constructors
    public LinksPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        this.scriptUtils = new JavaScriptUtils(driver);
    }

    // Select elements
    @FindBy(xpath = "(//li[@id=\"item-5\"])[1]")
    private WebElement linksMenu;

    @FindBy(xpath = "//a[@id='simpleLink']")
    private WebElement simpleLink;

    @FindBy(xpath = "//a[@id='dynamicLink']")
    private WebElement dynamicLink;

    @FindBy(xpath = "//a[@id='created']")
    private WebElement createdLink;

    @FindBy(xpath = "//a[@id='no-content']")
    private WebElement noContentLink;

    @FindBy(xpath = "//a[@id='moved']")
    private WebElement movedLink;

    @FindBy(xpath = "//a[@id='bad-request']")
    private WebElement badRequestLink;

    @FindBy(xpath = "//a[@id='unauthorized']")
    private WebElement unauthorizedLink;

    @FindBy(xpath = "//a[@id='forbidden']")
    private WebElement forbiddenLink;

    @FindBy(xpath = "//a[@id='invalid-url']")
    private WebElement invalidUrlLink;

    @FindBy(xpath = "//p[@id='linkResponse']")
    private WebElement linkResponse;

    @FindBy(xpath = "//div[@id='linkWrapper']")
    private WebElement linkWrapper;

    // Getter
    private WebElement getLinkWrapper(){
        customWait.waitForVisibilityOfElement(linkWrapper);
        return linkWrapper;
    }

    private WebElement getLinkResponse(){
        customWait.waitForVisibilityOfElement(linkResponse);
        return linkResponse;
    }

    private WebElement getInvalidUrlLink(){
        customWait.waitForVisibilityOfElement(invalidUrlLink);
        return invalidUrlLink;
    }

    private WebElement getForbiddenLink(){
        customWait.waitForVisibilityOfElement(forbiddenLink);
        return forbiddenLink;
    }

    private WebElement getUnauthorizedLink(){
        customWait.waitForVisibilityOfElement(unauthorizedLink);
        return unauthorizedLink;
    }

    private WebElement getBadRequestLink(){
        customWait.waitForVisibilityOfElement(badRequestLink);
        return badRequestLink;
    }

    private WebElement getMovedLink(){
        customWait.waitForVisibilityOfElement(movedLink);
        return movedLink;
    }

    private WebElement getNoContentLink(){
        customWait.waitForVisibilityOfElement(noContentLink);
        return noContentLink;
    }

    private WebElement getCreatedLink(){
        customWait.waitForVisibilityOfElement(createdLink);
        return createdLink;
    }

    private WebElement getDynamicLink(){
        customWait.waitForVisibilityOfElement(dynamicLink);
        return dynamicLink;
    }

    private WebElement getSimpleLink(){
        customWait.waitForVisibilityOfElement(simpleLink);
        return simpleLink;
    }

    private WebElement getLinksMenu(){
        customWait.waitForVisibilityOfElement(linksMenu);
        return linksMenu;
    }

    // Actions
    public String isTextResponseAppear(){
        return getLinkResponse().getText().trim();
    }

    public void clickOnNotFound(){
        try{
            scriptUtils.scrollToElement(getLinkWrapper());
            scriptUtils.clickElementJS(getInvalidUrlLink());
            LOGGER.info("Click on Not Found link successfully");
        }catch (Exception e){
            LOGGER.error("Failed to click on Not Found Link");
            throw e;
        }
    }

    public void clickOnForbidden(){
        try{
            scriptUtils.clickElementJS(getForbiddenLink());
            LOGGER.info("Click on Forbidden link successfully");
        }catch (Exception e){
            LOGGER.error("Failed to click on Forbidden Link");
            throw e;
        }
    }

    public void clickOnUnauthorizedLink(){
        try{
            scriptUtils.clickElementJS(getUnauthorizedLink());
            LOGGER.info("Click on Unauthorized link successfully");
        }catch (Exception e){
            LOGGER.error("Failed to click on Unauthorized Link");
            throw e;
        }
    }

    public void clickOnBadRequest(){
        try{
            scriptUtils.clickElementJS(getBadRequestLink());
            LOGGER.info("Click on Bad Request link successfully");
        }catch (Exception e){
            LOGGER.error("Failed to click on Bad Request Link");
            throw e;
        }
    }

    public void clickOnMoved(){
        try{
            getMovedLink().click();
            LOGGER.info("Click on Moved link successfully");
        }catch (Exception e){
            LOGGER.error("Failed to click on Moved Link");
            throw e;
        }
    }

    public void clickOnNoContent(){
        try{
            getNoContentLink().click();
            LOGGER.info("Click on No Content link successfully");
        }catch (Exception e){
            LOGGER.error("Failed to click on No Content Link");
            throw e;
        }
    }

    public void clickOnCreatedLink(){
        try{
            getCreatedLink().click();
            LOGGER.info("Click on Created link successfully");
        }catch (Exception e){
            LOGGER.error("Failed to click on Created Link");
            throw e;
        }
    }

    public void clickOnHomelDJttLink(){
        try{
            getDynamicLink().click();
            LOGGER.info("Click on HomeIDJtt link successfully");
        }catch (Exception e){
            LOGGER.error("Failed to click on HomeIDJtt Link");
            throw e;
        }
    }

    public void clickOnHomeLink(){
        try{
            getSimpleLink().click();
            LOGGER.info("Click on Home link successfully");
        }catch (Exception e){
            LOGGER.error("Failed to click on Home Link");
            throw e;
        }
    }

    public void clickOnLinksMenu(){
        try{
            getLinksMenu().click();
            LOGGER.info("Click on Links menu successfully");
        }catch (Exception e){
            LOGGER.error("Failed to click on Links menu!");
            throw e;
        }
    }

    public String clickOnHomeAndGetNewTabUrl() {
        String mainWindow = driver.getWindowHandle();

        customWait.waitUntilCondition(d -> d.getWindowHandles().size() > 1);

        for (String window : driver.getWindowHandles()) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        String newTabUrl = driver.getCurrentUrl();
        driver.close();
        driver.switchTo().window(mainWindow);

        return newTabUrl;
    }


}
