package co.com.client.webproject.test.runners.cart;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/main/resources/features/shoppingcart/shoppingCart.feature"},
        glue = {"co.com.client.webproject.test.stepdefinition.shoppingcart"},
        tags = "",
        publish = true
)

public class ShoppingCartTest {
}
