package runner;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import tests.examples.login.LoginTest;
import tests.examples.product.ProductTest;
import tests.examples.user.UsersTest;

@Suite
@SelectClasses({LoginTest.class, ProductTest.class, UsersTest.class})
public class RunAllTests {
}
