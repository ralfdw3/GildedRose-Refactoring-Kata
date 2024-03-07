package src.test.java.com.gildedrose;

import org.junit.jupiter.api.Test;
import src.main.java.com.gildedrose.GildedRose;
import src.main.java.com.gildedrose.Item;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] {
            new Item("foo", 0, 0)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

}
