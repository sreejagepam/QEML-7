package org.example.runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        // Path to the feature files folder (UI Scenarios)
        features = "src/test/resources/features/ui",
        // Path to the step definitions package
        glue = {
                "org.example.stepdefinitions.ui", // Step definitions for UI automation
                "org.example.hooks"               // Hooks for setup and teardown
        },

        // Generate reports
        plugin = {
                "pretty",                            // Prints output in readable format
                "html:target/cucumber-reports/test-report.html", // HTML report
                "json:target/cucumber-reports/test-report.json"  // JSON report
        },

        // Dry run option: Use `true` to test feature-to-step mapping without executing the tests
        dryRun = false
)

public class UiRunner extends AbstractTestNGCucumberTests {
    // No additional code is needed - the class simply runs all defined tests
}