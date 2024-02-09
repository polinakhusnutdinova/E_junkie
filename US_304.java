import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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
        Actions actions = new Actions(driver);

        //add to chart click
        WebElement addToChart= driver.findElement(By.xpath("(//button[@class='view_product'][normalize-space()='Add To Cart'])[1]"));
        addToChart.click();
        ReusableMethods.myWait(2);

        //click debit cart using Iframe
        WebElement iFrameElement=driver.findElement(By.xpath("(//iframe[@class='EJIframeV3 EJOverlayV3'])[1]"));
        driver.switchTo().frame(iFrameElement);
        ReusableMethods.myWait(2);

        //click on the debit cart
        WebElement DebitCart=driver.findElement(By.xpath("//button[@class='Payment-Button CC']"));
        ReusableMethods.myWait(2);
        DebitCart.click();

        //click to zip code and write zip code your location
        WebElement zipCode=driver.findElement(By.xpath("(//input[@type='text'])[3]"));
        ReusableMethods.myWait(5);
        zipCode.click();
        zipCode.sendKeys("10000");

        //click on the debit cart
        WebElement DebitCart2=driver.findElement(By.xpath("//button[@class='Payment-Button CC']"));
        actions.moveToElement(DebitCart2).click(DebitCart2).build().perform();
        ReusableMethods.myWait(2);

        //click on again the debit cart
        WebElement DebitCart3=driver.findElement(By.xpath("//button[@class='Payment-Button CC']"));
        actions.moveToElement(DebitCart3).click(DebitCart3).build().perform();

        //write email adress
        WebElement writeEmail=driver.findElement(By.xpath("//input[@placeholder='Email']"));
        writeEmail.sendKeys("gokcehamza2934@gmail.com");

        WebElement confirmEmail=driver.findElement(By.xpath("//input[@placeholder='Confirm Email']"));
        confirmEmail.sendKeys("gokcehamza2934@gmail.com");

        WebElement CardName=driver.findElement(By.xpath("//input[@placeholder='Name On Card']"));
        CardName.sendKeys("Hamza Gökçe");

        WebElement phoneNumber=driver.findElement(By.xpath("//input[@placeholder='Optional']"));
        phoneNumber.sendKeys("5558847578");

        WebElement company=driver.findElement(By.xpath("(//input[@type='text'])[3]"));
        company.sendKeys("A' company");

        WebElement adress1=driver.findElement(By.xpath("(//input[@placeholder='Address Line 1'])[2]"));
        adress1.sendKeys("İstanbul TURKEY");


        WebElement adress2=driver.findElement(By.xpath("(//input[@autocomplete='address-2'])[2]"));
        adress2.sendKeys("İstanbul TURKEY");


        WebElement state=driver.findElement(By.xpath("(//input[@autocomplete='state'])[2]"));
        state.sendKeys("marmara");


        WebElement textArea=driver.findElement(By.xpath(" (//textarea[@type='text'])[1]"));
        textArea.sendKeys("Thank you so much....");
        

        WebElement cardNumber=driver.findElement(By.xpath("//input[@aria-label='Credit or debit card number']"));
        cardNumber.sendKeys("4242 4242 4242 4242");

        WebElement cardDate=driver.findElement(By.xpath("(//input[@class='InputElement is-empty Input Input--empty'])[2]"));
        cardDate.sendKeys("12/2024");

        WebElement cvvNumber=driver.findElement(By.xpath("(//input[@class='InputElement is-empty Input Input--empty'])[3]"));
        cvvNumber.sendKeys("000");

        WebElement payButton=driver.findElement(By.xpath("//button[@class='Pay-Button']"));
        payButton.click();







    }
}
