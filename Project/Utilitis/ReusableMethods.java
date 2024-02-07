package Project.Utilitis;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {
    public static void myWait(int sec){
        try{
            Thread.sleep(sec * 1000);
        }catch (InterruptedException e){
            throw new RuntimeException();
        }
    }


}
