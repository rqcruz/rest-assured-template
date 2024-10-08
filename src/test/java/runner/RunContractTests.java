package runner;

import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("Run only contract tests suite")
@SelectPackages("tests")
@IncludeClassNamePatterns({"^.*ContractTests?$"})
@ExcludePackages("runner")
public class RunContractTests {
}
