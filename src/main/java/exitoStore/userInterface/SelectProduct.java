package exitoStore.userInterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SelectProduct {

    public static final Target CLOSE_WINDOW = Target.the("Close Window")
            .located(By.id("wps-overlay-close-button"));
    public static final Target MENU = Target.the("Menu")
            .located(By.id("category-menu"));
    public static final Target BEDROOMS = Target.the("Technology")
            .located(By.id("undefined-nivel2-Dormitorio"));
    public static final Target HEADBOARDS = Target.the("Tv")
            .located(By.id("Categorías-nivel3-Cabeceros"));
    public static final Target ADD_BUTTON = Target.the("Quick purchase")
            .locatedBy ("//*[@class='exito-vtex-components-4-x-buyButton productSummaryBuyButtonProductRich']");
    public static final Target ADD_PRODUCT = Target.the("Add product")
            .locatedBy("//span[contains(text(),'Agregar')]");
    public static final Target PRODUCT_QUANTITY = Target.the("Add product")
            .locatedBy("//span[@class='product-details-exito-vtex-components-buy-button-manager-more']");
    public static final Target CLOSE_WINDOWS = Target.the("Add product")
            .locatedBy("//span[@class='exito-vtex-components-4-x-defaultModalClose']");
    public static final Target PRODUCT_NAME = Target.the("Add product")
            .locatedBy("(//span[@class='vtex-store-link-0-x-label vtex-store-link-0-x-label--link-to-pdp']/following::span)[2]");
    public static final Target PRICE_PRODUCT = Target.the("Add product")
            .locatedBy("(//span[@class='vtex-store-link-0-x-label vtex-store-link-0-x-label--link-to-pdp']/following::span)[4]");
    public static final Target QUANTITY = Target.the("Add product")
            .locatedBy("//div[@class='exito-vtex-components-4-x-stepperContainerQty']");
    public static final Target SHOPPING_CART = Target.the("Add product")
            .locatedBy("//div[@class='exito-header-3-x-minicartContainer ']");
}