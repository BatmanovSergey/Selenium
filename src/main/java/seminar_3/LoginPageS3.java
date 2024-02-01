package seminar_3;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPageS3 {

    private final SelenideElement loginField = $x("//*[@type='text']");

    private final SelenideElement passwordField = $x("//*[@type='password']");

    private final SelenideElement button = $("form#login button");


    public void loginInSystemS3(String login, String password) {
        loginField.shouldBe(visible).setValue(login);
        passwordField.shouldBe(visible).setValue(password);
        button.shouldBe(visible).click();
    }

    public void loginWithOutAuthorizationS3() {
        button.shouldBe(visible).click();
    }

}
