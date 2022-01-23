package ZZZKendiCalismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_EmailTesti {



    // 1. Bir Class olusturalim EmailTesti
    //2. http://www.gmail.com sayfasina gidelim
    //3. Email kutusuna emailinizi giriniz
    //4.Cikan Sayfada isim ve soy ismininiz oldugunu kontrol ediniz
    //5. sifrenizi password kutusuna girip ve giris yapiniz
    //6.Cikan syfada "Prufe dein Smartphone' yazisinin gorunur oldugunu test ediniz
    //7. Sayfayi kapatin

   static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
       driver= new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       driver.get(" http://www.gmail.com");



    }

    @Test
    public void emailGirisTest() throws InterruptedException {

        WebElement emailBox=driver.findElement(By.xpath("//input[@type='email']"));
        emailBox.sendKeys("mrterkmglsv@gmail.com");
       driver.findElement(By.xpath("//span[text()='Weiter']")).click();
         driver.findElement(By.xpath("//span[text()='Erneut versuchen']")).click();
     driver.findElement(By.xpath("//a[text()='Anmelden']")).click();
          WebElement email2Box=driver.findElement(By.xpath("//input[@id='identifierId']"));
        email2Box.sendKeys("mrterkmglsv@gmail.com"+Keys.ENTER);

    }

    @Test
    public void emailTesti(){

    }



    @AfterClass
    public static void treaddown(){


    }


}
