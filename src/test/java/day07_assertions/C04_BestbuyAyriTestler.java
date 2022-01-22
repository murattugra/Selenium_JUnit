package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BestbuyAyriTestler {

    static WebDriver driver;

    @BeforeClass
    public static void setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin

        driver.get("https://www.bestbuy.com/ ");

    }
    @Test
    public void urlTesti(){


        //		○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.bestbuy.com/";
        Assert.assertEquals(expectedUrl,actualUrl);// ekstra mesaj vermesini istersek ilk siraya yazariz
        //   Assert.assertEquals("Lutfen kontrol et",expectedUrl,actualUrl);
    }
    @Test
    public  void titleTesti(){

        //		○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String actualTitle=driver.getTitle();
        String istemeyenTitle="Rest";
        Assert.assertFalse(actualTitle.contains(istemeyenTitle));
    }

    @Test
    public void logoTesti(){
        //		○ logoTest => BestBuy logosunun görüntülendigini test edin


        WebElement logoElementi=driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue("Logo gorunmuyor",logoElementi.isDisplayed());
        //****** logo gorunmuyor mesaji eger test FAILED olunca yazacak yoksa true donunce yazmayacak

    }
    @Test
    public void francisTesti(){

        //		○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

        WebElement francais=driver.findElement(By.xpath("//button[text()='Français']"));

        Assert.assertTrue(francais.isDisplayed());


    }



    public static void treadown(){

     //   driver.close();
    }

}
