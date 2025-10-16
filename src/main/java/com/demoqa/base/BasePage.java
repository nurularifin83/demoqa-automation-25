package com.demoqa.base;

import com.demoqa.utils.ConfigReader;
import com.demoqa.utils.CustomWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected CustomWait customWait;
    protected ConfigReader configReader;
    protected static final Logger LOGGER = LogManager.getLogger(BasePage.class);

    @FindBy(xpath = "//a[@href='https://demoqa.com']")
    private WebElement logo;

    // Constructor
    public BasePage(WebDriver driver){
        configReader = new ConfigReader();
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.customWait = new CustomWait(driver, Duration.ofSeconds(configReader.getGlobalWaitValue()));
    }

    public WebDriver getDriver(String browser) {
        if (browser.equalsIgnoreCase(configReader.getBrowser())) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--incognito");

            // unique data dir for GitHub Actions
            String runId = System.getenv("GITHUB_RUN_ID");
            if (runId != null) {
                options.addArguments("--user-data-dir=/tmp/chrome_" + runId);
            }

            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            driver = new FirefoxDriver(options);
        } else {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless=new");
            driver = new EdgeDriver(options);
        }

        driver.manage().window().maximize();
        return driver;
    }


    /*public WebDriver getDriver(String browser){
        if (browser.equalsIgnoreCase(configReader.getBrowser())){
            ChromeOptions options = new ChromeOptions();

            // CI friendly options
            options.addArguments("--incognito");
            options.addArguments("--headless=new"); // headless mode for GitHub Actions
            options.addArguments("--no-sandbox"); // required for Linux runners
            options.addArguments("--disable-dev-shm-usage"); // avoid memory issues

            // unique user data dir per run to avoid "already in use"
            String runId = System.getenv("GITHUB_RUN_ID");
            if (runId != null) {
                options.addArguments("--user-data-dir=/tmp/chrome_" + runId);
            }

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("firefox")){
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless"); // headless for CI
            driver.manage().window().maximize();
        }else {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless=new"); // headless for CI
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }*/

    public WebElement getLogo(){
        customWait.waitForVisibilityOfElement(logo);
        return logo;
    }

    public void quiteDriver(){
        driver.quit();
    }

    public boolean isLogoDisplayed(){
        try{
            return getLogo().isDisplayed();
        }catch (NoSuchElementException e){
            LOGGER.error("Logo is not present on the page!", e);
            return false;
        }
    }

    public String getPageTitle(){
        try{
            return driver.getTitle();
        }catch (WebDriverException e){
            LOGGER.error("Failed to retrieve the page title!", e);
            return "";
        }
    }

    public String getCurrentPageURL(){
        return driver.getCurrentUrl();
    }

}
