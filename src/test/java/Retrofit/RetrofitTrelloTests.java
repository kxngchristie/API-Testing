package Retrofit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojoClasses.models.Board;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import services.TrelloApiService;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class RetrofitTrelloTests {
    private static String createdBoardId;
    private static final String createdBoardName = "Retrofit Automated Board";
    private static final String createdBoardDesc = "This is a board created by an automated test";
    private static TrelloApiService trelloApiService;
    private static String apiKey;
    private static String apiToken;

    @BeforeClass
    public void setupTestClass() throws IOException {
        System.out.println("\nExecuting @BeforeClass: Setting up Retrofit Client, Creating Board First for Setup");

        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
        props.load(fis);
        apiKey = props.getProperty("trelloBoardsApiTestingKey");
        apiToken = props.getProperty("trelloBoardsApiTestingToken");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.trello.com/1/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        trelloApiService = retrofit.create(TrelloApiService.class);
    }

    @Test(priority = 1, description = "Verifies a new Trello board can be created with Retrofit")
    public void testCreateNewBoard() throws IOException {
        Board boardToCreate = new Board();
        boardToCreate.setName(createdBoardName);
        boardToCreate.setDesc(createdBoardDesc);

        Response<Board> response = trelloApiService.createBoard(apiKey, apiToken, boardToCreate).execute();

        System.out.println("\nTest #1 - Creating a new board (POST)");

        Assert.assertEquals(response.code(), 200);

        Board createdBoard = response.body();
        Assert.assertNotNull(createdBoard);
        assertThat(createdBoard.getName()).isEqualTo(createdBoardName);

        createdBoardId = createdBoard.getId();
        System.out.println("Board created successfully with ID: " + createdBoardId);
    }

    @Test(priority = 2, description = "Verifies a board can be retrieved by its ID with Retrofit")
    public void testGetBoardById() throws IOException {
        Response<Board> response = trelloApiService.getBoard(createdBoardId, apiKey, apiToken).execute();

        System.out.println("\nTest #2 - Getting board by ID (GET)");

        Assert.assertEquals(response.code(), 200);

        Board retrievedBoard = response.body();
        Assert.assertNotNull(retrievedBoard);
        assertThat(retrievedBoard.getId()).isEqualTo(createdBoardId);
        assertThat(retrievedBoard.getName()).isEqualTo(createdBoardName);
    }

    @Test(priority = 3, description = "Verifies a board's name can be updated with Retrofit")
    public void testUpdateBoard() throws IOException {
        String updatedBoardName = "Retrofit Automated Updated Board";
        String updatedBoardDesc = "Testing Testing 123";
        Board boardToUpdate = new Board();
        boardToUpdate.setName(updatedBoardName);
        boardToUpdate.setDesc(updatedBoardDesc);

        Response<Board> response = trelloApiService.updateBoard(createdBoardId, apiKey, apiToken, boardToUpdate).execute();

        System.out.println("\nTest #3 - Updating board (PUT)");

        Assert.assertEquals(response.code(), 200);

        Board updatedBoard = response.body();
        Assert.assertNotNull(updatedBoard);
        assertThat(updatedBoard.getName()).isEqualTo(updatedBoardName);
    }

    @Test(priority = 4, description = "Verifies a board can be deleted with Retrofit")
    public void testDeleteBoard() throws IOException {
        Response<Void> deleteResponse = trelloApiService.deleteBoard(createdBoardId, apiKey, apiToken).execute();
        Assert.assertEquals(deleteResponse.code(), 200);

        Response<Board> getResponse = trelloApiService.getBoard(createdBoardId, apiKey, apiToken).execute();

        System.out.println("\nTest #4 - Removing board (DELETE)");

        Assert.assertEquals(getResponse.code(), 404);
    }
}