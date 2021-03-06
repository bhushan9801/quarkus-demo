package com.helios.quarkus.demo

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
open class MetricsResourceTest {

    @Test
    fun testHelloEndpoint() {
        given()
          .`when`().get("/ping")
          .then()
             .statusCode(200)
    }

}
