package seminar_2.HW2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;

public class AbstractTest2 {
    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeAll
    static void init() {

        // Настройки локального WebDriver.a
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized"); // режим полного экрана
        chromeOptions.addArguments("incognito");
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));


        //// Настройки удалённого WebDriver.a - вариант 1
//        ChromeOptions options = new ChromeOptions();
//        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
//            put("name", "Test badge...");
//            put("sessionTimeout", "15m");
//            put("env",new ArrayList<String>() {{
//                add("TZ=UTC");
//            }});
//            put("labels", new HashMap<String, Object>() {{
//                put("manual", "true");
//            }});
//            put("enableVideo", true);
//        }});
//        RemoteWebDriver driver = new RemoteWebDriver(new URL("https://localhost:4444/wd/hub"), options);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(5));


//        //// Настройки удалённого WebDriver.a - вариант 2
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setBrowserName("chrome");
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enablelog", true);
//        driver = new RemoteWebDriver(new URL("https://localhost:4444/wd/hub"), capabilities);

    }


    @AfterAll
    static void close() throws InterruptedException {
        Thread.sleep(3000L);
        driver.quit();
    }

}