Feature: Capstone Project

  Scenario: Verify functionality of the-internet.herokuapp.com
    Given I navigate to "http://the-internet.herokuapp.com/"
    Then I verify the title of the page as "The Internet"
    When I click on A/B Testing link
    Then I verify the text on the page as "A/B Test Variation 1"
    When I navigate back to the Home page
    And I click on the Dropdown link
    And I select Option1 from dropdown
    Then I confirm Option1 is selected
    When I navigate back to the Home page
    And I click on Frames link
    Then I verify Nested Frames link is displayed
    And I verify iFrame link is displayed
