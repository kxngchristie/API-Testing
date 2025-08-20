package utilities;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojoClasses.models.Board;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class BoardSteps {
    // Step 1: Building a general-purpose request
    public static RequestSpecification buildRequest(RequestSpecification baseSpec, String body) {
        RequestSpecification request = given().spec(baseSpec);
        if (body != null) {
            request.body(body);
        }
        return request;
    }

    // Step 2: Sending a general-purpose request
    public static Response sendRequest(RequestSpecification request, String httpMethod, String endpoint) {
        return switch (httpMethod.toUpperCase()) {
            case "POST" -> request.when().post(endpoint);
            case "GET" -> request.when().get(endpoint);
            case "PUT" -> request.when().put(endpoint);
            case "DELETE" -> request.when().delete(endpoint);
            default -> throw new IllegalArgumentException("Unsupported HTTP method:" + httpMethod);
        };
    }

    // Step 3: Checking that the response is valid (e.g., status code)
    public static void checkResponseIsValid(Response response, int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }

    // Step 4: Preparing the actual response by deserializing it into a Pojo
    public static Board prepareActualResponse(Response response) {
        return response.as(Board.class);
    }

    // Step 5: Preparing the expected response
    // This creates a Pojo with the values you expect to receive from the API.
    public static Board prepareExpectedResponse(String id, String name) {
        Board expectedBoard = new Board();
        expectedBoard.setId(id);
        expectedBoard.setName(name);
        return expectedBoard;
    }

    // Step 6: Checking the actual response vs. the expected response
    // This uses AssertJ to compare the values of the two Pojo objects.
    public static void checkActualVsExpectedResponses(Board actual, Board expected) {
        // Checking that the ID is NOT null and is a valid string, not that it equals the expected value
        assertThat(actual.getId()).isNotNull().isNotEmpty();
        // Checking the name, which you do have an expected value for
        assertThat(actual.getName()).isEqualTo(expected.getName());
        // Checking that the ID is not equal to null
        assertThat(actual.getId()).isNotEqualTo(null);
    }

    // This uses TestNG to compare the values of two Pojo objects.
    // public static void checkActualVsExpectedResponses(Board actual, Board expected) {
        // Assert.assertEquals(actual.getId(), expected.getId(), "Board ID did not match.");
        // Assert.assertEquals(actual.getName(), expected.getName(), "Board name did not match.");
    // }
}