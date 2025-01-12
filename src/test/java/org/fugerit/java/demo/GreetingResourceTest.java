package org.fugerit.java.demo;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from Quarkus REST"));
    }

    @Test
    void testHelloFreeMarkerEndpoint() {
        given()
                .when().get("/hello/freemarker")
                .then()
                .statusCode(200)
                .body(containsString("Hello : FreeMarker Native Demo"));
    }

    @Test
    void testHelloFreeMarkerVersionEndpoint() {
        given()
                .when().get("/hello/freemarker/2/3/33")
                .then()
                .statusCode(200)
                .body(containsString("Hello : FreeMarker Native Demo"));
    }

    @Test
    void testHelloFreeMarkerKoEndpoint() {
        given()
                .when().get("/hello/freemarker/2/3/-1")
                .then()
                .statusCode(500);
    }

}