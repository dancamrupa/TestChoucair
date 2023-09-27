package exitoStore.utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class Utilities {

    public static String getValueString(Target target, Actor actor) {
        return Text.of(target).viewedBy(actor).asString().replace(" ", "").replace("$", "").replace(".", "");
    }

    public static String getQuantity(Target target, Actor actor) {
        return Text.of(target).viewedBy(actor).asString().split(" ")[0].replace(".00", "").replace("un", "");
    }

    public static String getTotalValue(String price, String quantity) {
        return String.valueOf(Integer.parseInt(price) * Integer.parseInt(quantity));
    }
}