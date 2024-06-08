package com.capstone.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By abTestingLink = By.linkText("A/B Testing");
    private By dropdownLink = By.linkText("Dropdown");
    private By framesLink = By.linkText("Frames");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickABTesting() {
        driver.findElement(abTestingLink).click();
    }

    public void clickDropdown() {
        driver.findElement(dropdownLink).click();
    }

    public void clickFrames() {
        driver.findElement(framesLink).click();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
