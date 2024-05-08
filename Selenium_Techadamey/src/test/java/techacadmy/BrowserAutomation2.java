package techacadmy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class BrowserAutomation2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Faraz\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
              
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        driver.get("https://www.automationanywhere.com/");
        
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
              
        driver.findElement(By.xpath("//a[contains(text(),'Products')]")).click();
        Thread.sleep(3000);
        
        WebElement Demolink = driver.findElement(By.xpath("(//a[contains(text(),'Request Demo')])[1]"));
        Demolink.click();

        // Verify the URL
        Thread.sleep(5000); 
        String currentUrl = driver.getCurrentUrl();
        if ("https://www.automationanywhere.com/request-live-demo".equals(currentUrl)) {
            System.out.println("Navigation to Live-Demo is successful.");
        } else {
            System.out.println("Navigation failed. Current URL: " + currentUrl);
        }
        WebElement Firstname=driver.findElement(By.xpath("//label[contains(text(),'First Name')]"));
        WebElement LastName=driver.findElement(By.xpath("//label[contains(text(),'Last Name')]"));
        
        
        if(Firstname.isDisplayed()&&LastName.isDisplayed()) {
        	
        	System.out.println("FirstName and LastName is displayed.");	
        	
        }
        else
        {
        	System.out.println("FirstName and LastName is not displayed.");	
        }
    
    driver.close();
    }
    
    
}