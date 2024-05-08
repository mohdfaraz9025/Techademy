package techademy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Implementing {
	
	
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void testProcessDiscoveryNavigation() throws InterruptedException {
        driver.get("https://www.automationanywhere.com/");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        WebElement productsMenu = driver.findElement(By.xpath("//a[normalize-space()='Products']"));
        actions.moveToElement(productsMenu).build().perform();
        WebElement processDiscoveryLink = driver.findElement(By.xpath("//a[normalize-space()='Process Discovery']"));
        processDiscoveryLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.automationanywhere.com/products/process-discovery");
    }

    @Test
    public void testRequestDemoNavigation() throws InterruptedException {
        driver.get("https://www.automationanywhere.com/");
//        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Products')]")).click();
        Thread.sleep(3000);
        
        WebElement requestDemoButton = driver.findElement(By.xpath("//a[contains(text(),'Request Demo')]"));
        requestDemoButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.automationanywhere.com/request-live-demo");
        Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'First Name')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Last Name')]")).isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

	

}
