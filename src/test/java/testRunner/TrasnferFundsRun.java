package testRunner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(features = "src/test/java/features/TransferFunds.feature",glue = {"steps"})
public class TrasnferFundsRun extends TestBase {
}
