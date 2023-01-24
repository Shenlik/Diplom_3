package ru.yandex.practicum.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import ru.yandex.practicum.dto.CreateUserRequest;
import ru.yandex.practicum.dto.UserResponse;
import ru.yandex.practicum.dto.LoginUserRequest;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_ACCEPTED;
import static java.net.HttpURLConnection.HTTP_OK;

public class ClientUser {

    public static final String STELLARBURGERS_URL = "https://stellarburgers.nomoreparties.site";
    public static final String REGISTER_USER_URL = "/api/auth/register";
    public static final String USER_URL = "api/auth/user";

    public static final String LOGIN_USER_URL = "api/auth/login";

    public static final ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.disable(FAIL_ON_UNKNOWN_PROPERTIES);

        RestAssured.baseURI = STELLARBURGERS_URL;
    }

    public static CreateUserRequest createUserRequest() {
        var userRequest = new CreateUserRequest();
        userRequest.setName("user");
        userRequest.setEmail(RandomStringUtils.randomAlphabetic(6) + "@mail.ru");
        userRequest.setPassword("password");
        return userRequest;
    }

    public static UserResponse createUser(CreateUserRequest createUserRequest) throws JsonProcessingException {
        var requestAsJson = OBJECT_MAPPER.writeValueAsString(createUserRequest);

        var response =  given()
                .header("Content-type", "application/json")
                .and()
                .body(requestAsJson)
                .when()
                .post(REGISTER_USER_URL);

        response.then().statusCode(HTTP_OK);

        return OBJECT_MAPPER.readValue(response.getBody().asString(), UserResponse.class);
    }

    public static UserResponse loginUser(String email, String password) throws JsonProcessingException {
        var request = new LoginUserRequest(email, password);
        var requestAsJson = OBJECT_MAPPER.writeValueAsString(request);

        var response =  given()
                .header("Content-type", "application/json")
                .and()
                .body(requestAsJson)
                .when()
                .post(LOGIN_USER_URL);
        return OBJECT_MAPPER.readValue(response.getBody().asString(), UserResponse.class);
    }

    public static void deleteUser(String token) {
        given()
                .header("Authorization", token)
                .header("Content-type", "application/json")
                .and()
                .when()
                .delete(USER_URL)
                .then()
                .statusCode(HTTP_ACCEPTED);
    }
}
