package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_YoutubeAssertions {

    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin

    static WebDriver driver;

    @BeforeClass
  public static void setup(){

      WebDriverManager.chromedriver().setup();
      driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      driver.get(" https://www.youtube.com");
      driver.findElement(By.xpath("//yt-formatted-string[text()='I Agree']")).click();

  }
    @Test
    public void titleTesti(){
        //    ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
        String actualTitle= driver.getTitle();
        String expectedTitle="YouTube";
        Assert.assertEquals("Sayfa basligi YouTube degildir",expectedTitle,actualTitle);
                            // genelde negatif testlerde yorum birakilir
    }


    @Test
    public void imageTest(){
        //    ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
      WebElement imageElement= driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[2]"));
      Assert.assertTrue(imageElement.isDisplayed());

}
    @Test
    public void searchBoxTesti(){
        //  ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBoxElement= driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searchBoxElement.isEnabled());

    }


    @Test
    public void wrongTitleTest(){
        //    ○ wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualTitle= driver.getTitle();
        String expectedWrongTitle="youtube";
        Assert.assertFalse(expectedWrongTitle.equals(actualTitle));



    }



@AfterClass
  public static void treaddown(){

      //driver.close();
  }



}
