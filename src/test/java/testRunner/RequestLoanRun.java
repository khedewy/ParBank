package testRunner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(features = {"src/test/java/features/RequestLoan.feature"},glue = {"steps"})
public class RequestLoanRun extends TestBase {
}
