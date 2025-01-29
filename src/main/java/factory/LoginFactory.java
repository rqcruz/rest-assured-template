package factory;

import dto.LoginDTO;

public class LoginFactory {

    public static LoginDTO getValidCredentials() {
        return LoginDTO
                .builder()
                .username("mor_2314")
                .password("83r5^_")
                .build();
    }

    public static LoginDTO setCredentials(String username, String password) {
        return LoginDTO
                .builder()
                .username(username)
                .password(password)
                .build();
    }
}
