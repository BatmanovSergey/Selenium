package seminar_1.HW1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class AbstractTest {
    static WebDriver driver;
    String log = "Ms.TestTwo";
    String pass = "03b10cd119";

    @BeforeAll
    static void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized"); // режим полного экрана
        chromeOptions.addArguments("incognito");
//        chromeOptions.addArguments("--headless"); // без запуска UI браузера
        driver = new ChromeDriver(chromeOptions);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @BeforeEach
    void login() {
        driver.get("https://test-stand.gb.ru/login");
        WebElement login = driver.findElement(By.xpath("//*[@type='text']"));
        WebElement password = driver.findElement(By.xpath("//*[@type='password']"));
        WebElement button = driver.findElement(By.cssSelector("form#login button"));

        login.sendKeys(log);
        password.sendKeys(pass);
        button.click();
    }

    @AfterAll
    static void close() {
        driver.quit();
    }

}
