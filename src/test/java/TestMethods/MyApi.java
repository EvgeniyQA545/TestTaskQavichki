package TestMethods;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import netscape.javascript.JSObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.CoreMatchers.is;

public class MyApi {
    private static RequestSpecification spec;
    public Response response;
    public static String jsonAsString;


    @BeforeMethod
    public static void configureRestAssured() {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";



    }



}
