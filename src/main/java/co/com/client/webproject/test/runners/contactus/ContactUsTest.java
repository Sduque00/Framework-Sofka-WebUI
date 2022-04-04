package co.com.client.webproject.test.runners.contactus;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/main/resources/features/contactus/contactus.feature"},
        glue = {"co.com.client.webproject.test.stepdefinition.contactus"},
        tags = "",
        publish = true
)

public class ContactUsTest {
}
