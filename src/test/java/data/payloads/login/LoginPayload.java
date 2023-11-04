package data.payloads.login;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginPayload {

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    public LoginPayload(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
