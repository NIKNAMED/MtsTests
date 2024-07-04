import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.Driver;

public class MtsByTests {

    WebDriver driver;

    @BeforeEach
    public void startTest() {

        System.setProperty("webdriver.chrome.driver",
                "D:\\а\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");

    }

    @Test
    @DisplayName("22")
    public void check() {
    driver.findElement(By.xpath(Locators.BLOCK_NAME));
    driver.findElement(By.xpath(Locators.PARTNERS_LOGOS));
    }








    @AfterEach
    public void endTest() {
        driver.quit();
    }
}




