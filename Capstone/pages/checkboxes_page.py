from selenium.webdriver.common.by import By

class CheckboxesPage:
    def __init__(self, driver):
        self.driver = driver

    def get_header_text(self):
        return self.driver.find_element(By.TAG_NAME, "h3").text

    def is_checkbox1_checked(self):
        return self.driver.find_element(By.XPATH, "//form[@id='checkboxes']/input[1]").is_selected()

    def is_checkbox2_checked(self):
        return self.driver.find_element(By.XPATH, "//form[@id='checkboxes']/input[2]").is_selected()
