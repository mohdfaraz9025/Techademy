package com.capstone.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ABTestingPage {
    private WebDriver driver;
    private By abTestText = By.tagName("h3");

    public ABTestingPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getABTestText() {
        return driver.findElement(abTestText).getText();
    }
}
