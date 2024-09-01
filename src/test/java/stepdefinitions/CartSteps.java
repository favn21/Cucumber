package stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartSteps {

    @Given("пользователь нашел товар {string}")
    public void userFoundProduct(String productName) {
        Selenide.open("https://www.wildberries.ru/");
        $("#searchInput").setValue(productName).pressEnter();
        $(By.cssSelector(".searching-results__title")).shouldHave(text("Iphone 13"));
        $$(".product-card").first().scrollTo();
    }

    @When("он добавляет товар в корзину")
    public void userAddsProductToCart() {
        $(".product-card__add-basket.j-add-to-basket.btn-main").click();
    }

    @Then("в его корзине находится товар {string}")
    public void productIsInCart(String productName) {
        $(".navbar-pc__icon--basket").scrollTo().click();
        SelenideElement cartProduct = $$(".good-info__good-name")
                .findBy(Condition.text(productName));
        assertTrue(cartProduct.exists());
    }

}
