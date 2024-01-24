package seminar_1.HW1;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Task1Test extends AbstractTest {

    @Test
    void addNewDummyWithImplicity() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement buttonPlus = driver.findElement(By.id("create-btn"));
        buttonPlus.click();

        WebElement title = driver.findElement(By.xpath("//*[@type='text']"));
        title.sendKeys("Проверка");

        WebElement description = driver.findElement(By.xpath("//textarea[@class='mdc-text-field__input']"));
        description.sendKeys("Проверка");

        WebElement buttonSave = driver.findElement(By.xpath("//*[@type='submit']"));
        buttonSave.click();

        List<WebElement> searchList = driver.findElements(By.xpath("//h1[@class='svelte-tv8alb']"));

        Assertions.assertEquals(1, searchList.size());
        Assertions.assertEquals("Проверка", searchList.get(0).getText());

        Thread.sleep(2000L);
        System.out.println("Проверка прошла");

        // сохранение скриншота окна браузера
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("src/main/resources/screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    void addNewDummyWithExplicity() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement buttonPlus = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("create-btn")));
        buttonPlus.click();

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3)) // Максимальный тайм-аут 3 секунды
                .pollingEvery(Duration.ofMillis(500L)) // Интервал опроса страницы полсекунды
                .ignoring(NoSuchElementException.class); //Игнор NoSuchElementException

        WebElement title = fluentWait.until(
                webDriver -> webDriver.findElement(By.xpath("//*[@type='text']")));
        title.sendKeys("Проверка ожидания");

        WebElement description = driver.findElement(By.xpath("//textarea[@class='mdc-text-field__input']"));
        description.sendKeys("Проверка ожидания");

        WebElement buttonSave = driver.findElement(By.xpath("//*[@type='submit']"));
        buttonSave.click();

        WebElement search = fluentWait.until(
                webDriver -> webDriver.findElement(By.xpath("//h1[@class='svelte-tv8alb']")));

        Assertions.assertEquals("Проверка ожидания", search.getText());

        Thread.sleep(2000L);
        System.out.println("Проверка ожидания прошла");

    }
}
