import Utilities.TestBase;
import Utilities.ReusableMethods;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class US_305 extends TestBase {

    JavascriptExecutor jsExecutor=(JavascriptExecutor) driver;

    /*
US_305
	 Payment process,
	  approval and download
1. Acceptance criteria in us_304 should be provided.
2. Payment process ""Your Order is Confirmed. Tank You!"" When completed with the message,
verify that the total amount is the same as the price of the e-book (0.50 USD).
3. Click the ""Download"" button to download the e-book to the computer.
"	"- The same is the same as the prerequisites and acceptance criteria in us_304.
"	Middle
     */


    @Before
    public void setUP(){
        //Navigate to the URL
        driver.get("https://shopdemo.e-junkie.com/");
    }
    @Test
    public void PaymentProcess(){

        //3rd Step  Click Download Button
        WebElement DownloadButton = driver.findElement(By.xpath("//div[@class='column all_tag']//a[normalize-space()='File Downloads']"));
        DownloadButton.click();

    }

}
