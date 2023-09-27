package exitoStore.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ActorNotepad {

    LIST_PRODUCTS("list products"),
    LIST_CART_PRODUCTS("list cart products");

    private final String key;

}
