import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class US_307 {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://shopdemo.e-junkie.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void testNavigateToEJunkieHomepage() throws InterruptedException {

        // Scroll to the "E-Commerce By E-Junkie" link and click it
        WebElement ecommerceLink = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ecommerceLink);
        Thread.sleep(500);
        ecommerceLink.click();

        // Click on the e-junkie logo
        WebElement eJunkieLogo = driver.findElement(By.xpath("//*[@id=\"top\"]/header/div/div/div[1]/a/img"));
        eJunkieLogo.click();

        // Verify the URL
        String expectedUrl = "https://www.e-junkie.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals("The URL did not match the expected page", expectedUrl, actualUrl);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
//lll