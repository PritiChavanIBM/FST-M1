package project;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GitHubRestAssuredProject {
    // Declare request specification
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    int sshKeyId=81218997;
    String token="token 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";
    String sshKey="ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQDSNLqSVm8va19xthPyCMKyx5IzsgiAF+EypFOvjikTbYZL09F6CyKE+zBbPjk3E+z3FBhpItPqzXyu/W6iaq6b+t/S7rkmdBhInLnAoWCUHpTYYflEhB7meNfFSh++SqPceUW1JzjaEmUEDh5H45TbJszDpVK0DgPfoQh+1VyRBvBpt1ej4iq4vB2D7AO8pAe7A7NCvxdHTp8x31k3uj6UH170ystGhRajHocvwXt42BnWuEs6qIFOE/crBm3Ms+fMFCBZSgKdXw3yt75gp4DesnXLPGuxAbOJoa85Hv8LEjMG6o+/xIgd9/WE0C2qkJDBvcGtCP8TnOTsRWFXDLBi6VgDHC/zYkfY3TawtWYFJ9KUk7TCnWlGYyCzcYIH4MxyBwOZydIGmvbje1IwaA2fE/C1dBaheRISoqj1WN2FrhbyrxO2REDxRghm3jev2ehH689nZx8uZeFMGAhbUc6TnGTInkbje5Ys7t33O85FiRLk68J1miBwyZ5ZuLjxSHU=";

    @BeforeClass
    public void setUp() {
        // Create request specification
        requestSpec = new RequestSpecBuilder()
                .addHeader("Authorization",token)
                .addHeader("Content-Type","application/json")
                .setBaseUri("https://api.github.com")
                .build();

        responseSpec = new ResponseSpecBuilder()
                .build();
    }

    @Test(priority = 1)
    public void POST1() {

        Map<String ,String> reqBody= new HashMap<>();
        reqBody.put("title","TestKey");
        reqBody.put("key",sshKey);
        Response response =
                given().spec(requestSpec)
                        .body(reqBody)
                        .post(" /user/keys");


       String body = response.getBody().asPrettyString();
        System.out.println(body);
        Reporter.log(body);
        sshKeyId= response.then().extract().path("id");
        System.out.println("sshKeyId "+sshKeyId);
        response.then().statusCode(201).spec(responseSpec);

    }

    @Test(priority = 2)
    public void GET1() {
        Response response =
                given().spec(requestSpec) // Use requestSpec
                        .pathParam("keyId", sshKeyId) // Set path parameter
                        .get(" /user/keys/{keyId}"); // Send GET request

        System.out.println("sshKeyId "+sshKeyId);
        String body = response.getBody().asPrettyString();
        System.out.println(body);
        Reporter.log(body);

        response.then().statusCode(200).spec(responseSpec);
    }
    @Test(priority = 3)
    public void DELETE1() {
        Response response =
                given().spec(requestSpec) // Use requestSpec
                        .pathParam("keyId", sshKeyId) // Set path parameter
                        .delete(" /user/keys/{keyId}"); // Send GET request

        String body = response.getBody().asPrettyString();
        System.out.println(body);
        Reporter.log(body);

        response.then().statusCode(204).spec(responseSpec);
    }
}
