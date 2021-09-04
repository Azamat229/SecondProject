package iu_selenium.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/report.json"},
        features = "src/main/java/resources/features",
        glue = "iu_selenium/test"

)
public class UITestRunner {

}
