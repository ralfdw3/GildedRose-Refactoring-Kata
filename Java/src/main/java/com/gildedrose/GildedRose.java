package src.main.java.com.gildedrose;

import src.main.java.com.gildedrose.items.*;

import java.util.List;
import java.util.Objects;

import static src.main.java.com.gildedrose.Utils.*;
import static src.main.java.com.gildedrose.Utils.CONJURED;
import static src.main.java.com.gildedrose.items.Products.updateSellIn;

public class GildedRose {
    public Item[] items;
    private static final List<Class<?>> classes = List.of(AgedBrie.class, Sulfuras.class, BackstagePasses.class, Conjured.class);


    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() throws Exception {
        for (Item item : items) {
            for (Class<?> clazz : classes) {
                Object instance = clazz.getDeclaredConstructor().newInstance();
                String itemName = (String) clazz.getDeclaredMethod(METHOD_GET_ITEM_NAME).invoke(instance);

                if (itemIsOfThisClazz(item, itemName) || isConjuredItem(item, itemName)) {
                    clazz.getDeclaredMethod(METHOD_UPDATE_QUALITY, Item.class).invoke(instance, item);
                    updateSellIn(item);
                    return;
                }
            }
            Standart standart = new Standart();
            standart.updateQuality(item);
            updateSellIn(item);
        }
    }

    private static boolean itemIsOfThisClazz(Item item, String itemName) {
        return Objects.equals(item.name, itemName);
    }

    private static boolean isConjuredItem(Item item, String itemName) {
        return item.name.startsWith(CONJURED) && itemName.startsWith(CONJURED);
    }
}
