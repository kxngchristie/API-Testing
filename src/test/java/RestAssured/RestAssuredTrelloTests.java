package RestAssured;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojoClasses.models.Board;
import utilities.BoardSteps;

import static org.assertj.core.api.Assertions.assertThat;

public class RestAssuredTrelloTests extends BaseTest.BaseTest {
    private static String createdBoardId;
    private static final String createdBoardName = "My Automated Board";

    @BeforeClass
    public void setupTestClass() {
        // This logic runs ONCE before any test in this class.
        System.out.println("\nexecuting @Before Class: Creating a new board for all tests.");
        System.out.println("\nTest #1 - Creating a new board (POST)");

        // Preparing the request body as a JSON string.
        String requestBody = "{\"name\": \"" + createdBoardName + "\"}";

        // Sending the POST request.
        Response response = BoardSteps.sendRequest(BoardSteps.buildRequest(requestSpec, requestBody),
                "POST", "/boards");

        System.out.println("\nStatus Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        // Checking response validity.
        BoardSteps.checkResponseIsValid(response, 200);

        // Preparing the actual response by deserializing it into a pojo.
        Board actualBoard = BoardSteps.prepareActualResponse(response);

        // Preparing the expected response.
        Board expectedBoard = BoardSteps.prepareExpectedResponse(null, createdBoardName); // ID is unknown at this point

        // Checking actual vs. expected responses using both TestNG and AssertJ.
        BoardSteps.checkActualVsExpectedResponses(actualBoard, expectedBoard);

        // TestNG Assertion
        // Assert.assertEquals(actualBoard.getName(), expectedBoard.getName(), "The board name does not match the expected name.");

        // AssertJ Assertion
        // assertThat(actualBoard.getDesc()).isNotNull();
        // assertThat(actualBoard.getName()).isNotEmpty();

        // Saving the board ID for subsequent tests.
        createdBoardId = actualBoard.getId().trim();
        System.out.println("Board created successfully with ID: " + createdBoardId);
    }

    @Test(priority = 2, description = "Verifies a board can be retrieved by its ID")
    public void testGetBoardById() {

        System.out.println("\nTest #2 - Getting board by ID (GET)");
        System.out.println("\nID being used: '" + createdBoardId + "'");

        // Sending the GET request.
        Response response = BoardSteps.sendRequest(BoardSteps.buildRequest(requestSpec, null),
                "GET", "/boards/" + createdBoardId);

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        // Checking response validity.
        BoardSteps.checkResponseIsValid(response, 200);

        // Preparing the actual response.
        Board actualBoard = BoardSteps.prepareActualResponse(response);

        // Assertions
        assertThat(actualBoard.getId()).isEqualTo(createdBoardId);
        assertThat(actualBoard.getName()).isEqualTo(createdBoardName);
    }

    @Test(priority = 3, dependsOnMethods = {"testGetBoardById"}, description = "Verifies a board's name can be updated")
    public void testUpdateBoard() {

        System.out.println("\nTest #3 - Updating board (PUT)");

        String updatedBoardName = "Updated Automated Board";
        String updatedBoardDesc = "Testing Testing 123";
        String requestBody = "{\"name\": \"" + updatedBoardName + "\",\"desc\": \"" + updatedBoardDesc + "\"}";

        // Sending the PUT request.
        Response response = BoardSteps.sendRequest(BoardSteps.buildRequest(requestSpec, requestBody),
                "PUT", "/boards/" + createdBoardId);

        System.out.println("\nStatus Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        // Check response validity.
        BoardSteps.checkResponseIsValid(response, 200);

        // Preparing the actual response.
        Board actualBoard = BoardSteps.prepareActualResponse(response);

        // Assertions
        assertThat(actualBoard.getName()).isEqualTo(updatedBoardName);
        assertThat(actualBoard.getDesc()).isEqualTo(updatedBoardDesc);
    }

    @Test(priority = 4, description = "Verifies a board can be deleted")
    public void testDeleteBoard() {

        System.out.println("\nTest #4 - Removing board (DELETE)");

        // Sending the DELETE request.
        Response response = BoardSteps.sendRequest(BoardSteps.buildRequest(requestSpec, null),
                "DELETE", "/boards/" + createdBoardId);

        System.out.println("\nStatus Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        // Check response validity.
        BoardSteps.checkResponseIsValid(response, 200);

        // Verifying deletion by trying to get board by id again.
        Response getResponse = BoardSteps.sendRequest(BoardSteps.buildRequest(requestSpec, null),
                "GET", "/boards/" + createdBoardId);

        // Asserting that the board is no longer found.
        BoardSteps.checkResponseIsValid(getResponse, 404);
    }
}