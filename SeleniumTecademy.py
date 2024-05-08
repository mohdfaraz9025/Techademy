
import pytest
from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


@pytest.fixture(scope="module")
def browser():
    # Initialize Chrome WebDriver
    driver = webdriver.Chrome()
    driver.maximize_window()
    yield driver
    # Teardown - close the browser after the test
    driver.quit()


def test_navigation(browser):
    # Open the website
    browser.get("https://www.automationanywhere.com/")

    browser.find_element(By.ID, "onetrust-accept-btn-handler").click()

    # Perform mouse over on Products
    products_menu = WebDriverWait(browser, 10).until(
        EC.visibility_of_element_located((By.XPATH, "//a[text()='Products']")))
    ActionChains(browser).move_to_element(products_menu).perform()

    # Click on Process Discovery
    process_discovery_link = WebDriverWait(browser, 10).until(
        EC.visibility_of_element_located((By.XPATH, "//a[text()='Process Discovery']")))
    process_discovery_link.click()

    # Wait for the page to load
    WebDriverWait(browser, 10).until(EC.url_to_be("https://www.automationanywhere.com/products/process-discovery"))

    # Verify the URL
    assert browser.current_url == "https://www.automationanywhere.com/products/process-discovery"
