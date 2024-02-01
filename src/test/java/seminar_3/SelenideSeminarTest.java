package seminar_3;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import seminar_2.*;

import java.time.Duration;
import java.util.List;

public class SelenideSeminarTest {
    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeEach
    void init() {
        Selenide.open("https://test-stand.gb.ru/login");
        driver = WebDriverRunner.getWebDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
// Код с семинара
    void loginTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loginInSystem("Ms.TestTwo", "03b10cd119");

        Thread.sleep(3000L);

        List<WebElement> searchList = driver.findElements(By.partialLinkText("Hello"));
        Assertions.assertEquals(1, searchList.size());

//        MainPage mainPage = new MainPage(driver);
        MainPageS3 mainPageS3 = Selenide.page(MainPageS3.class);
        mainPageS3.createPost();

        List<WebElement> title = driver.findElements(By.xpath("//*[@type='text']"));
        Assertions.assertEquals(1, title.size());

        CreatePostPage createPostPage = new CreatePostPage(driver);
        createPostPage.savePost("11111111", "22222222");

        Thread.sleep(5000L);
        ElementPage elementPage = new ElementPage(driver);
        elementPage.deletePost();

    }


    @Test
    void profileTest () throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loginInSystem("Ms.TestTwo", "03b10cd119");

        Thread.sleep(5000L);

//        MainPage mainPage = new MainPage(driver);
        MainPageS3 mainPageS3 = Selenide.page(MainPageS3.class);
        mainPageS3.openProfile();

        ProfilePageS3 profilePageS3 = Selenide.page(ProfilePageS3.class);
        Assertions.assertEquals(profilePageS3.getFullNameText(),profilePageS3.getH2FullNameText());
    }

    @AfterEach
    void close() {
        WebDriverRunner.closeWebDriver();
    }
}
