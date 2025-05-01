package petstore;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class store {
    String uri= "https://petstore.swagger.io/v2/store/order";

    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }
    @Test
    public void incluirStore() throws IOException {
        String jsonBody = lerJson("db/store.json");

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri)
                .then()
                .log().all()
                .statusCode(200);

    }
    @Test
    public void getStore() throws IOException {
         given()
                 .contentType("application/json")
                .log().all()
         .when()
                 .get(uri + "/" + 1)
         .then()
                 .log().all()
                 .statusCode(200);

    }

}
