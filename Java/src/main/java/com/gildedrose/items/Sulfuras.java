package src.main.java.com.gildedrose.items;

import src.main.java.com.gildedrose.Item;

import static src.main.java.com.gildedrose.Utils.*;

public class Sulfuras implements Products {

    @Override
    public String getItemName() {
        return "Sulfuras, Hand of Ragnaros";
    }

    @Override
    public void updateQuality(Item item) {
        item.quality = SULFURAS_MAX_QUALITY;
    }
}
