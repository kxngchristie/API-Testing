package RestAssured;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojoClasses.models.Board;
import utilities.BoardSteps;

import static org.assertj.core.api.Assertions.assertThat;

public class RestAssuredTrelloTests extends BaseTest.BaseTest {
    private static String createdBoardId;
    private static final String createdBoardName = "RestAssured Automated Board";
    private static final String createdBoardDesc = "This is a board created by an automated test";

    @BeforeClass
    public void setupTestClass() {
        // This logic runs ONCE before any test in this class.
        System.out.println("\nExecuting @BeforeClass: Setting up RestAssured Client, Creating Board First for Setup");
        System.out.println("\nTest #1 - Creating a new board (POST)");

        // Preparing the request body as a JSON string.
        String requestBody = "{\"name\": \"" + createdBoardName + "\", \"desc\": \"" + createdBoardDesc + "\"}";

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
        Board expectedBoard = BoardSteps.prepareExpectedResponse(actualBoard.getId(), createdBoardName, createdBoardDesc);

        // Checking actual vs. expected responses using both TestNG and AssertJ.
        BoardSteps.checkActualVsExpectedResponses(actualBoard, expectedBoard);

        // AssertJ Assertions
        assertThat(actualBoard.getName()).as("The board name does not match the expected name.").isEqualTo(expectedBoard.getName());
        assertThat(actualBoard.getId()).as("The board ID does not match the expected id.").isEqualTo(expectedBoard.getId());
        assertThat(actualBoard.getDesc()).as("The board description should not be null or empty.").isNotNull().isNotEmpty();

        // TestNG Assertions
        Assert.assertEquals(actualBoard.getName(), expectedBoard.getName(), "The board name does not match the expected name.");
        Assert.assertEquals(actualBoard.getId(), expectedBoard.getId(), "The board ID does not match the expected id.");
        Assert.assertNotNull(actualBoard.getDesc(), "The board description should not be null or empty.");

        // Saving the board ID for subsequent tests.
        createdBoardId = actualBoard.getId().trim();
        System.out.println("Board created successfully with ID: " + createdBoardId);
    }

    @Test(priority = 2, description = "Verifies a board can be retrieved by its ID")
    public void testGetBoardById() {

        System.out.println("\nTest #2 - Getting board by ID (GET)");

        // Sending the GET request.
        Response response = BoardSteps.sendRequest(BoardSteps.buildRequest(requestSpec, null),
                "GET", "/boards/" + createdBoardId);

        System.out.println("\nStatus Code: " + response.getStatusCode());
        System.out.println("ID being used: " + createdBoardId);
        System.out.println("Response Body: " + response.getBody().asString());

        // Checking response validity.
        BoardSteps.checkResponseIsValid(response, 200);

        // Preparing the actual response.
        Board actualBoard = BoardSteps.prepareActualResponse(response);

        // AssertJ Assertions
        assertThat(actualBoard.getId()).as("The board ID does not match the expected ID.").isEqualTo(createdBoardId);
        assertThat(actualBoard.getName()).as("The board name does not match the expected name.").isEqualTo(createdBoardName);
        assertThat(actualBoard.getDesc()).as("The board description should not be null or empty.").isNotNull().isNotEmpty();
    }

    @Test(priority = 3, description = "Verifies a board's name can be updated")
    public void testUpdateBoard() {

        System.out.println("\nTest #3 - Updating board (PUT)");

        String updatedBoardName = "Updated RestAssured Automated Board";
        String updatedBoardDesc = "Testing Testing 123";
        String requestBody = "{\"name\": \"" + updatedBoardName + "\",\"desc\": \"" + updatedBoardDesc + "\"}";

        // Sending the PUT request.
        Response response = BoardSteps.sendRequest(BoardSteps.buildRequest(requestSpec, requestBody),
                "PUT", "/boards/" + createdBoardId);

        System.out.println("\nStatus Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        // Checking response validity.
        BoardSteps.checkResponseIsValid(response, 200);

        // Preparing the actual response.
        Board actualBoard = BoardSteps.prepareActualResponse(response);

        // TestNG Assertions
        Assert.assertEquals(actualBoard.getName(), updatedBoardName, "The board name was not updated correctly.");
        Assert.assertEquals(actualBoard.getId(), createdBoardId, "The board ID should not change after an update.");
        Assert.assertNotNull(actualBoard.getDesc(), "The board description was not updated correctly.");
    }

    /*@Test(priority = 4, description = "Verifies a board can be deleted")
    public void testDeleteBoard() {

        System.out.println("\nTest #4 - Removing board (DELETE)");

        // Sending the DELETE request.
        Response response = BoardSteps.sendRequest(BoardSteps.buildRequest(requestSpec, null),
                "DELETE", "/boards/" + createdBoardId);

        System.out.println("\nStatus Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        // Checking response validity.
        BoardSteps.checkResponseIsValid(response, 200);

        // Verifying deletion by trying to get board by id again.
        Response getResponse = BoardSteps.sendRequest(BoardSteps.buildRequest(requestSpec, null),
                "GET", "/boards/" + createdBoardId);

        // Checking that the board is no longer found.
        BoardSteps.checkResponseIsValid(getResponse, 404);

        System.out.println("Status Code: " + getResponse.getStatusCode());
        System.out.println("Board Not Found Response Body: " + getResponse.getBody().asString());
    }*/
}