package exitoStore.tasks;

import exitoStore.interactions.ChooseProducts;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static exitoStore.userInterface.SelectProduct.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class SelectProductRandom implements Task {

    private final int quantity;

    public SelectProductRandom(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CLOSE_WINDOW),
                WaitUntil.the(MENU, isPresent()),
                Click.on(MENU),
                Click.on(BEDROOMS),
                Click.on(HEADBOARDS),
                WaitUntil.the(ADD_BUTTON, isPresent()),
                ChooseProducts.toChoose(quantity),
                Click.on(SHOPPING_CART)
        );
    }

    public static SelectProductRandom onPage(int quantity) {
        return Instrumented.instanceOf(SelectProductRandom.class).withProperties(quantity);
    }
}