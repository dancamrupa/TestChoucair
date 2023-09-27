package exitoStore.stepdefinitions;

import exitoStore.tasks.validationProducts;
import exitoStore.tasks.SelectProductRandom;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;

import static exitoStore.utils.enums.Url.URL_EXITO;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class SelectProductStepDefinitions {

    @Given("The user enters the online page of Exito")
    public void theUserEntersTheOnlinePageOfExito() {
        OnStage.theActorCalled("CamiloRuiz").attemptsTo(
                Open.url(URL_EXITO.getKey())
        );
    }

    @When("the user chooses {int} products randomly")
    public void theUserChoosesProductsRandomly(int quantity) {
        theActorCalled("Camilo Ruiz").attemptsTo(SelectProductRandom.onPage(quantity)
        );
    }

    @Then("The user will be able to validate the products selected in the shopping cart")
    public void TheUserWillBeAbleToValidateTheProductsSelectedInTheShoppingCart() {
        theActorCalled("Camilo Ruiz").attemptsTo(validationProducts.ofPage()
        );
    }
}