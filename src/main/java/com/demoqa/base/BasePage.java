package com.demoqa.base;

import com.demoqa.utils.ConfigReader;
import com.demoqa.utils.CustomWait;
import io.github.bonigarcia.wdm.WebDriverManager;
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

import java.io.File;
import java.time.Duration;
import java.util.UUID;

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
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();

            // ✅ Only add user-data-dir in CI to avoid Windows crash
            if (System.getenv("GITHUB_ACTIONS") != null || System.getenv("CI") != null) {
                options.addArguments("--user-data-dir=/tmp/chrome-" + UUID.randomUUID());
            }

            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-infobars");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-notifications");

            // ✅ Run headless only in CI
            if (System.getenv("GITHUB_ACTIONS") != null || System.getenv("HEADLESS") != null) {
                options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
            }

            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            if (System.getenv("GITHUB_ACTIONS") != null || System.getenv("HEADLESS") != null) {
                options.addArguments("-headless");
            }
            options.addPreference("remote.active-protocols", 1);
            driver = new FirefoxDriver(options);

        } else if (browser.equalsIgnoreCase("edge")){
            // Set driver path only if running on Windows
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                System.setProperty("webdriver.edge.driver", "C:\\WebDrivers\\msedgedriver.exe");
            }
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        return driver;
    }


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
