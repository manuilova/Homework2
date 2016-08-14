import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class PurchaseOfExchange {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.get("http://finance.i.ua/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testName() throws Exception  {

        driver
                .findElement(By.xpath("//table[@class='converter']//span[text()='купить']"))
                .click();

        driver
                .findElement(By.id("fn_s1"))
                .sendKeys("2000");

        WebElement exchangeType = driver.findElement(By.id("fn_bank"));
        new Select(exchangeType).selectByVisibleText("НБУ");

        (new WebDriverWait(driver,10))
                .until(ExpectedConditions.textToBePresentInElementValue(By.id("fn_o1_1"), "49\u00A0700,82"));


    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }

}
