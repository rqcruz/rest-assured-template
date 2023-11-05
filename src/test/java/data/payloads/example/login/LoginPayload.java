package data.payloads.example.login;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginPayload {

    @JsonProperty("username")
    private final String username;

    @JsonProperty("password")
    private final String password;

    public LoginPayload(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
