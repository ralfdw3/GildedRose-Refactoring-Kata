package src.main.java.com.gildedrose.items;

import src.main.java.com.gildedrose.Item;

import java.util.Objects;

public interface Products {
    String getItemName();
    void updateQuality(Item item);
    static void updateSellIn(Item item) {
        if (!Objects.equals(item.name, "Sulfuras, Hand of Ragnaros")) {
            item.sellIn -= 1;
        }
    }
}
