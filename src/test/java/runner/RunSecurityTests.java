package runner;

import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("Run only security tests suite")
@SelectPackages("tests")
@IncludeClassNamePatterns({"^.*SecurityTests?$"})
@ExcludePackages("runner")
public class RunSecurityTests {
}
