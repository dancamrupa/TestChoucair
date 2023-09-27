package exitoStore.userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class CarProductInformation {

    public static final Target EMAIL = Target.the("emal")
            .locatedBy("//input[@name='email']");
    public static final Target PRODUCT_NAME_CAR = Target.the("Product name car")
            .locatedBy("//div[@class='exito-checkout-io-0-x-sellerListContainer']//span[@data-molecule-product-detail-name-span]");
    public static final Target CART_PRICE = Target.the("Cart price")
            .locatedBy("//div[@class='exito-checkout-io-0-x-sellerListContainer']//div[@data-molecule-product-detail-price-best-price]");
    public static final Target TOTAL_UNITS = Target.the("Total units")
            .locatedBy("//span[@data-molecule-quantity-und-value]");
}
