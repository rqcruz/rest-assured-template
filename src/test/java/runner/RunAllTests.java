package runner;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Running All Tests Suite")
@SelectClasses({RunFunctionalTests.class, RunContractTests.class, RunSecurityTests.class})
public class RunAllTests {
}
