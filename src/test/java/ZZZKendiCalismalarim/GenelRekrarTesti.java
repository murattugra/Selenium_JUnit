package ZZZKendiCalismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GenelRekrarTesti {

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }
    @Test
    public void test01(){
        // https://www.amazon.com.tr sitesine gidelim
driver.get("https://www.amazon.com");
        // Ana sayfanın açıldıgı kontrol edin
        boolean sayfaTesti=driver.getTitle().contains("Amazon.com");
        Assert.assertTrue(sayfaTesti);
        // String expectedTitle="Amazon";
        // çerez tercihlerinden Çerezleri kabul et seçilir
        // siteye login olun

        driver.findElement(By.xpath("//a[@data-csa-c-content-id='nav_ya_signin']")).click();
        WebElement emailBox=driver.findElement(By.xpath("//input[@tabindex='1']"));
        emailBox.sendKeys("sgsdgsdg");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        actions.sendKeys("gsdgdsgsdg").sendKeys(Keys.ENTER).perform();
        // login işlemi kontrol edin
        WebElement muratElement=driver.findElement(By.xpath("//span[.='Hello, Murat']"));
        Assert.assertTrue(muratElement.isDisplayed());
        //arama butonunun yanındaki kategörüler tabından bilgisayar secilir

       WebElement kategoriler=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select((WebElement) kategoriler);
        select.selectByVisibleText("Computers");
        // bilgisayar kategorisi seçildigi kontrol edilir
        Assert.assertTrue(driver.findElement(By.xpath("//option[@value='search-alias=computers-intl-ship']")).isDisplayed());
//**********************************SOOOOOOOOOOORRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
        // arama aranına msi yaz ve arama yapın
driver.findElement(By.id("twotabsearchtextbox")).sendKeys("msi"+Keys.ENTER);
        // aramanın yapıldıgını kontrol et
        String aramaSonucYazisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        Assert.assertTrue(aramaSonucYazisi.contains("msi"));
        // arama sonucları sayfasından 2. sayfa açılır
        JavascriptExecutor jse =(JavascriptExecutor)driver;
        WebElement nextButtonButton=driver.findElement(By.xpath("//a[.='Next']"));
        jse.executeScript("arguments[0].scrollIntoView();", nextButtonButton);
      nextButtonButton.click();

        // 2. sayfanın açıldıgı kontrol edilir
        JavascriptExecutor jse1 =(JavascriptExecutor)driver;
        WebElement nextButtonButton1=driver.findElement(By.xpath("//a[.='Next']"));
        jse.executeScript("arguments[0].scrollIntoView();", nextButtonButton1);

        String ikinciSayfaSecimi=driver.findElement(By.xpath("//span[.='2']")).getText();
        String ikinciSayfaSecimiClassLocate=driver.findElement(By.xpath("//span[@class='s-pagination-item s-pagination-selected']")).getText();
        Assert.assertEquals(ikinciSayfaSecimi,ikinciSayfaSecimiClassLocate);

        //sayfadaki 2. ürün favorilere eklenir
        driver.findElement(By.xpath("(//img[@class='s-image'])[2]")).click();
        driver.findElement(By.id("add-to-cart-button")).click();
        // 2. ürünün favorilere eklendigi kontrol edilir

        // hesabım->  favori listem sayfasına gidilir
        // favori Listem sayfası açıldıgı kontrol edilir
        // eklenen ürün favorilerden silinir
        // silme işleminin gerçekleştigi kontrol edilir.
        // üye çıkış işlemi yapılır
        //çıkış işleminin yapıldıgı kontrol edilir.

    }

}
