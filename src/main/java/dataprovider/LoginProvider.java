package dataprovider;

import static factory.LoginFactory.*;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class LoginProvider {

    static Stream<Arguments> provideInvalidCredentials() {
        return Stream.of(
                Arguments.of(setCredentials("fake", "fake"), "username or password is incorrect"),
                Arguments.of(setCredentials("fake", "83r5^_"), "username or password is incorrect"),
                Arguments.of(setCredentials("mor_2314", "fake"), "username or password is incorrect"));
    }
}
