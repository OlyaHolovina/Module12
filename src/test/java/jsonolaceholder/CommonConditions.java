package jsonolaceholder;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.parallel.Execution;


import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

@Execution(CONCURRENT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CommonConditions {

    @BeforeAll()
    public void setUp(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users";

    }
}
