package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Q6_Odev {



   static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01(){
        // 1. Amazon.com'a gidelim.
// 2. DropDown üzerinde Books secelim.(All yazan yerde)
//    kategorilerin hepsini konsola yazdiralim
// 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
// 4. Sonuc sayisini ekrana yazdiralim.
// 5. Sonucların Les Miserables i icerdigini assert edelim


        driver.get("https://www.amazon.de/");
        driver.findElement(By.id("sp-cc-accept")).click();
       WebElement dopDownElement= driver.findElement(By.id("searchDropdownBox"));
       List<WebElement> dropDownList=driver.findElements(By.id("searchDropdownBox"));
        for (WebElement each : dropDownList
             ) {
            System.out.println(each.getText());
        }

        Select select=new Select(dopDownElement);
        select.selectByValue("search-alias=stripbooks");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Les Miserables"+ Keys.ENTER);

        WebElement sonucYazisiElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        System.out.println(sonucYazisiElementi.getText());

        Assert.assertTrue(sonucYazisiElementi.getText().contains("Les Miserables"));

    }


    @AfterClass
    public static void tearDown(){
     driver.close();

    }




}
