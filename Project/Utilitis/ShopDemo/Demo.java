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


        Actions actions = new Actions(driver);
        WebElement addToCardButton = driver.findElement(By.xpath("//button[text()='Add Promo Code']"));
        ReusableMethods.myWait(2);
        addToCardButton.click();
        actions.contextClick(addToCardButton).build().perform();
        //        WebElement addToCardButton = driver.findElement(By.cssSelector(".Actions>button[class='Apply-Button Show-Promo-Code-Button']"));


//
//        WebElement addPromoCodeNumber1 = driver.findElement(By.xpath("//*[@id=\"Overlay\"]/div/div[2]/div/div[1]/div[4]/button[2]"));
//        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", addPromoCodeNumber1);
//        ReusableMethods.myWait(2);
//        jsExecutor.executeScript("arguments[0].click();", addPromoCodeNumber1);
//        addPromoCodeNumber1.clear();
//        addPromoCodeNumber1.sendKeys("123589647");


    }
}
