package petstore;

import org.testng.annotations.Test;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class Pet {
    String uri= "https://petstore.swagger.io/v2/pet";

    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test
    public void incluirPet() throws IOException {
        String jsonBody = lerJson("db/pet1.json");

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)

        .when()
                .post(uri)
        .then()
                .log().all()
                .statusCode(200)
        ;

    }

    @Test
    public void GetPet() throws IOException {
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(uri + "/" + 1)
        .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void PutPet() throws IOException {
        String jsonBody = lerJson("db/edicao.json");
       given()
       .contentType("application/json")
               .log().all()
               .body(jsonBody)
       .when()
               .put(uri)
       .then()
               .log().all()
               .statusCode(200);
    }
    @Test
    public void DeletePet() throws IOException {
        given()
        .contentType("application/json")
                .log().all()
        .when()
                .delete(uri + "/" + 1)
        .then()
                .log().all()
                .statusCode(200);
    }
};
