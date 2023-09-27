package exitoStore.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;

import java.util.ArrayList;
import java.util.List;

import static exitoStore.userInterface.SelectProduct.*;
import static exitoStore.utils.Utilities.*;
import static exitoStore.utils.enums.ActorNotepad.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ChooseProducts implements Interaction {

    private final int quantity;

    public ChooseProducts(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<List<String>> productList = new ArrayList<>();

        for (int i = 0; i < quantity; ++i) {

            List<String> productValues = new ArrayList<>();

            actor.attemptsTo(
                    SelectOfTheList.ofThePage(),
                    Click.on(ADD_PRODUCT),
                    RandomNumber.toChoose()
            );

            productValues.add(PRODUCT_NAME.resolveFor(actor).getText());
            productValues.add(getValueString(PRICE_PRODUCT, actor));
            productValues.add(getQuantity(QUANTITY, actor));
            productValues.add(getTotalValue(productValues.get(1), productValues.get(2)));

            actor.attemptsTo(
                    Click.on(CLOSE_WINDOWS)
            );
            productList.add(productValues);
        }
        actor.remember(LIST_PRODUCTS.getKey(), productList);
    }

    public static Performable toChoose(int quantity) {
        return instrumented(ChooseProducts.class, quantity);
    }
}