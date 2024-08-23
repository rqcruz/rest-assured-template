package runner;

import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("Run only security tests")
@SelectPackages("tests")
@IncludeClassNamePatterns({"^.*SecurityTests?$"})
@ExcludePackages("runner")
public class RunSecurityTests {
}
