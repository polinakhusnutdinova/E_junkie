package Project.Utilitis.ShopDemo;

import Project.Utilitis.ReusableMethods;
import Project.Utilitis.TestBase;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Demo extends TestBase {
    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver; // casting

    @Before
    public void setUp() {
        driver.get("https://shopdemo.e-junkie.com/");

    }

    @Test
    public void demoEbookButton() {
        WebElement demoEbookButton =
                driver.findElement(By.xpath("(//button[@class='view_product'][normalize-space()='Add To Cart'])[2]"));
        demoEbookButton.click();
        ReusableMethods.myWait(2);

        WebElement iFrameElement=driver.findElement(By.xpath("(//iframe[@class='EJIframeV3 EJOverlayV3'])[1]"));
        driver.switchTo().frame(iFrameElement);
        ReusableMethods.myWait(2);
              WebElement clickAddPromoCode = driver.findElement(By.cssSelector(".Actions>button[class='Apply-Button Show-Promo-Code-Button']"));
        clickAddPromoCode.click();

        WebElement addPromoCodeNumber = driver.findElement(By.xpath("//input[@class='Promo-Code-Value']"));
        addPromoCodeNumber.click();
        ReusableMethods.myWait(2);
        addPromoCodeNumber.sendKeys("1478998563214");

        WebElement applyButtonClick = driver.findElement(By.xpath("//button[@class='Promo-Apply']"));
        applyButtonClick.click();



    }
}
