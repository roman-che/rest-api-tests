package ru.inventorium.qa.tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import ru.inventorium.qa.annotations.Layer;
import ru.inventorium.qa.annotations.Microservice;
import ru.inventorium.qa.testbase.UiTestBase;

import static ru.inventorium.qa.filters.CustomLogFilter.customLogFilter;
import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;


@Layer("rest")
@Owner("roman-che")
@Story("DemoWebShop")
@Feature("DemoWebShop")
public class DemoWebShopTest extends UiTestBase {
    @BeforeAll
    static void initBaseURIandURL() {
        RestAssured.baseURI = "http://demowebshop.tricentis.com";
        Configuration.baseUrl = "http://demowebshop.tricentis.com";
    }

    @Microservice("Authorization")
    @DisplayName("Authorize and assert user data")
    @Step("Get Cookie and test profile")
    @Tag("API")
    @Test
    void getCookieAndTestProfile() {

        String authorizationCookie =
                given()
                        .filter(customLogFilter().withCustomTemplates())
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .formParam("Email", "tester@qa.guru")
                        .formParam("Password", "tester@qa.guru")
                        .when()
                        .post("/login")
                        .then()
                        .statusCode(302)
                        .extract()
                        .cookie("NOPCOMMERCE.AUTH");

        step("Open browser", () ->
                open("/Themes/DefaultClean/Content/images/logo.png"));

        step("Authorize with cookie", () ->
                getWebDriver().manage().addCookie(new Cookie("NOPCOMMERCE.AUTH", authorizationCookie)));

        step("Open info page", () ->
                open("/customer/info"));

        step("Assert gender", () ->
                $("#gender-male").shouldBe(checked));

        step("Assert First Name", () ->
                $("#FirstName").shouldHave(value("tester")));

        step("Assert Last Name", () ->
                $("#LastName").shouldHave(value("testeroff")));

        step("Assert Email", () ->
                $("#Email").shouldHave(value("tester@qa.guru")));
    }
}
