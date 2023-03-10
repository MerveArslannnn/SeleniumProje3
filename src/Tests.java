import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.tools.Tool;
import java.time.Duration;
import java.util.List;

public class Tests extends BaseDriver {
    @Test
    void task1() {


//        WebElement ebook = driver.findElement(By.xpath("(//div[@class='column all_tag']/a)[2]"));
//        ebook.click();
//        WebElement addtocard = driver.findElement(By.xpath("//div[@class='basicDetails']/button"));
//        addtocard.click();
//
//        Tools.Bekle(1);
        AddtoCardClick();
        driver.switchTo().frame(driver.findElement(By.cssSelector("[class='EJIframeV3 EJOverlayV3']")));
//        WebElement addpromocode = driver.findElement(By.cssSelector("button[class='Continue-Button Close-Cart']~button"));
        WebElement addpromocode = driver.findElement(By.cssSelector("div[class='Actions'] :nth-child(2)"));
        addpromocode.click();
        Tools.Bekle(1);

        WebElement promcode = driver.findElement(By.cssSelector("input[class='Promo-Code-Value']"));
        promcode.sendKeys("1234");
        Tools.Bekle(1);

        WebElement apply = driver.findElement(By.xpath("//button[text()='Apply']"));
        apply.click();

        WebElement invalidcode = driver.findElement(By.cssSelector("div[id='SnackBar']"));
        System.out.println(invalidcode.isDisplayed());
        Assert.assertTrue(invalidcode.isDisplayed(), "Web Element gözükmüyor");
    }

    @Test
    void task2() {
//        driver.get("https://shopdemo.e-junkie.com/");
//
//        WebElement ebook = driver.findElement(By.xpath("(//div[@class='column all_tag']/a)[2]"));
//        ebook.click();
//        WebElement addtocard = driver.findElement(By.cssSelector("button[class='view_product'] "));
//        addtocard.click();
//        Tools.Bekle(1);
//
        AddtoCardClick();
        driver.switchTo().frame(driver.findElement(By.cssSelector("[class='EJIframeV3 EJOverlayV3']")));


        WebElement usingdebit = driver.findElement(By.cssSelector("button[class='Payment-Button CC']"));
        usingdebit.click();
        Tools.Bekle(4);

        WebElement paybtn = driver.findElement(By.cssSelector("[class='Pay-Button']"));
        paybtn.click();


        WebElement resulttext = driver.findElement(By.cssSelector("[name='close-circle']~span"));
        System.out.println(resulttext.getText());

        Assert.assertTrue(resulttext.getText().contains("Invalid Email\n" + "Invalid Email\n" + "Invalid Billing Name"), "Mesajlar eşit değil");


    }

    @Test
    void task3() {
//        WebElement ebook = driver.findElement(By.xpath("(//div[@class='column all_tag']/a)[2]"));
//        ebook.click();
//        WebElement addtocard = driver.findElement(By.cssSelector("button[class='view_product'] "));
//        addtocard.click();
//        Tools.Bekle(1);
//
//        driver.switchTo().frame(driver.findElement(By.cssSelector("[class='EJIframeV3 EJOverlayV3']")));
//
//
//        WebElement usingdebit = driver.findElement(By.cssSelector("button[class='Payment-Button CC']"));
//        usingdebit.click();
//        Tools.Bekle(4);
        UsingDebitClick();
        driver.switchTo().frame(2);

        WebElement inputcardnumber = driver.findElement(By.cssSelector("[name='cardnumber']"));
        inputcardnumber.sendKeys("1111 1111 1111 1111");
//        "1111 1111 1111 1111"

//        driver.switchTo().parentFrame();
//        WebElement paybtn = driver.findElement(By.cssSelector("[class='Pay-Button']"));
//        paybtn.click();
//        Tools.Bekle(1);
        driver.switchTo().parentFrame();

        WebElement invalid = driver.findElement(By.xpath("//div[@id='SnackBar']/span"));


        System.out.println(invalid.getText());
        Assert.assertTrue((invalid.getText().contains("Your card number is invalid") | invalid.getText().contains("Kart numaranız geçersiz.")));

    }

