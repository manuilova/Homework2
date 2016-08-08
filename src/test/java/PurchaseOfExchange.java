import org.openqa.selenium.By;
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
                .findElement(By.xpath("//div[contains(@class, 'block_important_gradient')]//form//*[contains(text(), 'купить')]"))
                .click();

        driver
                .findElement(By.id("fn_s1"))
                .sendKeys("2000");

        (new WebDriverWait(driver,10))
                .until(ExpectedConditions.textToBePresentInElementValue(By.id("fn_o1_1"), "49 982,2"));

    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }

}
