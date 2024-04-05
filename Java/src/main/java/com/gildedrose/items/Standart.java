package src.main.java.com.gildedrose.items;

import src.main.java.com.gildedrose.Item;

import static src.main.java.com.gildedrose.Utils.*;

public class Standart implements Products {

    @Override
    public String getItemName() {
        return "";
    }

    @Override
    public void updateQuality(Item item) {
        int quality = item.quality;
        int sellIn = item.sellIn;

        if (qualityIsZero(quality)) {
            return;
        }

        if (sellInIsZeroOrQualityIsOne(sellIn, quality)) {
            item.quality = quality - ONE;
            return;
        }

        item.quality = quality - TWO;
    }

    private static boolean qualityIsZero(int quality) {
        return quality == MIN_QUALITY;
    }

    private static boolean sellInIsZeroOrQualityIsOne(int sellIn, int quality) {
        return sellIn > ZERO || quality == ONE;
    }
}
