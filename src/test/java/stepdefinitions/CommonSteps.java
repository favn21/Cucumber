package stepdefinitions;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;
import org.example.WebDriverConfig;

public class CommonSteps {

    @Given("пользователь на главной странице магазина")
    public void userOnHomePage() {
        WebDriverConfig.setUp();
        Selenide.open("https://www.wildberries.ru/");
    }
}
