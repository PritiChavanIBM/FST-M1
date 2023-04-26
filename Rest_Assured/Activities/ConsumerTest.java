package project;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import au.com.dius.pact.provider.PactVerifyProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {

    Map<String, String> headers = new HashMap<>();
    String resourcePath = "/api/users";

    @Pact(consumer = "UserConsumer", provider = "UserProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder) {

        headers.put("Content-Type", "application/json");
        DslPart requestResponseBody = new PactDslJsonBody()
                .numberType("id", 45654)
                .stringType("firstName", "Priti")
                .stringType("lastName", "Chavan")
                .stringType("email", "priti@example.com");
        return builder.given("A request to create a user")
                .uponReceiving("")
                .method("POST")
                .path(resourcePath)
                .headers(headers)
                .body(requestResponseBody)
                .willRespondWith()
                .status(201)
                .body(requestResponseBody)
                .toPact();
    }

    @Test
    @PactTestFor(providerName = "UserProvider", port = "8585")
    public void PostRequestTest() {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("id", 45654);
        requestBody.put("firstName", "Priti");
        requestBody.put("lastName", "Chavan");
        requestBody.put("email", "priti@example.com");

        given().headers(headers).body(requestBody).baseUri("http://localhost:8585")
                .when().post(resourcePath)
                .then().statusCode(201);

    }
}
