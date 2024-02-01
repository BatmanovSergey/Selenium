package seminar_3;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$x;

public class StudentPageS3 {
    private final ElementsCollection studentsTable = $$x("//tbody[@class='mdc-data-table__content']/tr");

    public void editStudentS3(String id) {
        getStudentRowByIdS3(id).clickEditButtonInRowS3();
    }

    public void checkStudentS3(String id) {
        getStudentRowByIdS3(id).clickCredentialButtonInRowS3();

    }

    public String getStudentNameByidS3(String id) {
        return getStudentRowByIdS3(id).getNameStudentS3();
    }

    private StudentRowS3 getStudentRowByIdS3(String id) { // Получаем конкретного студента по id
        return getListWebElements(studentsTable.shouldHave(sizeGreaterThan(0)))
                .stream()
                .map(StudentRowS3::new)
                .filter(row -> row.getIdStudentS3().equals(id)).findFirst().orElseThrow();
    }

    private List<StudentRowS3> getStudentListRow() { // Получаем список строк студентов
        return getListWebElements(studentsTable.shouldHave(sizeGreaterThan(0)))
                .stream()
                .map(StudentRowS3::new).toList();
    }

    private List<SelenideElement> getListWebElements(ElementsCollection table) {
        List<SelenideElement> StudentsList = new ArrayList<>();
        for (SelenideElement element : table) {
            StudentsList.add(element);
        }
        return StudentsList;
    }


}
