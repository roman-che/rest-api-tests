package ru.inventorium.qa.tests;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import ru.inventorium.qa.testbase.ApiRequestsBase;

import static io.restassured.RestAssured.with;
import static ru.inventorium.qa.filters.CustomLogFilter.customLogFilter;

public class ReqresSpecification extends ApiRequestsBase {
    public static RequestSpecification request = with()
            .baseUri("https://reqres.in")
            .basePath("/api")
            .filter(customLogFilter().withCustomTemplates())
            .log().all()
            .contentType(ContentType.JSON);

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
}
