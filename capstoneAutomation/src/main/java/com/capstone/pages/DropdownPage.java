package com.capstone.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropdownPage {
    private WebDriver driver;
    private By dropdown = By.id("dropdown");
    private By option1 = By.xpath("//option[@value='1']");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectOption1() {
        WebElement dropdownElement = driver.findElement(dropdown);
        dropdownElement.click();
        dropdownElement.findElement(option1).click();
    }

    public boolean isOption1Selected() {
        return driver.findElement(option1).isSelected();
    }
}
