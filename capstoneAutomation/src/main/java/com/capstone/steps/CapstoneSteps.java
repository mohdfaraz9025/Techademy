package com.capstone.steps;

import com.capstone.base.BaseTest;
import com.capstone.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class CapstoneSteps extends BaseTest {
    private HomePage homePage;
    private ABTestingPage abTestingPage;
    private DropdownPage dropdownPage;
    private FramesPage framesPage;

    @Before
    public void setUpScenario() {
        setUp();
    }

    @After
    public void tearDownScenario() {
        tearDown();
    }

    @Given("I navigate to {string}")
    public void iNavigateTo(String url) {
        driver.get(url);
        homePage = new HomePage(driver);
    }

    @Then("I verify the title of the page as {string}")
    public void iVerifyTheTitleOfThePageAs(String expectedTitle) throws Exception{
    	Thread.sleep(5);
        String actualTitle = homePage.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @When("I click on A/B Testing link$")
    public void iClickOnABTestingLink() {
        homePage.clickABTesting();
        abTestingPage = new ABTestingPage(driver);
    }

    @Then("I verify the text on the page as {string}")
    public void iVerifyTheTextOnThePageAs(String expectedText)throws Exception {
    	Thread.sleep(5);
        String actualText = abTestingPage.getABTestText();
        Assert.assertTrue(actualText.contains(expectedText));
    }

    @When("I navigate back to the Home page")
    public void iNavigateBackToTheHomePage() {
        driver.navigate().back();
    }

    @And("I click on the Dropdown link")
    public void iClickOnTheDropdownLink() {
        homePage.clickDropdown();
        dropdownPage = new DropdownPage(driver);
    }

    @And("I select Option1 from dropdown")
    public void iSelectOption1FromDropdown() {
        dropdownPage.selectOption1();
    }

    @Then("I confirm Option1 is selected")
    public void iConfirmOption1IsSelected() {
        Assert.assertTrue(dropdownPage.isOption1Selected());
    }

    @And("I click on Frames link")
    public void iClickOnFramesLink() {
        homePage.clickFrames();
        framesPage = new FramesPage(driver);
    }

    @Then("I verify Nested Frames link is displayed")
    public void iVerifyNestedFramesLinkIsDisplayed() {
        Assert.assertTrue(framesPage.isNestedFramesLinkDisplayed());
    }

    @Then("I verify iFrame link is displayed")
    public void iVerifyiFrameLinkIsDisplayed() {
        Assert.assertTrue(framesPage.isiFrameLinkDisplayed());
    }
}
