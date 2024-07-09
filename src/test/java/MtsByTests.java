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
        driver.get("https://www.mts.by/");
        driver.manage().window().maximize();


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
        driver.findElement(By.xpath(Locators.SERVICE_NAME_SVYAZ)).getText();
        driver.findElement(By.xpath(Locators.INPUT_NUMBER)).sendKeys("29777777");
        driver.findElement(By.xpath(Locators.INPUT_SUMMA)).sendKeys("20");
        driver.findElement(By.xpath(Locators.INPUT_EMAIL)).sendKeys("niknamed300@mail.ru");
        driver.findElement(By.xpath(Locators.BUTTON_CON)).click();
        driver.findElement(By.xpath(Locators.PAY_SECTION)).isDisplayed();

    }

    @Test
    @DisplayName("1. Проверить надписи в незаполненных полях каждого варианта оплаты услуг" +
            ": услуги связи, домашний интернет, рассрочка, задолженность;")
    public void fourthTest() {
        //Проверка "Услуги связи"
        driver.findElement(By.xpath(Locators.SERVICE_NAME_SVYAZ)).getText();
        driver.findElement(By.xpath(String.valueOf(By.xpath(Locators.EMPTY_NUMBER_CHECKED)))).getText();
        driver.findElement(By.xpath(Locators.EMPTY_SUMMA)).getText();
        driver.findElement(By.xpath(Locators.EMPTY_EMAIL)).getText();
        //Проверка "Домашний интеренет"
        driver.findElement(By.xpath(Locators.SELECT_SERVICE_BUTTON)).click();
        driver.findElement(By.xpath(Locators.SELECT_SERIVE_HOUSE_INTERNET)).click();
        driver.findElement(By.xpath(String.valueOf(By.xpath(Locators.EMPTY_NUMBER_CHECKED)))).getText();
        driver.findElement(By.xpath(Locators.EMPTY_SUMMA)).getText();
        driver.findElement(By.xpath(Locators.EMPTY_EMAIL)).getText();
        //Проверка "Рассрочка"
        driver.findElement(By.xpath(Locators.SELECT_SERVICE_BUTTON)).click();
        driver.findElement(By.xpath(Locators.INSTALLMENT_PLAY)).click();
        driver.findElement(By.xpath(Locators.AMOUNT_NUMBER)).getText();
        driver.findElement(By.xpath(Locators.EMPTY_SUMMA)).getText();
        driver.findElement(By.xpath(Locators.EMPTY_EMAIL)).getText();
        //Проверка "Задолженность"
        driver.findElement(By.xpath(Locators.SELECT_SERVICE_BUTTON)).click();
        driver.findElement(By.xpath(Locators.DEBT)).click();
        driver.findElement(By.xpath(Locators.DEBT_AMOUNT_NUMBER)).getText();
        driver.findElement(By.xpath(Locators.EMPTY_SUMMA)).getText();
        driver.findElement(By.xpath(Locators.EMPTY_EMAIL)).getText();

    }

    @Test
    @DisplayName("2. Для варианта «Услуги связи» заполнить поля" +
            " в соответствии с пререквизитами из предыдущей темы," +
            " нажать кнопку «Продолжить» и в появившемся окне проверить корректность" +
            " отображения суммы (в том числе на кнопке), номера телефона," +
            " а также надписей в незаполненных полях для ввода реквизитов карты," +
            " наличие иконок платёжных систем.")
    public void fivethTest() {
        driver.findElement(By.xpath(Locators.SERVICE_NAME_SVYAZ)).getText();
        driver.findElement(By.xpath(Locators.INPUT_NUMBER)).sendKeys("29777777");
        driver.findElement(By.xpath(Locators.INPUT_SUMMA)).sendKeys("20");
        driver.findElement(By.xpath(Locators.INPUT_EMAIL)).sendKeys("niknamed300@mail.ru");
        driver.findElement(By.xpath(Locators.BUTTON_CON)).click();
        waitFor.waiter(1);
        driver.findElement(By.xpath(Locators.PAY_SECTION)).isDisplayed();
        driver.findElement(By.xpath(Locators.WE_CAN_SEE_SUMMA)).isDisplayed();
        driver.findElement(By.xpath(Locators.CARD_NUMBER)).getText();
        driver.findElement(By.xpath(Locators.ICONS_ON_CARD_DETAILS_INFO)).isDisplayed();
        driver.findElement(By.xpath(Locators.CARD_EXPIRY_DATE)).getText();
        driver.findElement(By.xpath(Locators.CVC)).getText();
        driver.findElement(By.xpath(Locators.HOLDER_NAME)).getText();
        driver.findElement(By.xpath(Locators.INFO_ABOUT_COST_OF_THE_PAYING)).getText();
    }

    @AfterEach
    public void endTest() {
        driver.quit();
    }
}