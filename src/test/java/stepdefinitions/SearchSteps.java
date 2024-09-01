package stepdefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchSteps {
    @When("он вводит {string} в строку поиска")
    public void userEntersSearchTerm(String searchTerm) {
        $("#searchInput").setValue(searchTerm).pressEnter();
    }

    @Then("он видит товар {string} в результатах поиска")
    public void userSeesProductInSearchResults(String productName) {
        $(By.cssSelector(".searching-results__title")).shouldHave(text("Iphone 13"));
    }
}