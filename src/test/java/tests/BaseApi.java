package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import utils.ExtentReportManager;

public class BaseApi {

    @RegisterExtension
    static ExtentReportManager watcher = new ExtentReportManager();

    @AfterAll
    static void generateTestReport(){
        watcher.writeReport();
    }
}
