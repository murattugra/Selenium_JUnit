package day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class C01_TekrarTesti {
   // 1-C01_TekrarTesti isimli bir class olusturun
   //2- https://www.google.com/ adresine gidin
   //3- cookies uyarisini kabul ederek kapatin
   //4-Sayfa basliginin “Google” ifadesi icerdigini test edin
   //5- Arama cubuguna “Nutella” yazip aratin
   //6-Bulunan sonuc sayisini yazdirin
   //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
   //8-Sayfayi kapatin

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //3- cookies uyarisini kabul ederek kapatin

        driver.findElement(By.xpath("//div[text()='Ich stimme zu']")).click();

        //4-Sayfa basliginin “Google” ifadesi icerdigini test edin

        String actualSayfaTitle= driver.getTitle();
        String arananKelime="Google";

        if (actualSayfaTitle.contains(arananKelime)){
            System.out.println("Title Testi PASS");
        }else{
            System.out.println("TiTle testi FAILED");
        }

                //5- Arama cubuguna “Nutella” yazip aratin

            WebElement aramaBox=driver.findElement(By.xpath("//input[@name='q']"));
        aramaBox.sendKeys("Nutella"+ Keys.ENTER);

        //6-Bulunan sonuc sayisini yazdirin

        WebElement sonucSayisiElementi=driver.findElement(By.xpath("//div[@id='result-stats']"));


        System.out.println(sonucSayisiElementi.getText());

        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin

        String actualSonucSayisi=sonucSayisiElementi.getText();
        String sonucKelimeleri[]=actualSonucSayisi.split(" ");

        String sonucNutellaSayisiString=sonucKelimeleri[1];//  73.900.000 bize unu verir

        sonucNutellaSayisiString= sonucNutellaSayisiString.replace(".","");

        System.out.println(sonucNutellaSayisiString);

        int nutellaSayisiInt=Integer.parseInt(sonucNutellaSayisiString);

            if (nutellaSayisiInt>10000000){
                System.out.println("Nutella Arama Testi PASSED");
            }else{
                System.out.println("Nutella Arama Testi FAILED");
            }

        driver.close();

    }




}
