package day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.Duration;

public class C02_AramaTesti {










    //9. Sayfayi kapatin

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1. “https://www.saucedemo.com” Adresine gidin

        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna “standard_user” yazdirin

        WebElement userNameElementi=driver.findElement(By.id("user-name"));

        userNameElementi.sendKeys("standard_user");

        //3. Password kutusuna “secret_sauce” yazdirin

        WebElement passwordBox=driver.findElement(By.xpath("//input[@id='password']"));

        passwordBox.sendKeys("secret_sauce");

        //4. Login tusuna basin

        driver.findElement(By.id("login-button")).click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin

        WebElement ilkUrunElementi=driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack'][1]"));

        String  actualIlkUrunIsmi= ilkUrunElementi.getText();

        ilkUrunElementi.click();

        //6. Add to Cart butonuna basin

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        //7. Alisveris sepetine tiklayin

        driver.findElement(By.className("shopping_cart_link")).click();


        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin

        WebElement sepekUrun=driver.findElement(By.className("inventory_item_name"));
        String SEPETuRUNtEXT=sepekUrun.getText();

        if (actualIlkUrunIsmi.equals(SEPETuRUNtEXT)){
            System.out.println("Sepet test PASS");
        }else {
            System.out.println("Sepet Test FAILED");
        }

            driver.close();

    }


}
