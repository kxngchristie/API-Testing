import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    // A single, reusable instance of RequestSpecification for all tests.
    protected static RequestSpecification requestSpec;
    protected static final String trelloBoardsApiTestingMainUrl = "https://api.trello.com/1";

    @BeforeTest
    public void setup() throws IOException {
        // Load API key and token from a properties file.
        Properties props = new Properties();
        // It's a good practice to store sensitive data outside your code.
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        props.load(fis);
        // Read your API key and token from a properties file for security.
        String trelloBoardsApiTestingKey = props.getProperty("trelloBoardsApiTestingKey");
        String trelloBoardsApiTestingToken = props.getProperty("trelloBoardsApiTestingToken");

        // Build the RequestSpecification once.
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(trelloBoardsApiTestingMainUrl)
                .addQueryParam("key", trelloBoardsApiTestingKey)
                .addQueryParam("token", trelloBoardsApiTestingToken)
                .setContentType("application/json")
                .build();
    }
}