package techacadmy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class BrowserAutomation {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Faraz\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
              
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        driver.get("https://www.automationanywhere.com/");
        
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        WebElement productsMenu = driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        actions.moveToElement(productsMenu).build().perform();
        Thread.sleep(3000);

        WebElement processDiscoveryLink = driver.findElement(By.xpath(" //a[text()='Process Discovery']"));
        processDiscoveryLink.click();

        // Verify the URL
        Thread.sleep(5000); 
        String currentUrl = driver.getCurrentUrl();
        if ("https://www.automationanywhere.com/products/process-discovery".equals(currentUrl)) {
            System.out.println("Navigation to Process Discovery page is successful.");
        } else {
            System.out.println("Navigation failed. Current URL: " + currentUrl);
        }
        driver.close();

    }
}