package seminar_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class LoginPageTest {

    @Test
    void loginTest () throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized"); // режим полного экрана
        chromeOptions.addArguments("incognito");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://test-stand.gb.ru/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginInSystem("Ms.TestTwo", "03b10cd119");

        List<WebElement> searchList = driver.findElements(By.partialLinkText("Hello"));
        Assertions.assertEquals(1, searchList.size());

        MainPage mainPage = new MainPage(driver);
        mainPage.createPost();

        List<WebElement> title = driver.findElements(By.xpath("//*[@type='text']"));
        Assertions.assertEquals(1, title.size());

        CreatePostPage createPostPage = new CreatePostPage(driver);
        createPostPage.savePost("1111111111", "22222222");

        Thread.sleep(5000L);
        ElementPage elementPage = new ElementPage(driver);
        elementPage.deletePost();


//        driver.quit();
    }
}
