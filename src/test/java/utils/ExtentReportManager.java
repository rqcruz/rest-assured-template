package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class ExtentReportManager implements TestWatcher {

    private static final String REPORT_PATH = "target/integrated-test-report/index.html";
    private static final String REPORT_NAME = "API Integrated Test Execution Report";
    private static final String DOCUMENT_TITLE = "API Integrated Test Execution Report";
    private static final String ENCODING = "utf-8";

    private final ExtentReports extentReports;
    private ExtentTest test;

    public ExtentReportManager() {
        this.extentReports = createExtentReports();
    }

    private ExtentReports createExtentReports() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(REPORT_PATH);
        sparkReporter.config().setReportName(REPORT_NAME);
        sparkReporter.config().setDocumentTitle(DOCUMENT_TITLE);
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setEncoding(ENCODING);

        ExtentReports reports = new ExtentReports();
        reports.attachReporter(sparkReporter);
        return reports;
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        createTest(context).skip(reason.orElse("Test disabled with reason provided"));
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        createTest(context).pass("Test passed");
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        createTest(context).skip("Test aborted");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        createTest(context).fail(cause);
    }

    private ExtentTest createTest(ExtensionContext context) {
        return extentReports.createTest(context.getDisplayName());
    }

    public void writeReport() {
        extentReports.flush();
    }
}
