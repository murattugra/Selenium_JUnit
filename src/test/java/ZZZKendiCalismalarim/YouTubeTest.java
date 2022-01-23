package ZZZKendiCalismalarim;

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

public class YouTubeTest {

  // 1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

   static WebDriver driver;
    static String actualTitle;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com ");
        driver.findElement(By.xpath("//yt-formatted-string[text()='I Agree']")).click();
    }

    //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    @Test
    public void titleTest(){
       actualTitle=driver.getTitle();
        String expectedTitle="YouTube";
        Assert.assertEquals(expectedTitle,actualTitle);

    }
    //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    @Test
    public void imageTest(){
     WebElement imageElement=driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[2]"));
     Assert.assertTrue(imageElement.isDisplayed());

    }
    //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    @Test
    public void seachBoxTest(){
    WebElement seachElememnt= driver.findElement(By.xpath("//input[@id='search']"));
    Assert.assertTrue(seachElememnt.isEnabled());

    }
    //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    @Test
    public void wrongTitleTest(){
        String unexpectedResult="youtube";
    Assert.assertFalse(actualTitle.equals(unexpectedResult));



    }

    @AfterClass
    public  static void treaddown(){

    driver.close();


    }
}
