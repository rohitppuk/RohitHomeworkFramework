import io.github.bonigarcia.wdm.WebDriverManager;
import javafx.scene.layout.Priority;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class NopCommerceFramework {
    WebDriver driver;
    @Test(priority = 1)
    void openWebpage()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
    }
    @Test(priority = 2)
    void productNav() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='/computers']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='/desktops'][@ title='Show products in category Desktops']")).click();
        driver.findElement(By.xpath("//img[@alt=\"Picture of Lenovo IdeaCentre 600 All-in-One PC\"]")).click();
        driver.findElement(By.id("add-to-cart-button-3")).click();

    }
    @Test(priority = 3)
    void shoppingCart() throws InterruptedException {
        driver.findElement(By.xpath("//span[@class='cart-label']")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[1]/table/tbody/tr/td[5]/input")).clear();

        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[1]/table/tbody/tr/td[5]/input")).sendKeys("3");
        driver.findElement(By.id("updatecart")).click();
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']")).click();
        Thread.sleep(2000);

    }
    @Test(priority = 4)
    void billingAddress() throws InterruptedException {
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("TESTER");
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("KUMAR");
        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("TESTERKUMAR@TESTING.COM");
        driver.findElement(By.id("BillingNewAddress_Company")).sendKeys("TESTER PRIVATE LIMITED");
        WebElement country = driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select select = new Select(country);
        select.selectByVisibleText("United States");
       Thread.sleep(2000);
    WebElement county = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[1]/div[2]/form/div/div/div[2]/div/div/div[6]/select"));
    Select select1 = new Select(county);
        select1.selectByVisibleText("Alaska");

        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("NewYork");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("NewYork");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("nw13pq");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("420840");
        driver.findElement(By.xpath("//button[@type='button'][@class='button-1 new-address-next-step-button']")).click();
        driver.findElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']")).click();
    }




}
