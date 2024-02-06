import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;


public class US_304 extends TestBase {

    JavascriptExecutor jsExecutor=(JavascriptExecutor) driver;
    @Before
    public void setUp() {
        driver.get("https://shopdemo.e-junkie.com/");
    }
    @Test
    public void paymentProcess() throws AWTException {

        WebElement addToChart= driver.findElement(By.xpath("(//button[@class='view_product'][normalize-space()='Add To Cart'])[1]"));
        addToChart.click();
        ReusableMethods.myWait(2);

        WebElement iFrameElement=driver.findElement(By.xpath("(//iframe[@class='EJIframeV3 EJOverlayV3'])[1]"));
        driver.switchTo().frame(iFrameElement);
        ReusableMethods.myWait(2);

        WebElement DebitCart=driver.findElement(By.xpath("//button[@class='Payment-Button CC']"));
        ReusableMethods.myWait(2);
        DebitCart.click();

    }
}
