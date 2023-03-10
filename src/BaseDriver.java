import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
    //    //org.testng:testng:6.14.
//    org.seleniumhq.selenium:selenium-java:4.8.1
    public static WebDriver driver;

    @BeforeClass
    public void BalangicIslemleri() {
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.get("https://shopdemo.e-junkie.com/");

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @AfterTest
    public void TestSonrasi(){
//        driver.manage().deleteAllCookies();
        driver.get("https://shopdemo.e-junkie.com/");
        System.out.println("TestSonrasi Çalıştı");
    }



    @AfterClass
    public void bitisIslemleri() {
        Tools.Bekle(5);
        driver.quit();
    }

    public void AddtoCardClick() {
        driver.get("https://shopdemo.e-junkie.com/");
        WebElement ebook = driver.findElement(By.xpath("(//div[@class='column all_tag']/a)[2]"));
        ebook.click();
        WebElement addtocard = driver.findElement(By.xpath("//div[@class='basicDetails']/button"));
        addtocard.click();

        Tools.Bekle(1);
    }

    public void UsingDebitClick() {
//    WebElement ebook = driver.findElement(By.xpath("(//div[@class='column all_tag']/a)[2]"));
//    ebook.click();
//    WebElement addtocard = driver.findElement(By.cssSelector("button[class='view_product'] "));
//    addtocard.click();
//    Tools.Bekle(1);
        AddtoCardClick();
        driver.switchTo().frame(driver.findElement(By.cssSelector("[class='EJIframeV3 EJOverlayV3']")));


        WebElement usingdebit = driver.findElement(By.cssSelector("button[class='Payment-Button CC']"));
        usingdebit.click();
        Tools.Bekle(4);
    }
}
