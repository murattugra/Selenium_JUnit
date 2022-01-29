package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class Q7 {

    WebDriver driver;

    @Before
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @Test

    public void test(){
        // 1) "https://www.facebook.com/" SAYFASINA GiDiN
        driver.get("https://www.facebook.com/");
        // 2) YENi HESAP OLUSTUR BUTONUNA TIKLAYIN

        driver.findElement(By.xpath("//button[.='Allow All Cookies']")).click();
        driver.findElement(By.xpath("//a[.='Create new account']")).click();
       // 3) DOGUM TARiHi BOLUMUNDEKi GUNLERiN LiSTESiNi ALIN

        List<WebElement> gunlerListesi=driver.findElements(By.xpath("//select[@id='day']"));

       // 4) DOGUM TARiHi BOLUMUNDEKi AYLARIN LiSTESiNi ALIN
        List<WebElement> aylarListesi=driver.findElements(By.xpath("//select[@id='month']"));
       // 5) DOGUM TARiHi BOLUMUNDEKi YILLARIN LiSTESiNi ALIN
        List<WebElement> yillarListesi=driver.findElements(By.xpath("//select[@id='year']"));


    }


    @After
    public void tearDown(){


    }


}
