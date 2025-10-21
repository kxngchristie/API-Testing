package BaseTest;

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
        // Loading API key and token from a properties file.
        Properties props = new Properties();
        // Storing Sensitive Data Outside Code
        FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
        props.load(fis);
        // Reading API key and token from a properties file for security.
        String trelloBoardsApiTestingKey = props.getProperty("trelloBoardsApiTestingKey");
        String trelloBoardsApiTestingToken = props.getProperty("trelloBoardsApiTestingToken");

        // Building the RequestSpecification once.
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(trelloBoardsApiTestingMainUrl)
                .addQueryParam("key", trelloBoardsApiTestingKey)
                .addQueryParam("token", trelloBoardsApiTestingToken)
                .setContentType("application/json")
                .build();
    }
}