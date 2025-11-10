package com.demoqa.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomWait {

    private WebDriver driver;
    private WebDriverWait wait;

    public CustomWait(WebDriver driver, Duration timeout){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeout);
    }

    //Wait for an element to be visible
    public void waitForVisibilityOfElement(WebElement element){
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch (TimeoutException e){
            System.err.println("Element is not visible after waiting : " + e.getMessage());
        }
    }

    public void waitForVisibility(By locator) {
        try {
            // Check if element exists first
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            // Then wait for visibility
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            System.err.println("Element located by " + locator + " is not visible after waiting: " + e.getMessage());
        }
    }

    public void waitUntilCondition(ExpectedCondition<?> condition) {
        wait.until(condition);
    }

    //Wait for an element to be clickable
    public void waitForElementToBeClickable(WebElement element){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (TimeoutException e){
            System.err.println("Element is not clickable after waiting : " + e.getMessage());
        }
    }

    // Wait for an element to be visible
    public void waitForInvisibilityOfElement(WebElement element){
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            System.err.println("Element is not visible after waiting : " + e.getMessage());
        }
    }
}
