package petstore;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class user {
    String uri= "https://petstore.swagger.io/v2/user";

    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test
    public void incluirUser() throws IOException {
        String jsonBody = lerJson("db/user.json");
        given()
                .contentType("application/json")
                .body(jsonBody)
        .when()
                .post(uri)
        .then()
                .statusCode(200);

    }
    @Test
    public void loginUser() throws IOException {
        given()
                 .contentType("application/json")
                .log().all()
        .when()
                .get(uri+ "/" + "login" +"?username=amora")
        .then()
                .log().all()
                .statusCode(200);

    }
    @Test
    public void getUser() throws IOException {
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(uri+ "/" + "user1")
        .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    public void putUser() throws IOException {
        String jsonBody = lerJson("db/edicaoUser.json");

        given()
        .contentType("application/json")
                .log().all()
                .body(jsonBody)
        .when()
                .put(uri + "/" + "amora")
        .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void deleteUser() throws IOException {
        given()
        .contentType("application/json")
                .log().all()
        .when()
                .delete(uri + "/" + "user1")
        .then()
                .log().all()
                .statusCode(200);

    }
}
