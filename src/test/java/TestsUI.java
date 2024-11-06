import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestsUI {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        //1. Перейти на сайт «https://pikabu.ru/».
        driver.get("https://pikabu.ru/");
    }

    @Test
    public void pikabuTest() {
        //2. Убедиться, что заголовок сайта: «Горячее – самые интересные и обсуждаемые посты | Пикабу».
        Assertions.assertEquals("Горячее – самые интересные и обсуждаемые посты | Пикабу", driver.getTitle());

        //3. Кликнуть на кнопку «Войти».
        driver.findElement(By.cssSelector("button[class=\"pkb-normal-btn header-right-menu__login-button\"]")).click(); //клик по кнопке "Войти"

        //4. Убедиться, что отображается модальное окно «Авторизация», отображаются поля «Логин» и «Пароль», отображается кнопка «Войти».
        Assertions.assertTrue(driver.findElement(By.cssSelector("div[class=\"auth-modal\"]")).isDisplayed()); //проверка отображения модального окна «Авторизация»
        WebElement elementLogin = driver.findElement(By.xpath("//*[@class=\"auth-modal\"]//*[@id=\"signin-form\"]/div[1]/div/div/input"));
        Assertions.assertTrue(elementLogin.isDisplayed()); //проверка отображения поля «Логин»
        WebElement elementPassword = driver.findElement(By.xpath("//*[@class=\"auth-modal\"]//*[@id=\"signin-form\"]/div[2]/div/div/input"));
        Assertions.assertTrue(elementPassword.isDisplayed()); //проверка отображения поля «Пароль»
        WebElement buttonLogin = driver.findElement(By.cssSelector("div[class=\"auth-modal\"] #signin-form > div.auth__field.auth__field_firstbtn > button"));
        Assertions.assertTrue(buttonLogin.isDisplayed()); //проверка отображения кнопки «Войти»

        //5. Ввести в поля данные в формате логин/пароль – Qwerty/Qwerty и нажать «Войти».
        elementLogin.sendKeys("Qwerty");
        elementPassword.sendKeys("Qwerty");
        buttonLogin.click();

        //6. Убедиться, что появилось сообщение об ошибке, и его текст: «Ошибка. Вы ввели неверные данные авторизации».
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement noticeError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"popup__content\"] [class=\"auth__error auth__error_top\"]")));
        Assertions.assertTrue(noticeError.isDisplayed());
        Assertions.assertEquals("Ошибка. Вы ввели неверные данные авторизации", noticeError.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
