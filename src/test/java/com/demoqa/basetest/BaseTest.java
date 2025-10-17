package com.demoqa.basetest;

import com.aventstack.extentreports.Status;
import com.demoqa.base.BasePage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.elements.CheckBoxPage;
import com.demoqa.pages.elements.RadioButtonPage;
import com.demoqa.pages.elements.TextBoxPage;
import com.demoqa.pages.elements.WebTables;
import com.demoqa.reports.ExtentReportManager;
import com.demoqa.testdatareaders.ExcelReader;
import com.demoqa.utils.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.xml.XmlSuite;

import java.lang.reflect.Method;

public class BaseTest {

    private static ThreadLocal<WebDriver> localDriver = new ThreadLocal<>();
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);
    public BasePage basePage;
    public WebDriver driver;

    // Pages
    public HomePage homePage;
    public TextBoxPage textBoxPage;
    public CheckBoxPage checkBoxPage;
    public RadioButtonPage radioButtonPage;
    public WebTables webTables;

    public ConfigReader configReader;
    public ExcelReader excelReader;

    private static int totalTests = 0;
    private static int passedTests = 0;
    private static int failedTests = 0;
    private static int skippedTests = 0;

    public WebDriver getLocalDriver(){
        return localDriver.get();
    }

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(){

        configReader = new ConfigReader();

        // Get context manually from Reporter
        ITestContext context = Reporter.getCurrentTestResult().getTestContext();

        if (configReader.getParallelMode().equalsIgnoreCase("Yes")) {
            XmlSuite suite = context.getSuite().getXmlSuite();
            suite.setThreadCount(Integer.parseInt(configReader.getMaxParallelTests()));
        }

        String suiteName = context.getSuite().getName();
        String[] groupsList = context.getIncludedGroups();
        String includedGroupsList = String.join(",", groupsList);

        logger.info("Starting Execution for Test Suite => " + suiteName + " with Tag => " + includedGroupsList);

        // For report generate
        ExtentReportManager.setupExtentReport();
        ExtentReportManager.getReport().setSystemInfo("Suite Name", suiteName);

    }

    @BeforeTest(alwaysRun = true)
    public void setUpTest(ITestContext context){
        String testName = context.getName();
        logger.info("Starting Execution for Test=> "+testName);
        ExtentReportManager.getReport().setSystemInfo("Test Name", testName);
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, ITestContext context){
        configReader = new ConfigReader();

        // Code to solve this error: "com.aventstack.extentreports.ExtentTest.pass(String)"
        String testName = method.getName();
        String className = method.getDeclaringClass().getSimpleName();
        String xmlTestName = context.getName();
        String author = configReader.getAuthorName();
        String groups = (method.getAnnotation(org.testng.annotations.Test.class) != null)
                ? String.join(", ", method.getAnnotation(org.testng.annotations.Test.class).groups())
                : "General";

        ExtentReportManager.createTest(testName, groups, className, xmlTestName, author);

        basePage = new BasePage(getLocalDriver());
        WebDriver driver = basePage.getDriver(configReader.getBrowser());
        logger.info("Opening the browser - " + configReader.getBrowser());
        localDriver.set(driver);
        getLocalDriver().get(configReader.getUrl());

        // Print the session ID, ThreadID
        long threadId = Thread.currentThread().threadId();
        String sessionId = ((RemoteWebDriver)getLocalDriver()).getSessionId().toString();
        System.out.println("Thread ID: " +threadId+ "- Starting Session ID: " + sessionId);

        checkBoxPage = new CheckBoxPage(getLocalDriver());
        homePage = new HomePage(getLocalDriver());
        textBoxPage = new TextBoxPage(getLocalDriver());
        radioButtonPage = new RadioButtonPage(getLocalDriver());
        webTables = new WebTables(getLocalDriver());

        excelReader = new ExcelReader("./src/test/resources/test-data/"+configReader.getFieldsVerificationExcelName());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result){

        totalTests++;

        if (result.getStatus() == ITestResult.FAILURE){
            ExtentReportManager.getTest().fail(result.getThrowable());
            failedTests++;
        } else if (result.getStatus() == ITestResult.SKIP) {
            ExtentReportManager.getTest().skip(result.getThrowable());
            skippedTests++;
        } else {
            ExtentReportManager.getTest().pass("Test Passed");
            passedTests++;
        }

        ExtentReportManager.getTest().log(Status.INFO, "Test Method Execution completed");

        /*getLocalDriver().quit();
        localDriver.remove();
        logger.info("Closing the browser - " + configReader.getBrowser());*/

        if (getLocalDriver() != null) {
            getLocalDriver().quit();
            localDriver.remove();
            logger.info("Closing the browser - " + configReader.getBrowser());
        } else {
            logger.warn("Driver was null, skipping quit()");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void generateReport(){
        double passPercentage = (double) passedTests / (totalTests-skippedTests);
        passPercentage = passPercentage*100;

        ExtentReportManager.createCustomTable(
                String.valueOf(totalTests-skippedTests),
                String.valueOf(passedTests),
                String.valueOf(failedTests),
                String.valueOf(skippedTests),
                String.format("%.2f",passPercentage),
                configReader.getBrowser(),
                configReader.getUrl());
        // Generate and add the custom table before flushing the report

        ExtentReportManager.flushReport();
    }

}
