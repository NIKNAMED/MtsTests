import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
    @DisplayName("1. Проверить название указанного блока;" +
                 "2. Проверить наличие логотипов платёжных систем;")
    public void firstTest() {
    driver.findElement(By.xpath(Locators.BLOCK_NAME));
    driver.findElement(By.xpath(Locators.PARTNERS_LOGOS));

    }

    @Test
    @DisplayName("3. Проверить работу ссылки «Подробнее о сервисе»;")
    public void secondTest() {
    driver.findElement(By.xpath(Locators.MORE_INFO_BUTTON)).click();
    driver.findElement(By.xpath(Locators.CHECK_INFO_AFTER_BUTTON_MORE_INFO)).isDisplayed();

    }

    @Test
    @DisplayName("4. Заполнить поля и проверить работу кнопки «Продолжить» " +
            "(проверяем только вариант «Услуги связи», номер для теста 297777777)")
    public void thrirdTest() {
    driver.findElement(By.xpath(Locators.SERVICE_NAME)).getText();
    driver.findElement(By.xpath(Locators.INPUT_NUMBER)).sendKeys("29777777");
    driver.findElement(By.xpath(Locators.INPUT_SUMMA)).sendKeys("20");
    driver.findElement(By.xpath(Locators.INPUT_EMAIL)).sendKeys("niknamed300@mail.ru");
    driver.findElement(By.xpath(Locators.BUTTON_CON)).click();
    driver.findElement(By.xpath(Locators.CARD_INFO)).isDisplayed();

    }

    @AfterEach
    public void endTest() {
        driver.quit();
    }
}