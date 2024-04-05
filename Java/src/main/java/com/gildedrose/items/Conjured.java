package src.main.java.com.gildedrose.items;

import src.main.java.com.gildedrose.Item;

import static src.main.java.com.gildedrose.Utils.*;

public class Conjured implements Products {

    @Override
    public String getItemName() {
        return "Conjured";
    }

    @Override
    public void updateQuality(Item item) {
        int quality = item.quality;
        int sellIn = item.sellIn;

        if (qualityIsZero(quality)) {
            return;
        }

        if (sellInIsZeroOrQualityIsOne(sellIn, quality)) {
            item.quality = quality - TWO;
            return;
        }

        item.quality = quality - FOUR;
    }

    private static boolean qualityIsZero(int quality) {
        return quality == MIN_QUALITY;
    }

    private static boolean sellInIsZeroOrQualityIsOne(int sellIn, int quality) {
        return sellIn > ZERO || quality == ONE;
    }
}