    @Test
    void task4() {
//        WebElement ebook = driver.findElement(By.xpath("(//div[@class='column all_tag']/a)[2]"));
//        ebook.click();
//        WebElement addtocard = driver.findElement(By.cssSelector("button[class='view_product'] "));
//        addtocard.click();
//        Tools.Bekle(1);
//
//        driver.switchTo().frame(driver.findElement(By.cssSelector("[class='EJIframeV3 EJOverlayV3']")));
//
//
//        WebElement usingdebit = driver.findElement(By.cssSelector("button[class='Payment-Button CC']"));
//        usingdebit.click();
//        Tools.Bekle(4);
        //Form doldur
        //p lerden 2. locator
        UsingDebitClick();

        WebElement email = driver.findElement(By.xpath("((//div[@class='Billing-Form Form']/p)/input)[1]"));
        email.sendKeys("algz34hasan@gmail.com");
        Tools.Bekle(1);
        WebElement emailconfirm = driver.findElement(By.xpath("((//div[@class='Billing-Form Form']/p)/input)[2]"));
        emailconfirm.sendKeys("algz34hasan@gmail.com");
        Tools.Bekle(1);

        WebElement name = driver.findElement(By.xpath("((//div[@class='Billing-Form Form']/p)/input)[3]"));
        name.sendKeys("Grup Dokuz");
        Tools.Bekle(1);

        WebElement phone = driver.findElement(By.xpath("((//div[@class='Billing-Form Form']/p)/input)[4]"));
        phone.sendKeys("05330270000");
        Tools.Bekle(1);

        WebElement company = driver.findElement(By.xpath("((//div[@class='Billing-Form Form']/p)/input)[5]"));
        company.sendKeys("GrupDokuz");
        Tools.Bekle(1);

        /*
        List<WebElement> emails=driver.findElements(By.cssSelector("input[type='email']"));
        emails.get(1).sendKeys("algz34hasan@gmail.com");
        emails.get(2).sendKeys("algz34hasan@gmail.com");

        WebElement name=driver.findElement(By.cssSelector("input[autocomplete='name']"));
        name.sendKeys("Grup Dokuz");

        WebElement phone=driver.findElement(By.cssSelector("input[autocomplete='name']"));
        phone.sendKeys("05330270000");

        WebElement company=driver.findElement(By.cssSelector("input[autocomplete='company']"));
        phone.sendKeys("GrupDokuz");*/
        driver.switchTo().frame(2);

        WebElement inputcardnumber = driver.findElement(By.cssSelector("[name='cardnumber']"));
        inputcardnumber.sendKeys("4242 4242 4242 4242");
//        inputcardnumber.sendKeys("4242 4242 4242 42420927616");


        WebElement inputdate = driver.findElement(By.cssSelector("span>input[autocomplete='cc-exp']"));
        inputdate.sendKeys("0927");

        WebElement inputcsv = driver.findElement(By.cssSelector("span>input[autocomplete='cc-csc']"));
        inputcsv.sendKeys("616");


        driver.switchTo().parentFrame();

        WebElement paybtn = driver.findElement(By.cssSelector("[class='Pay-Button']"));
        paybtn.click();

//"Your order is confirmed. Thank you!"
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        Tools.Bekle(20);
        WebElement resulttext = driver.findElement(By.cssSelector("[class='confirme_text']>span"));
        System.out.println(resulttext.getText());

        Assert.assertTrue(resulttext.getText().contains("your order is confirmed. Thank you!"), "Mesajlar eşleşmiyor");
    }

    @Test
    void task5() {
        driver.get("https://shopdemo.e-junkie.com/");

        WebElement contactus = driver.findElement(By.cssSelector("a[class='contact']"));
        contactus.click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        WebElement name = driver.findElement(By.xpath("(//form[@method='post']/p/input)[1]"));
        name.sendKeys("Grup Dokuz");
        WebElement email = driver.findElement(By.xpath("(//form[@method='post']/p/input)[2]"));
        email.sendKeys("algz34hasan@gmail.com");
        WebElement subject = driver.findElement(By.xpath("(//form[@method='post']/p/input)[3]"));
        subject.sendKeys("Subject");


        WebElement messagearea = driver.findElement(By.xpath("(//form[@method='post']/p/textarea)"));
        messagearea.sendKeys("Bizler tarihin ortanca çocuklarıyız. Bir amacımız ya da yerimiz yok, ne büyük savaşı yaşadık ne de büyük buhranı. Bizim savaşımız ruhani bir savaş, en büyük buhranımız hayatlarımız");


        WebElement sendmessage = driver.findElement(By.cssSelector("button[id='send_message_button']"));
        sendmessage.click();
        Tools.Bekle(3);
        System.out.println(driver.switchTo().alert().getText());
        Assert.assertTrue(driver.switchTo().alert().getText().contains("Recaptcha didn't match"));
        driver.switchTo().alert().accept();
//Recaptcha didn't match

    }
}
