package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BestbuyAssertion {


    // 1) Bir class oluşturun: BestBuyAssertions


    WebDriver driver;
    @Before
    public void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



    }

    @Test
    public  void test01(){
        //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin

        driver.get("https://www.bestbuy.com/ ");

        //		○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
       String actualUrl=driver.getCurrentUrl();
       String expectedUrl="https://www.bestbuy.com/";
        Assert.assertEquals(expectedUrl,actualUrl);// ekstra mesaj vermesini istersek ilk siraya yazariz
                                                                                //   Assert.assertEquals("Lutfen kontrol et",expectedUrl,actualUrl);
        //		○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String actualTitle=driver.getTitle();
        String istemeyenTitle="Rest";
        Assert.assertFalse(actualTitle.contains(istemeyenTitle));

        //		○ logoTest => BestBuy logosunun görüntülendigini test edin


        WebElement logoElementi=driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue("Logo gorunmuyor",logoElementi.isDisplayed());
    //****** logo gorunmuyor mesaji eger test FAILED olunca yazacak yoksa true donunce yazmayacak

        //		○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

        WebElement francais=driver.findElement(By.xpath("//button[text()='Français']"));

        Assert.assertTrue(francais.isDisplayed());




    }










    @After
    public void teardown(){
      //  driver.close();




    }








}
