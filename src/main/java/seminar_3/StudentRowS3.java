package seminar_3;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;

public class StudentRowS3 {
    private final SelenideElement root;
    public StudentRowS3(SelenideElement root) {
        this.root = root;
    }

    public String getIdStudentS3() {
        return root.$x("./td[1]").shouldBe(visible).text();
    }

    public String getNameStudentS3() {
        return root.$x("./td[2]").shouldBe(visible).text();
    }

    public void clickEditButtonInRowS3() {
        root.$x("./td[7]/button[2]").shouldBe(visible).click();
    }

    public void clickCredentialButtonInRowS3() {
        root.$x("./td[7]/button[1]").shouldBe(visible).click();
    }

}
