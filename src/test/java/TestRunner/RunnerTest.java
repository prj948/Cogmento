package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/java/Features/LoginPage.feature",
"src/test/java/Features/TC_002_cogmento_ContactPage.feature"},
                  glue= {"StepDefination"},
                   dryRun=false,
                monochrome=true		 )
public class RunnerTest {

}
