import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import lombok.SneakyThrows;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class TestsAPI {
    Student student1 = new Student(1, "Mike", List.of(3, 5, 4, 2));
    Student student2 = new Student(2, "Paul", List.of(4, 5, 3, 3));
    Student postStudent = new Student(3, "Max", List.of(5, 5, 4, 3));
    Student postNullIdStudent = new Student(null, "Piter", List.of(4, 4, 4, 4));
    Student topStudent1 = new Student(6, "Tom1", List.of(5));
    Student topStudent2 = new Student(7, "Tom2", List.of(5));
    Student topStudentWithoutMarks = new Student(8, "Chris", new ArrayList<>());
    Student topStudentMaxMarks = new Student(9, "Tom3", List.of(5, 5));
    ObjectMapper mapper = new ObjectMapper();

    @SneakyThrows
    @BeforeEach
    public void prepare() {
        RestAssured.given()
                .baseUri("http://localhost:8080/student")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsBytes(student1))
                .when()
                .post();

        RestAssured.given()
                .baseUri("http://localhost:8080/student")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsBytes(student2))
                .when()
                .post();

        RestAssured.given()
                .baseUri("http://localhost:8080/student")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsBytes(topStudent1))
                .when()
                .post();

        RestAssured.given()
                .baseUri("http://localhost:8080/student")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsBytes(topStudent2))
                .when()
                .post();
    }

    @AfterEach
    public void clear() {
        for (int i = 1; i <= 20; i++) { //удаление всех записей в БД, которые могли быть добавлены в процессе запуска тестового прогона
            RestAssured.given()
                    .baseUri("http://localhost:8080/student/" + i)
                    .when()
                    .delete();
        }
    }

    @Test
    public void getStudent() { //получение студента
        RestAssured.given()
                .baseUri("http://localhost:8080/student/" + student1.getId())
                .when()
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", Matchers.equalTo(student1.getId()))
                .body("name", Matchers.equalTo(student1.getName()))
                .body("marks", Matchers.equalTo(student1.getMarks()));
    }

    @Test
    public void getStudentFailed() { //получение несуществующего студента
        RestAssured.given()
                .baseUri("http://localhost:8080/student/-1")
                .param("id", "-1")
                .when()
                .get()
                .then()
                .statusCode(404)
                .body(Matchers.equalTo(""));
    }

    @Test
    public void getStudentWithEmptyDb() { //получение несуществующего студента при отсутствии студентов в БД
        clear();
        RestAssured.given()
                .baseUri("http://localhost:8080/student/-1")
                .param("id", "-1")
                .when()
                .get()
                .then()
                .statusCode(404)
                .body(Matchers.equalTo(""));
    }

    @Test
    @SneakyThrows
    public void postStudent() { //добавление студента
        RestAssured.given()
                .baseUri("http://localhost:8080/student")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsBytes(postStudent))
                .when()
                .post()
                .then()
                .statusCode(201);

        RestAssured.given()
                .baseUri("http://localhost:8080/student/" + postStudent.getId())
                .when()
                .get()
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .body("id", Matchers.equalTo(postStudent.getId()))
                .body("name", Matchers.equalTo(postStudent.getName()))
                .body("marks", Matchers.equalTo(postStudent.getMarks()));
    }

    @Test
    @SneakyThrows
    public void postNullIdStudent() { //добавление студента с id=null
        Integer tempId = RestAssured.given()
                .baseUri("http://localhost:8080/student")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsBytes(postNullIdStudent))
                .when()
                .post()
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body(Matchers.notNullValue())
                .extract().as(Integer.class);

        RestAssured.given()
                .baseUri("http://localhost:8080/student/" + tempId)
                .when()
                .get()
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .body("id", Matchers.equalTo(tempId))
                .body("name", Matchers.equalTo(postNullIdStudent.getName()))
                .body("marks", Matchers.equalTo(postNullIdStudent.getMarks()));

        RestAssured.given()
                .baseUri("http://localhost:8080/student/" + tempId)
                .when()
                .delete()
                .then()
                .statusCode(200);
    }

    @Test
    @SneakyThrows
    public void postUpdateStudent() { //обновление студента
        postStudent.setName("MaxUpd");

        RestAssured.given()
                .baseUri("http://localhost:8080/student")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsBytes(postStudent))
                .when()
                .post()
                .then()
                .statusCode(201);

        RestAssured.given()
                .baseUri("http://localhost:8080/student/" + postStudent.getId())
                .when()
                .get()
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .body("id", Matchers.equalTo(postStudent.getId()))
                .body("name", Matchers.equalTo(postStudent.getName()))
                .body("marks", Matchers.equalTo(postStudent.getMarks()));
    }

    @Test
    public void postIncorrectStudent() { //400 код при отсутствии имени в запросе добавления студента
        RestAssured.given()
                .baseUri("http://localhost:8080/student")
                .contentType(ContentType.JSON)
                .body("""
                        {
                        "id":5,
                        "marks":[4,5,3,3,5]
                        }
                        """)
                .when()
                .post()
                .then()
                .statusCode(400);
    }

    @Test
    public void deleteStudent() { //удалить несуществующего пользователя
        RestAssured.given()
                .baseUri("http://localhost:8080/student/" + student1.getId())
                .when()
                .delete()
                .then()
                .statusCode(200);
    }

    @Test
    public void deleteNonExistentStudent() { //удалить несуществующего пользователя
        RestAssured.given()
                .baseUri("http://localhost:8080/student/-1")
                .when()
                .delete()
                .then()
                .statusCode(404);
    }

    @Test
    @SneakyThrows
    public void topOneStudent() { //Вывод студента с самой высокой средней оценкой, выводится студент с большим количеством оценок, т.к. средний балл равен у нескольких студентов
        RestAssured.given()
                .baseUri("http://localhost:8080/student")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsBytes(topStudentMaxMarks))
                .when()
                .post()
                .then()
                .statusCode(201);

        RestAssured.given()
                .baseUri("http://localhost:8080/topStudent")
                .when()
                .get()
                .then()
                .statusCode(200)
                .body("id", Matchers.contains(topStudentMaxMarks.getId()))
                .body("name", Matchers.contains(topStudentMaxMarks.getName()))
                .body("marks", Matchers.contains(topStudentMaxMarks.getMarks()));
    }

    @Test
    public void topTwoStudents() { //вывод двух студентов с самой высокой средней оценкой
        RestAssured.given()
                .baseUri("http://localhost:8080/topStudent")
                .when()
                .get()
                .then()
                .statusCode(200)
                .body("id", Matchers.contains(topStudent1.getId(), topStudent2.getId()))
                .body("name", Matchers.contains(topStudent1.getName(), topStudent2.getName()))
                .body("marks", Matchers.contains(topStudent1.getMarks(), topStudent2.getMarks()));
    }

    @Test
    public void topStudentWithoutStudents() { //в базе нет студентов
        clear();
        RestAssured.given()
                .baseUri("http://localhost:8080/topStudent")
                .when()
                .get()
                .then()
                .statusCode(200)
                .body(Matchers.equalTo(""));
    }

    @Test
    @SneakyThrows
    public void topStudentWithoutMarks() {
        clear();
        RestAssured.given() //добавление студента без оценок
                .baseUri("http://localhost:8080/student")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsBytes(topStudentWithoutMarks))
                .when()
                .post()
                .then()
                .statusCode(201);

        RestAssured.given()
                .baseUri("http://localhost:8080/topStudent")
                .when()
                .get()
                .then()
                .statusCode(200)
                .body(Matchers.equalTo(""));

        RestAssured.given() //удаление студента без оценок
                .baseUri("http://localhost:8080/student/" + topStudentWithoutMarks.getId())
                .when()
                .delete()
                .then()
                .statusCode(200);
    }
}
