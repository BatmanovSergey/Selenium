package seminar_4;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import seminar_3.LoginPageS3;
import seminar_3.MainPageS3;
import seminar_3.ProfilePageS3;
import seminar_3.StudentPageS3;
import static com.codeborne.selenide.Selenide.page;

public class SelinoidTest extends AbstractTestS4 {

    @Test
    void profileTest () {
        LoginPageS3 loginPageS3 = page(LoginPageS3.class);
        loginPageS3.loginInSystemS3("GB202306611b512", "a5c6730434");

        Selenide.sleep(2000L);

//        MainPage mainPage = new MainPage(driver);
        MainPageS3 mainPageS3 = Selenide.page(MainPageS3.class);
        mainPageS3.openProfileS3();

        Selenide.sleep(2000L);

        ProfilePageS3 profilePageS3 = Selenide.page(ProfilePageS3.class);
        Assertions.assertEquals(profilePageS3.getFullNameTextS3(),profilePageS3.getH2FullNameTextS3());
    }

    @Test
    void addPictureInProfileTest ()  {
        LoginPageS3 loginPageS3 = page(LoginPageS3.class);
        loginPageS3.loginInSystemS3("GB202306611b512", "a5c6730434");

        StudentPageS3 studentPageS3 = page(StudentPageS3.class);
        studentPageS3.openProfileS3();

        ProfilePageS3 profilePageS3 = page(ProfilePageS3.class);
        profilePageS3.clickEditProfileS3();
        profilePageS3.uploadNewAvatarImageS3("src/main/resources/anime.jpeg");
        profilePageS3.clickSaveProfileUpdateDataS3();

        Assertions.assertTrue(profilePageS3.getUploadFileNameS3().contains("anime.jpeg"));
        Assertions.assertEquals("C:\\fakepath\\anime.jpeg",profilePageS3.getUploadFileNameS3());
        // кавычки " экранируются \ -> \", а обратный слэш \ экранируется \\
        System.out.println(profilePageS3.getUploadFileNameS3());
        Selenide.sleep(10000L);

    }
}
