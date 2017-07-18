package com.gildedrose;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class GildedRoseTest {

    private Item foo;

    private Item worstQualityItem;

    private Item bestQualityItem;

    private Item plusFiveDextryVest;
    private Item elixirOfTheMongoose;

    private Item agedBrie;

    private Item sulfurasSellin0;
    private Item sulfurasSellinMinus1;

    private Item backstagPasses1;
    private Item backstagePasses2;
    private Item backstagePasses3;

    private Item conjured;

    @Before
    public void updateQuality() {

        foo = new Item("foo", 0, 0);

        worstQualityItem = new Item("Worst Quality Item", 0, 0);

        bestQualityItem = new AgedBrieItem("Aged Brie", 0, 50);

        plusFiveDextryVest = new Item("+5 Dexterity Vest", 10, 20);
        elixirOfTheMongoose = new Item("Elixir of the Mongoose", 5, 7);

        agedBrie = new AgedBrieItem("Aged Brie", 2, 0);

        sulfurasSellin0 = new SulfurasItem("Sulfuras, Hand of Ragnaros", 0, 80);
        sulfurasSellinMinus1 = new SulfurasItem("Sulfuras, Hand of Ragnaros", -1, 80);

        backstagPasses1 = new BackstageItem("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        backstagePasses2 = new BackstageItem("Backstage passes to a TAFKAL80ETC concert", 10, 49);
        backstagePasses3 = new BackstageItem("Backstage passes to a TAFKAL80ETC concert", 5, 49);

        conjured = new ConjuredItem("Conjured Mana Cake", 5, 7);

        GildedRose app = new GildedRose(Arrays.asList(foo, worstQualityItem, bestQualityItem, plusFiveDextryVest, elixirOfTheMongoose, agedBrie,
                sulfurasSellin0, sulfurasSellinMinus1, backstagPasses1, backstagePasses2, backstagePasses3, conjured));

        app.updateQuality();
    }

    @Test
    public void testNameShouldNotChangeWhenUpdate() {

        assertThat(foo.getName(), is("foo"));
    }

    @Test
    public void testQualityIsNeverNegativeWhenUpdate() {

        assertThat(worstQualityItem.getQuality(), is(0));
    }

    @Test
    public void testQualityIsNeverMoreThanFiftyWhenUpdate() {

        assertThat(bestQualityItem.getQuality(), is(50));
    }

    @Test
    public void testNormalItemQualityShouldDecreaseByOneWhenUpdate() {

        assertThat(plusFiveDextryVest.getQuality(), is(19));

        assertThat(elixirOfTheMongoose.getQuality(), is(6));

    }

    @Test
    public void testNotSulfurasSellInShouldDecreaseByOneWhenUpdate() {

        assertThat(plusFiveDextryVest.getSellIn(), is(9));

        assertThat(elixirOfTheMongoose.getSellIn(), is(4));

    }

    @Test
    public void testAgedBrieQualityShouldIncreaseByOneWhenUpdate() {

        assertThat(agedBrie.getQuality(), is(1));
    }

    @Test
    public void testSulfurasQualityShouldNotChangeWhenUpdate() {

        assertThat(sulfurasSellin0.getQuality(), is(80));

        assertThat(sulfurasSellinMinus1.getQuality(), is(80));
    }

    @Test
    public void testSulfurasSellinShouldNotChangeWhenUpdate() {

        assertThat(sulfurasSellin0.getSellIn(), is(0));

        assertThat(sulfurasSellinMinus1.getSellIn(), is(-1));
    }

    @Test
    public void testBackstageQualityShouldIncreaseByOneWhenUpdate() {

        assertThat(backstagPasses1.getQuality(), is(21));

        assertThat(backstagePasses2.getQuality(), is(50));

        assertThat(backstagePasses3.getQuality(), is(50));
    }

    @Test
    public void testConjuredQualityShouldDecreaseTwiceAsFastAsNormalQuality() {

        assertThat(conjured.getQuality(), is(3));
    }

}
