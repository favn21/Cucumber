package stepdefinitions;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Selenide.*;

public class BrowseSteps {

    @When("он переходит в категорию {string}")
    public void userNavigatesToCategory(String category) {
        $("button.nav-element__burger.j-menu-burger-btn.j-wba-header-item")
          .shouldBe(Condition.visible)
                .click();
        $x("//span[contains(@class, 'menu-burger__main-list-link') and text()='" + category + "']")
                .shouldBe(Condition.visible)
                .click();
    }

    @Then("он видит список товаров этой категории")
    public void userSeesProductList() {
        $$("div.product-card__wrapper")
                .shouldHave(CollectionCondition.sizeGreaterThan(0));
    }
}
