package src.test.java.com.gildedrose;

import org.junit.jupiter.api.Test;
import src.main.java.com.gildedrose.GildedRose;
import src.main.java.com.gildedrose.Item;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void conjured_shouldLoseTwoPointsOfQualityEveryDay() throws Exception {
        Item[] items = new Item[] {
            new Item("Conjured Mana Cake", 10, 30)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(28, app.items[0].quality);
    }

    @Test
    void conjured_shouldLoseFourPointsOfQualityEveryDayAfterTheSellIn() throws Exception {
        Item[] items = new Item[] {
            new Item("Conjured Mana Cake", 0, 30)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(26, app.items[0].quality);
    }

    @Test
    void agedBrie_shouldGainOnePointOfQualityEveryDayAfterTheSellIn() throws Exception {
        Item[] items = new Item[] {
            new Item("Aged Brie", 10, 30)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(31, app.items[0].quality);
    }

    @Test
    void agedBrie_shouldNotGainQualityAfterFiftyPoints() throws Exception {
        Item[] items = new Item[] {
            new Item("Aged Brie", 10, 50)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void sulfurasHandOfRagnaros_qualityAndSellInAreImmutable() throws Exception {
        Item[] items = new Item[] {
            new Item("Sulfuras, Hand of Ragnaros", 10, 80)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(10, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void backstagePasses_shouldGainTwoPointsOfQualityWhenTheSellInIs10() throws Exception {
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(22, app.items[0].quality);
    }

    @Test
    void backstagePasses_shouldGainThreePointsOfQualityWhenTheSellInIs5() throws Exception {
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(4, app.items[0].sellIn);
        assertEquals(23, app.items[0].quality);
    }

    @Test
    void backstagePasses_shouldLoseAllQualityPointsWhenSellInIsZero() throws Exception {
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
}
