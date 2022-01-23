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
import java.util.List;

public class C04_treeSlidersTest {


     // 1) Open the browser
    //2) Enter the URL “http://practice.automationtesting.in/”
    //3) Click on Shop Menu
    //4) Now click on Home menu button
    //5) Test whether the Home page has Three Sliders only
    //6) The Home page must contains only three sliders

    // 1) Tarayıcıyı açın
    //2) “http://practice.automationtesting.in/” URL'sini girin
    //3) Mağaza Menüsüne tıklayın

    //6) Ana sayfa yalnızca üç kaydırıcı içermelidir


    static WebDriver driver;
    @BeforeClass
    public  static void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://practice.automationtesting.in");



    }
    //3) Mağaza Menüsüne tıklayın
    //4) Şimdi Ana menü düğmesine tıklayın
    @Test
    public  void shopundHomeMenuTest(){
        driver.findElement(By.xpath("//a[text()='Shop']")).click();
        driver.findElement(By.xpath("//a[text()='Home']")).click();

    }





    //5) Ana sayfada yalnızca Üç Kaydırıcı olup olmadığını test edin
    @Test
    public  void threeSlidersTest() throws InterruptedException {

        List<WebElement> slidersList=driver.findElements(By.xpath("//img[@class='n2-ss-slide-background-image n2-ss-slide-fill n2-ow']"));
        int slidersListElemanlariSayisi=slidersList.size();
        Thread.sleep(3000);
        Assert.assertTrue(slidersListElemanlariSayisi==3);


    }




    @AfterClass
    public  static void  treaddown(){
    driver.close();

    }


}
