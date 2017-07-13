package com.gildedrose;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class GildedRoseTest {

	@Test
	public void testNameShouldNotChangeWhenUpdate() {
		Item foo = new Item("foo", 0, 0);

		updateQuality(foo);

		assertThat(foo.name, is("foo"));
	}

	@Test
	public void testCommonsQualityAndSellInShouldDecreaseByOneWhenUpdate() {
		Item plusFiveDextryVest = new Item("+5 Dexterity Vest", 10, 20);
		Item elixirOfTheMongoose = new Item("Elixir of the Mongoose", 5, 7);
		Item conjuredManaCake = new Item("Conjured Mana Cake", 3, 6);

		updateQuality(plusFiveDextryVest, elixirOfTheMongoose, conjuredManaCake);

		assertThat(plusFiveDextryVest.sellIn, is(9));
		assertThat(plusFiveDextryVest.quality, is(19));

		assertThat(elixirOfTheMongoose.sellIn, is(4));
		assertThat(elixirOfTheMongoose.quality, is(6));

		assertThat(conjuredManaCake.sellIn, is(2));
		assertThat(conjuredManaCake.quality, is(5));

	}

	@Test
	public void testAgedBrieQualityShouldIncreaseByOneAndSellInDecreaseByOneWhenUpdate() {
		Item agedBrie = new Item("Aged Brie", 2, 0);

		updateQuality(agedBrie);

		assertThat(agedBrie.sellIn, is(1));
		assertThat(agedBrie.quality, is(1));
	}

	@Test
	public void testSulfurasQualityAndSellInShouldNotChangeWhenUpdate() {
		Item sulfurasSellin0 = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
		Item sulfurasSellinMinus1 = new Item("Sulfuras, Hand of Ragnaros", -1, 80);

		updateQuality(sulfurasSellin0, sulfurasSellinMinus1);

		assertThat(sulfurasSellin0.sellIn, is(0));
		assertThat(sulfurasSellin0.quality, is(80));

		assertThat(sulfurasSellinMinus1.sellIn, is(-1));
		assertThat(sulfurasSellinMinus1.quality, is(80));
	}

	@Test
	public void testBackstageQualityShouldIncreaseByOneAndSellInDecreaseByOneWhenUpdate() {
		Item backstagPasses1 = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
		Item backstagePasses2 = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49);
		Item backstagePasses3 = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);

		updateQuality(backstagPasses1, backstagePasses2, backstagePasses3);

		assertThat(backstagPasses1.sellIn, is(14));
		assertThat(backstagPasses1.quality, is(21));

		assertThat(backstagePasses2.sellIn, is(9));
		assertThat(backstagePasses2.quality, is(50));

		assertThat(backstagePasses3.sellIn, is(4));
		assertThat(backstagePasses3.quality, is(50));
	}

	private void updateQuality(Item... items) {
		GildedRose app = new GildedRose(Arrays.asList(items));

		app.updateQuality();
	}

}
