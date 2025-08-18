package utilities;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import pojoClasses.models.Board;

public class BoardSteps {
    // Step 1: Building the request for creating a new board
    public static RequestSpecification buildCreateBoardRequest(RequestSpecification baseSpec, String boardName) {
        return given()
                .spec(baseSpec)
                .body("{\"name\": \"" + boardName + "\"}");
    }

    // Step 2: Sending the request and return the response
    public static Response sendPostRequest(RequestSpecification request, String endpoint) {
        return request.when().post(endpoint);
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
        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getName()).isEqualTo(expected.getName());
    }
}