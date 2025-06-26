package com.example;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {
                "pretty",   // Output readable
                "html:target/cucumber-report.html" //Report HTML
        },
//        glue = {"org.example.hooks", "com.example.stepDefinitions"}, // glue for test case UI Automation
        glue = {"com.example.stepDefinitions"}, // glue for test case API Automation
        monochrome = true, // Output clean di console
        stepNotifications = true,
        tags = "@APIFeature" // Jalankan tag tertentu (opsional)
        //dryRun = false // true = check mapping step, tidak dijalankan

)

public class CucumberRunner {
}
