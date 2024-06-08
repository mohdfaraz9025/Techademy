from Capstone.conftest import setup
from Capstone.pages.home_page import HomePage
from Capstone.pages.checkboxes_page import CheckboxesPage
from Capstone.pages.file_upload_page import FileUploadPage


def test_capstone_project(setup):
    driver = setup

    # Step 1: Launch URL and verify title
    driver.get("http://the-internet.herokuapp.com/")
    home_page = HomePage(driver)

    assert home_page.get_title() == "The Internet"

    # Step 2: Click on Checkboxes link and verify text
    home_page.click_checkboxes()
    checkboxes_page = CheckboxesPage(driver)
    assert checkboxes_page.get_header_text() == "Checkboxes"

    # Verify checkbox 1 is not checked and checkbox 2 is checked
    assert not checkboxes_page.is_checkbox1_checked(), "Checkbox 1 should not be checked"
    assert checkboxes_page.is_checkbox2_checked(), "Checkbox 2 should be checked"

    # Step 3: Navigate back to Home page and click on File Upload link
    driver.back()

    home_page.click_file_upload()

    # Step 4: Verify text on File Upload page and upload a file
    file_upload_page = FileUploadPage(driver)
    assert file_upload_page.get_header_text() == "File Uploader"

    file_path = "C:\\Users\\Faraz\\PycharmProjects\\Techademy\\Capstone\\tests\\test_capstone.py"
    file_upload_page.choose_file(file_path)
    file_upload_page.click_upload_button()
