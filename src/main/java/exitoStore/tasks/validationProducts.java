package exitoStore.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.Keys;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static exitoStore.userInterface.CarProductInformation.*;
import static exitoStore.utils.enums.ActorNotepad.*;

public class validationProducts implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<List<String>> listProducts = actor.recall(LIST_PRODUCTS.getKey());

        actor.attemptsTo(
                Enter.theValue("te324340@gmail.com").into(EMAIL).thenHit(Keys.ENTER)
        );

        for (int i = 0; i < listProducts.size(); i++) {

            Set<String> preciosProductos = Collections.singleton(CART_PRICE.resolveAllFor(actor).get(i).getText().replace(" ", "").replace("$", "").replace(".", ""));

            Ensure.that(listProducts.get(i)).isEqualTo(Collections.singleton(PRODUCT_NAME_CAR.resolveAllFor(actor).get(i).getText()));
            Ensure.that(listProducts.get(i)).isEqualTo(preciosProductos);
            Ensure.that(listProducts.size()).isEqualTo(PRODUCT_NAME_CAR.resolveAllFor(actor).size());
            Ensure.that(listProducts.get(i)).isEqualTo(Collections.singleton(TOTAL_UNITS.resolveAllFor(actor).get(i).getText()));
        }
    }

    public static validationProducts ofPage() {
        return Instrumented.instanceOf(validationProducts.class).withProperties();
    }
}