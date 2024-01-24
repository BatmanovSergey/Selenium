package seminar_1;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class FirstTaskTest {
    WebDriver driver;
    String log = "Ms.TestTwo";
    String pass = "03b10cd119";

    @BeforeEach
    void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized"); // режим полного экрана
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://test-stand.gb.ru/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
//    @Disabled
    void test() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized"); // режим полного экрана
//        chromeOptions.addArguments("--headless"); // без запуска UI браузера
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://test-stand.gb.ru/login");
        Thread.sleep(5000L);
        driver.quit();
    }

    @Test
    void authorizationTest1() {
        WebElement login = driver.findElement(By.xpath("//*[@type='text']"));
        WebElement password = driver.findElement(By.xpath("//*[@type='password']"));
        WebElement button = driver.findElement(By.xpath("//*[@class='mdc-button__ripple']"));

//        WebElement usernameField = driver.findElement(By.cssSelector("form#login input[type='text']"));
//        WebElement passwordField = driver.findElement(By.cssSelector("form#login input[type='password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("form#login button"));

        login.sendKeys(log);
        password.sendKeys(pass);
        loginButton.click();

        List<WebElement> searchList = driver.findElements(By.partialLinkText("Hello"));
        Assertions.assertEquals(1, searchList.size());
    }

    @Test
    void authorizationTest2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("form#login input[type='text']")));
        WebElement password = driver.findElement(By.xpath("//*[@type='password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("form#login button"));

        login.sendKeys(log);
        password.sendKeys(pass);
        loginButton.click();

        List<WebElement> searchList = driver.findElements(By.partialLinkText("Hello"));
        Assertions.assertEquals(1, searchList.size());
    }

    @AfterEach
    void close() {
        driver.quit();
    }
}
