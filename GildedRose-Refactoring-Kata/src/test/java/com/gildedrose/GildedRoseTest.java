package com.gildedrose;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class GildedRoseTest {

	@Test
	public void foo() {
		List<Item> items = Arrays.asList(new Item("foo", 0, 0));
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("foo", app.getItems().get(0).name);
	}

	@Test
	public void testCommonsQualityAndSellInShouldDecreaseByOneWhenUpdate() {
		List<Item> items = Arrays.asList(new Item("+5 Dexterity Vest", 10, 20),
				new Item("Elixir of the Mongoose", 5, 7), new Item("Conjured Mana Cake", 3, 6));
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(9, app.getItems().get(0).sellIn);
		assertEquals(19, app.getItems().get(0).quality);
		assertEquals(4, app.getItems().get(1).sellIn);
		assertEquals(6, app.getItems().get(1).quality);
		assertEquals(2, app.getItems().get(2).sellIn);
		assertEquals(5, app.getItems().get(2).quality);
	}

	@Test
	public void testAgedBrieQualityShouldIncreaseByOneAndSellInDecreaseByOneWhenUpdate() {
		List<Item> items = Arrays.asList(new Item("Aged Brie", 2, 0));
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(1, app.getItems().get(0).sellIn);
		assertEquals(1, app.getItems().get(0).quality);
	}

	@Test
	public void testSulfurasQualityAndSellInShouldNotChangeWhenUpdate() {
		List<Item> items = Arrays.asList(new Item("Sulfuras, Hand of Ragnaros", 0, 80),
				new Item("Sulfuras, Hand of Ragnaros", -1, 80));
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(0, app.getItems().get(0).sellIn);
		assertEquals(80, app.getItems().get(0).quality);
		assertEquals(-1, app.getItems().get(1).sellIn);
		assertEquals(80, app.getItems().get(1).quality);
	}

	@Test
	public void testBackstageQualityShouldIncreaseByOneAndSellInDecreaseByOneWhenUpdate() {
		List<Item> items = Arrays.asList(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49));
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(14, app.getItems().get(0).sellIn);
		assertEquals(21, app.getItems().get(0).quality);
		assertEquals(9, app.getItems().get(1).sellIn);
		assertEquals(50, app.getItems().get(1).quality);
		assertEquals(4, app.getItems().get(2).sellIn);
		assertEquals(50, app.getItems().get(2).quality);
	}

}
