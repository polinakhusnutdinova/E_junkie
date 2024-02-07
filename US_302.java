import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class US_302 {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://shopdemo.e-junkie.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void testEJunkie() throws InterruptedException {
        // Find and click the "Add Demo E-Book to Cart" button using XPath
        WebElement addToCartButton = driver.findElement(By.xpath("//div[2]//a[1]//div[1]//div[2]//button[1]"));
        addToCartButton.click();

        WebElement iFrameElement=driver.findElement(By.xpath("(//iframe[@class='EJIframeV3 EJOverlayV3'])[1]"));
        driver.switchTo().frame(iFrameElement);
        Thread.sleep(2000);

        // Wait for the cart to open and the Pay with debit card button to become clickable
        WebElement payByDebitCard = driver.findElement(By.xpath("//*[@class='Payment-Button CC']"));
        payByDebitCard.click();


        // Attempt to pay with blank information
        WebElement payButton = driver.findElement(By.xpath("//button[text()='Pay 0.50 USD']"));
        payButton.click();


        // Check for error messages using XPath
          WebElement emailError = driver.findElement(By.id("SnackBar"));

        Assert.assertTrue(emailError.isDisplayed());
        }



    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
//lll
