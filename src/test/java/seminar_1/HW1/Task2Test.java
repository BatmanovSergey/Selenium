package seminar_1.HW1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Task2Test {
    static WebDriver driver;
    static Actions action;
    static WebDriverWait wait;

    @BeforeAll
    static void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized"); // режим полного экрана
        chromeOptions.addArguments("incognito");
        driver = new ChromeDriver(chromeOptions);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        action = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    @Test
    void dragAndDropTestWithImplicity() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));

        WebElement pic = driver.findElement(By.xpath("//img[@src='images/high_tatras3_min.jpg']"));
//        WebElement pic = driver.findElement(By.xpath("//*[contains(text(),'Tatras 3')]")); // Вариант 2
        WebElement trash = driver.findElement(By.xpath("//div[@id='trash']"));
        action.dragAndDrop(pic, trash).build().perform();

        List<WebElement> picInTrash = driver.findElements(
                By.xpath("//div[@id='trash']//img[@src='images/high_tatras3_min.jpg']"));
//        List<WebElement> picInTrash = driver.findElements(
//                By.xpath("//div[@id='trash']//a[@href='images/high_tatras3.jpg']")); // Вариант 2
        Assertions.assertEquals(1,picInTrash.size());
        Assertions.assertEquals("Planning the ascent",picInTrash.get(0).getAttribute("alt"));

    }

    @Test
    void dragAndDropTestWithExplicity() {
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.xpath("//iframe[@class='demo-frame lazyloaded']")));

        WebElement pic = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//img[@src='images/high_tatras3_min.jpg']")));

        WebElement trash = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[@id='trash']")));

        action.dragAndDrop(pic, trash).build().perform();

        WebElement picInTrash = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[@id='trash']//img[@src='images/high_tatras3_min.jpg']")));
        Assertions.assertEquals("Planning the ascent",picInTrash.getAttribute("alt"));
    }

    @AfterAll
    static void close() {
        driver.quit();
    }

}
