package seminar_3;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Condition.visible;

public class ProfilePageS3 {
    @FindBy(xpath = "//h2[@class='mdc-typography--headline6 svelte-vyyzan']")
    private SelenideElement h2fullName;

    @FindBy(xpath = "//h3/following-sibling::div" +
            "//div[contains(text(), 'Full name')]/following-sibling::div")
    private SelenideElement fullName;

    public String getH2FullNameText () {
        return h2fullName.shouldBe(visible).text();
    }

    public String getFullNameText () {
        return fullName.shouldBe(visible).text();
    }

}
