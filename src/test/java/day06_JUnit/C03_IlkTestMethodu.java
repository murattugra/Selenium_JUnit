package day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_IlkTestMethodu {

    WebDriver driver;// WebDriveri class seviyede olusturarak butun metotlarin gosmesini saglariz

    @Test
    public void test01(){
        // amazon.com gidelim ve title nin "amazon" icerdigini test edelim
        driver.get("https://www.amazon.com");
        String actualTitle=driver.getTitle();
        String arananKelime="amazon";
        if (actualTitle.contains(actualTitle)){
            System.out.println("amazon testi PASSED");
        }else {
            System.out.println("amazon testi FAILED");
        }


    }

    @Test
    public void test02(){
        // google ye gidelim ve basligin google oldugunu test edelim
        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //3- cookies uyarisini kabul ederek kapatin

        driver.findElement(By.xpath("//div[text()='Ich stimme zu']")).click();
        String actualTitle=driver.getTitle();
        String arananKelime="google";
        if (actualTitle.contains(actualTitle)){
            System.out.println("google testi PASSED");
        }else {
            System.out.println("google testi FAILED");
        }

    }
        @Before
        public void ayarlariDuzenle(){
            WebDriverManager.chromedriver().setup();
          driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



        }

        @After
    public void ortaligiTopla(){

    driver.close();

        }


}
