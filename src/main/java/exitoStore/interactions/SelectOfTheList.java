package exitoStore.interactions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

import static exitoStore.userInterface.SelectProduct.ADD_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class SelectOfTheList implements Interaction {

    private static List<Integer> indicesSeleccionados = new ArrayList<>();

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<WebElementFacade> elementos = ADD_BUTTON.resolveAllFor(actor);

        if (!elementos.isEmpty()) {
            WaitUntil.the(ADD_BUTTON, isPresent());
            Random random = new Random();
            int indiceAleatorio;

            do {
                indiceAleatorio = random.nextInt(elementos.size());
            } while (indicesSeleccionados.contains(indiceAleatorio));

            WebElement elementoAleatorio = elementos.get(indiceAleatorio);
            WebDriver driver = Serenity.getWebdriverManager().getWebdriver();

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", elementoAleatorio);
            elementoAleatorio.click();
            indicesSeleccionados.add(indiceAleatorio);

        } else {
            System.out.println("No se encontraron elementos en la página.");
        }
    }

    public static Performable ofThePage() {
        return instrumented(SelectOfTheList.class);
    }
}