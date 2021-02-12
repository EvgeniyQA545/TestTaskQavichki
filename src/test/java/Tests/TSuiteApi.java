package Tests;
import TestMethods.MyApi;
import TestMethods.TBaseClass;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import io.restassured.RestAssured;
import  com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import TestMethods.RequestBody;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.IOException;
import java.io.StringWriter;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

public class TSuiteApi extends MyApi {

    @Test
    public void testGetPostApi1(){
        RestAssured.given().when().get("/posts/100").then().log().all().assertThat().statusCode(200).and().body("id", is(100));
        RestAssured.given().when().delete("/posts/100").then().log().all().assertThat().statusCode(200);
        RestAssured.given().when().delete("/posts/99").then().log().all().assertThat().statusCode(200);


    }
    @Test
    public void testPostPostsApi2(){
        RequestBody requestBody = new RequestBody();
        requestBody.setBody("АхалайМахалай");
        requestBody.setTitle("СнипСнапСнуреБуреБазелюре");
        requestBody.setUserId(5);
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(writer, requestBody);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(requestBody);
        String result = writer.toString();
        System.out.println(result);
        RestAssured.given().contentType(ContentType.JSON).body(result).post("/posts").then().log().all().assertThat().statusCode(201).body("body", is("АхалайМахалай"));
        RestAssured.given().get("/posts/101").then().log().all().assertThat().statusCode(200).body("body", is("АхалайМахалай"));

    }

}
