package src.main.java.com.gildedrose.items;

import src.main.java.com.gildedrose.Item;

import static src.main.java.com.gildedrose.Utils.*;

public class BackstagePasses implements Products {


    @Override
    public String getItemName() {
        return "Backstage passes to a TAFKAL80ETC concert";
    }

    @Override
    public void updateQuality(Item item) {
        if (item.sellIn == ZERO) {
            item.quality = MIN_QUALITY;
        } else if (betweenZeroAndFive(item.sellIn)) {
            item.quality = item.quality + THREE;
        } else if (betweenFireAndTen(item.sellIn)) {
            item.quality = item.quality + TWO;
        }
    }

    private static boolean betweenZeroAndFive(int sellIn) {
        return sellIn > ZERO && sellIn <= 5;
    }
    private static boolean betweenFireAndTen(int sellIn) {
        return sellIn > 5 && sellIn <= 10;
    }
}
