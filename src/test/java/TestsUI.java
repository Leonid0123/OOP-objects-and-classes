import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestsUI {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(60000, TimeUnit.MILLISECONDS); //поставил такой большой таймаут, т.к. страница гугла очень долго прогружалась во время создания теста
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void pobedaTest() {
        //1.1 Перейти на сайт «https://www.google.ru/».
        driver.get("https://www.google.ru/");
        String originalWindow = driver.getWindowHandle();
        //1.2 ввести в строку поиска «Сайт компании Победа», после чего нажать Enter.
        WebElement searchBar = driver.findElement(By.cssSelector(".gLFyf"));
        searchBar.click();
        searchBar.sendKeys("Сайт компании Победа");
        searchBar.sendKeys(Keys.ENTER);

        //2. Дождаться прогрузки страницы с результатами поиска, после чего кликнуть на ссылку (https://www.pobeda.aero/). На момент создания теста эта ссылка отображалась второй.
        WebElement searchResult = driver.findElement(By.xpath("//cite[text()='https://www.pobeda.aero']"));
        searchResult.click();

        //переключение на новую вкладку
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        //3. Дождаться прогрузки страницы АК «Победа», после чего дождаться появления картинки с текстом «Полетели в Калининград» и проверить, что текст на странице действительно совпадает с текстом «Полетели в Калининград».
        WebElement pictureWithKaliningrad = driver.findElement(By.xpath("//div[text()='Полетели в Калининград!']"));
        isDisplayed(pictureWithKaliningrad);
        Assertions.assertEquals("Полетели в Калининград!", pictureWithKaliningrad.getText());

        //4. Кликнуть на переключатель языка, выбрать английский язык и убедиться, что на главной странице отображаются тексты "Ticket search", "Online check-in", "Manage my booking"
        driver.findElement(By.cssSelector("button[class='dp-bi33jb-root-root']")).click();
        driver.findElement(By.cssSelector(".dp-7l10my-root > .dp-1c1tdhh-root")).click();
        WebElement mainPage = driver.findElement(By.cssSelector("main[class='dp-1af5p36-content']"));
        WebDriverWait waitEnglishButtons = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitEnglishButtons.until(ExpectedConditions.textToBePresentInElement(mainPage, "Ticket search"));
        waitEnglishButtons.until(ExpectedConditions.textToBePresentInElement(mainPage, "Online check-in"));
        waitEnglishButtons.until(ExpectedConditions.textToBePresentInElement(mainPage, "Manage my booking"));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    private static void isDisplayed(WebElement element) {
        float waitingTime = 0;
        float MAX_WAITING_TIME = 45000;
        float startLoadingTime = System.currentTimeMillis();
        while (!element.isDisplayed()) {
            if (waitingTime <= MAX_WAITING_TIME) {
                waitingTime = System.currentTimeMillis() - startLoadingTime;
            } else {
                System.out.println("Condition wasn't executed with time limit");
                break;
            }
        }
        if (element.isDisplayed()) {
            System.out.println("Condition was executed in "
                    + waitingTime +
                    " seconds");
        }
    }
}
