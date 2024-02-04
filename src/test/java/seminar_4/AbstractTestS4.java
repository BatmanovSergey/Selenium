package seminar_4;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;


public class AbstractTestS4 {
    @BeforeEach
    void init() {
//        Configuration.remote = "https://localhost:4444/wd/hub";
////        Configuration.browser = "opera";
////        Configuration.browserVersion = "112";
//        Map<String, Object> options = new HashMap<>();
//        options.put("enableVNC", true);
//        options.put("enableLog", true);
//        Configuration.browserCapabilities.setCapability("selenoid:options", options);

        open("https://test-stand.gb.ru/login");
    }

    @AfterEach
    void close() {
        WebDriverRunner.closeWebDriver();
    }
}