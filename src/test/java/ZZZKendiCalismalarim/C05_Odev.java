package ZZZKendiCalismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_Odev {



    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void tets(){


     // http://the-internet.herokuapp.com/add_remove_elements/
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

     // "Eleman Ekle" düğmesine 100 kez tıklayın
        WebElement addButton=driver.findElement(By.xpath("//button[.='Add Element']"));
        for (int j = 0; j < 100; j++) {
            addButton.click();
        }
        List<WebElement> ilkEkliListesi=driver.findElements(By.xpath("(//button[.='Delete']"));
        int ilkSayi=ilkEkliListesi.size();
        System.out.println(ilkSayi);
     // sayı alan ve "Sil" düğmesini tıklayan bir fonksiyon yazın
        WebElement deleteButton=driver.findElement(By.xpath("//button[.='Delete']"));

        for (int i=0 ; i<60; i++ ){
            deleteButton.click();
        }
     // verilen sayıda ve ardından verilen sayıyı doğrular
     // butonlar silind
        // 1.yöntem : createButtons(100)
    // 2.deleteButtonsAndValidate()


    }




    @AfterClass
    public static void tearDown(){


    }




}
