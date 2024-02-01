package seminar_3;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class EditingDummyPageS3 {

    private final SelenideElement firstNameInputField = $x(
            "//form[@id='upsert-item']/div[1]/label/input");
    private final SelenideElement saveButton = $("button[form='upsert-item']");

    public void ChangeDummyFirstNameS3(String name) {

//        Thread.sleep(3000L);

        firstNameInputField.shouldBe(visible).setValue(name);
        saveButton.shouldBe(visible).click();
    }


}
