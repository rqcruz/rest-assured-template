package runner;

import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("Run only functional tests suite")
@SelectPackages("tests")
@IncludeClassNamePatterns({"^.*FunctionalTests?$"})
@ExcludePackages("runner")
public class RunFunctionalTests {
}
