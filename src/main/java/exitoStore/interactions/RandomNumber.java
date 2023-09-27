package exitoStore.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;

import java.util.Random;

import static exitoStore.userInterface.SelectProduct.PRODUCT_QUANTITY;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RandomNumber implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {

        Random random = new Random();
        int numeroAleatorio = random.nextInt(9);

        for (int i = 0; i < numeroAleatorio; i++) {
            actor.attemptsTo(
                    Click.on(PRODUCT_QUANTITY)
            );
        }
    }

    public static Performable toChoose() {
        return instrumented(RandomNumber.class);
    }
}
