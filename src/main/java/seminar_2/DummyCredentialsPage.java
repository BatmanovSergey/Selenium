package seminar_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DummyCredentialsPage {
    private final WebDriverWait wait;
    @FindBy(xpath = "//*[@type='text']")
    private WebElement titleElement;
    @FindBy(xpath = "//*[@type='text']")
    private WebElement pwElement;
    @FindBy(xpath = "//*[@type='password']")
    private WebElement loginElement;
    @FindBy(css = "form#login button")
    private WebElement buttonCloseElement;

    public DummyCredentialsPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    void findTitle (String id) {

    }

}
