package com.capstone.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {
    private WebDriver driver;
    private By nestedFramesLink = By.linkText("Nested Frames");
    private By iFrameLink = By.linkText("iFrame");

    public FramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isNestedFramesLinkDisplayed() {
        return driver.findElement(nestedFramesLink).isDisplayed();
    }

    public boolean isiFrameLinkDisplayed() {
        return driver.findElement(iFrameLink).isDisplayed();
    }
}
