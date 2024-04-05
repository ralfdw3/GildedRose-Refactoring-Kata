package src.main.java.com.gildedrose.items;

import src.main.java.com.gildedrose.Item;

import static src.main.java.com.gildedrose.Utils.MAX_QUALITY;
import static src.main.java.com.gildedrose.Utils.ONE;

public class AgedBrie implements Products {

    @Override
    public String getItemName() {
        return "Aged Brie";
    }

    @Override
    public void updateQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + ONE;
        }
    }
}
