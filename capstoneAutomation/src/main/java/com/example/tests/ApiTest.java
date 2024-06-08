package com.example.tests;

import com.example.utils.ExcelUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class ApiTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://restcountries.com/v3.1/translation";
    }

    @DataProvider(name = "translations")
    public Object[][] getTranslations() throws IOException {
        String filePath = "src/test/resources/translations.xlsx";
        String sheetName = "Sheet1";
        List<String> translations = ExcelUtils.readExcelData(filePath, sheetName);
        Object[][] data = new Object[translations.size()][1];

        for (int i = 0; i < translations.size(); i++) {
            data[i][0] = translations.get(i);
        }

        return data;
    }

    @Test(dataProvider = "translations")
    public void testGetTranslation(String translation) {
        Response response = RestAssured.get("/" + translation);
        response.then().statusCode(200);

        // Optionally, add assertions for specific fields in the response
        // For example:
        // String countryName = response.jsonPath().getString("name.common");
        // Assert.assertEquals(countryName, "Germany");

        Assert.assertTrue(response.asString().contains("translations"));
    }
}
