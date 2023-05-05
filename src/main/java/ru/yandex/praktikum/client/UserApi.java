package ru.yandex.praktikum.client;

import ru.yandex.praktikum.model.User;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserApi extends BaseApi {
    private String registerPath = "api/auth/register/";
    private String loginPath = "api/auth/login/";
    private String userPath = "api/auth/user/";

    @Step("Создание пользователя")
    public Response createUser(User user) {
        return given()
                .spec(spec)
                .body(user)
                .post(registerPath);
    }

    @Step("Логин пользователя")
    public Response loginUser(User user) {
        return given()
                .spec(spec)
                .body(user)
                .post(loginPath);
    }

    @Step("Удаление пользователя")
    public Response deleteUser(String token) {
        return given()
                .header("authorization", token)
                .spec(spec)
                .when()
                .delete(userPath);
    }

}