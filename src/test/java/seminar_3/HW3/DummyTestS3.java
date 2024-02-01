package seminar_3.HW3;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import seminar_3.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class DummyTestS3 extends AbstractTestS3 {
    @Test
        // Домашнее задание 3: задача 1
    void loginWithOutAuthorizationTestS3() {

        LoginPageS3 loginPageS3 = Selenide.page(LoginPageS3.class);
        loginPageS3.loginWithOutAuthorizationS3();

        SelenideElement error = $x("//h2[@class='svelte-uwkxn9']").shouldBe(visible);
        Assertions.assertEquals("401", error.text());
    }

    @Test
        // Домашнее задание 3: задача 2
    void dummyChangeNameTestS3() {

        LoginPageS3 loginPageS3 = Selenide.page(LoginPageS3.class);
        loginPageS3.loginInSystemS3("GB202306611b512", "a5c6730434");

        SelenideElement search = $x("//a[@href='/about']").shouldBe(visible);
        Assertions.assertEquals("About", search.text());

        StudentPageS3 studentPageS3 = Selenide.page(StudentPageS3.class);
        studentPageS3.editStudentS3("20004");

        SelenideElement searchId = $x(" //span[@slot='title']").shouldBe(visible);
        Assertions.assertEquals("Editing Dummy 20004", searchId.text());

        String a = RandomStringUtils.randomAlphabetic(3); // генерит буквы
        String b = RandomStringUtils.randomAlphanumeric(3); // генерит буквы и цифры
        String newName = a + b;

        EditingDummyPageS3 editingDummyPageS3 = Selenide.page(EditingDummyPageS3.class);
        editingDummyPageS3.ChangeDummyFirstNameS3(newName);

        String checkName = studentPageS3.getStudentNameByidS3("20004");
        Assertions.assertNotEquals(newName, checkName);
    }
    @Test
        // Домашнее задание 3: задача 3
    void credentialsWindowTestS3() {

        LoginPageS3 loginPageS3 = Selenide.page(LoginPageS3.class);
        loginPageS3.loginInSystemS3("GB202306611b512", "a5c6730434");

        SelenideElement search = $x("//a[@href='/about']").shouldBe(visible);
        Assertions.assertEquals("About", search.text());

        StudentPageS3 studentPageS3 = Selenide.page(StudentPageS3.class);
        studentPageS3.checkStudentS3("20004");

        DummyCredentialsPageS3 dummyCredentialsPageS3 = Selenide.page(DummyCredentialsPageS3.class);

        Assertions.assertAll(() -> Assertions.assertEquals("Dummy credentials", dummyCredentialsPageS3
                        .findTitleS3().getText()),
                () -> Assertions.assertTrue((dummyCredentialsPageS3.findLoginAndPWS3().text().contains("Login"))),
                () -> Assertions.assertTrue((dummyCredentialsPageS3.findLoginAndPWS3().text().contains("PW"))),
                () -> Assertions.assertEquals("CLOSE", dummyCredentialsPageS3.findCloseButtonS3().text()));
    }
}
