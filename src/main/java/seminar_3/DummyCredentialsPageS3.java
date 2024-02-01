package seminar_3;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class DummyCredentialsPageS3 {
    private final SelenideElement titleElement = $x("//h2[@id='simple-title']");
    private final SelenideElement contentElement = $x("//div[@id='simple-content']");
    private final SelenideElement buttonCloseElement = $x(
            "//div[@class='mdc-dialog__actions']/button/span");

    public SelenideElement findTitleS3 () {
        return titleElement.shouldBe(visible);
    }

    public SelenideElement findLoginAndPWS3 () {
        return contentElement.shouldBe(visible);
    }

    public SelenideElement findCloseButtonS3 () {
        return buttonCloseElement.shouldBe(visible);
    }

}
