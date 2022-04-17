package ru.inventorium.qa.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.inventorium.qa.annotations.Layer;
import ru.inventorium.qa.annotations.Microservice;
import ru.inventorium.qa.lombok.LombokUserData;
import ru.inventorium.qa.models.reqres.UserData;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.inventorium.qa.tests.ReqresSpecification.request;
import static ru.inventorium.qa.tests.ReqresSpecification.responseSpec;

@Layer("rest")
@Owner("roman-che")
@Story("ReqresIn")
@Feature("reqres.in")
@Tag("API")
public class ReqresTests {

    @Microservice("Users")
    @DisplayName("Check single user with regular model")
    @Test
    void singleUserWithModel() {

        UserData data = given()
                .spec(request)
                .when()
                .get("/users/2")
                .then()
                .spec(responseSpec)
                .log().body()
                .extract().as(UserData.class);

        assertEquals(2, data.getData().getId());
        assertEquals(data.getData().getFirstName(), "Janet");
        assertEquals(data.getData().getLastName(), "Weaver");
        assertEquals(data.getData().getEmail(), "janet.weaver@reqres.in");
    }

    @Microservice("Users")
    @DisplayName("Check single user using lombok model")
    @Test
    void singleUserWithLombokModel() {
        LombokUserData data = given()
                .spec(request)
                .when()
                .get("/users/3")
                .then()
                .spec(responseSpec)
                .log().body()
                .extract().as(LombokUserData.class);

        assertEquals(3, data.getUser().getId());
        assertEquals(data.getUser().getFirstName(), "Emma");
        assertEquals(data.getUser().getLastName(), "Wong");
        assertEquals(data.getUser().getEmail(), "emma.wong@reqres.in");
    }

    @Microservice("Users")
    @DisplayName("Check email with groovy")
    @Test
    public void checkEmailUsingGroovy() {
        given()
                .spec(request)
                .when()
                .get("/users")
                .then()
                .log().body()
                .body("data.findAll{it.email =~/.*?@reqres.in/}.email.flatten()",
                        hasItem("eve.holt@reqres.in"));
    }

    @Microservice("Users")
    @DisplayName("Check last name with groovy")
    @Test
    public void checkLastNameUsingGroovy() {
        given()
                .spec(request)
                .when()
                .get("/users")
                .then()
                .log().body()
                .body("data.findAll{it.last_name}.last_name.flatten()",
                        hasItem("Wong"));
    }

}
