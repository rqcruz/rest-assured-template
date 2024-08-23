package runner;

import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("Run only functional tests")
@SelectPackages("tests")
@IncludeClassNamePatterns({"^.*FunctionalTests?$"})
@ExcludePackages("runner")
public class RunFunctionalTests {
}
