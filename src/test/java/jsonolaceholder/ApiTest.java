package jsonolaceholder;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ApiTest extends CommonConditions {

    public ApiTest() throws UnsupportedEncodingException {
    }

    @Test
    public void verifyStatusCode() {
        Response response = given().when().get().then().extract().response();

        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    public void verifyAnHttpResponseBody() {
        given().when().get().
                then().log().all()
                .assertThat().body("id", Matchers.hasSize(10));
    }

    @Test
    public void verifyCreatingNewUserPOST() throws UnsupportedEncodingException {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users";

        Map<String, Object> user = new HashMap<>();
        user.put("name", "Olha");
        user.put("username", "Holovina");

        var response = given()
                .contentType(ContentType.JSON)
                .body(user)
                .when().post(baseURI)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .log().body();
    }
}
