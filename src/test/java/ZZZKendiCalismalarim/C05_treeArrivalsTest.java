package ZZZKendiCalismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_treeArrivalsTest {

 // 1) Open the browser
    //2) Enter the URL “http://practice.automationtesting.in/”
    //3) Click on Shop Menu
    //4) Now click on Home menu button
    //5) Test whether the Home page has Three Arrivals only
   //6) The Home page must contains only three Arrivals
    //7) Now click the image in the Arrivals
    //8) Test whether it is navigating to next page where the user can add that book into his basket.
    //9) Image should be clickable and shoul navigate to next page where user can add that book to his basket

    // 1) Tarayıcıyı açın
    //2) “http://practice.automationtesting.in/” URL'sini girin
    //3) Mağaza Menüsüne tıklayın
    //4) Şimdi Ana menü düğmesine tıklayın
    //5) Ana sayfada yalnızca Üç Varış olup olmadığını test edin
    //6) Ana sayfada yalnızca üç Varış yer almalıdır
    //7) Şimdi Gelenler bölümündeki resme tıklayın
    //8) Kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gidip gitmediğini test edin.
    //9) Resim tıklanabilir olmalı ve kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gitmelidir.

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://practice.automationtesting.in");


    }





    @Test
    public  void shopAndHomeMenuTest(){
        driver.findElement(By.xpath("//a[text()='Shop']")).click();
        driver.findElement(By.xpath("//a[text()='Home']")).click();
    }

    @Test
    public  void threeArrivalsTest(){
        List<WebElement> arrivalsListe=driver.findElements(By.xpath("//a[@class='woocommerce-LoopProduct-link']"));
        int actualArrivalsCount=arrivalsListe.size();
        int expectedResult=3;

        Assert.assertTrue(expectedResult==actualArrivalsCount);

    }

    //7) Şimdi Gelenler bölümündeki resme tıklayın
    //8) Kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gidip gitmediğini test edin.
    //9) Resim tıklanabilir olmalı ve kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gitmelidir.

    @Test
    public void basketTest(){
        driver.findElement(By.xpath("(//img[@class='attachment-shop_catalog size-shop_catalog wp-post-image'])[2]")).click();
        driver.findElement(By.xpath("//button[text()='Add to basket']")).click();
        WebElement wiev=driver.findElement(By.xpath("//div[@class='woocommerce-message']"));

        Assert.assertTrue(wiev.isDisplayed());
        // 10) O kitabı sepetinize ekleyen Sepete Ekle düğmesine tıklayın.
        driver.findElement(By.xpath("//a[text()='View Basket']")).click();
        //11) Kullanıcı o Kitabı Menü öğesinde fiyatla görüntüleyebilir.
        WebElement kitapIsim=driver.findElement(By.xpath("//td[@class='product-name']"));
        Assert.assertTrue(kitapIsim.isDisplayed());
        WebElement kitapFiyat=driver.findElement(By.xpath("(//span[@class='woocommerce-Price-amount amount'])[1]"));
        Assert.assertTrue(kitapFiyat.isDisplayed());
        //12) Kullanıcı, o kitabı Sepetine ekleyen Sepete Ekle düğmesine tıklayarak bir kitap ekleyebilir.




    }



    //12) Kullanıcı, o kitabı Sepetine ekleyen Sepete Ekle düğmesine tıklayarak bir kitap ekleyebilir.
    //13) Stoktaki kitaplardan daha fazla kitap seçin.Örneğin stokta 20 kitap varsa 21 eklemeyi deneyin.
    //14) Sepete ekle butonuna tıklayın
    //15) Şimdi 1 ile 20 arasında bir değer girmeniz gerekiyormuş gibi bir hata mesajı veriyor.




    @AfterClass
    public static void treadown(){
        //driver.close();

    }


}
