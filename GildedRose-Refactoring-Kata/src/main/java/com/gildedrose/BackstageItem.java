package com.gildedrose;

public class BackstageItem extends Item {

	private static final int SELLIN_THRESHOLD_INCREASE_QUALITY_ONCE = 11;
	private static final int SELLIN_THRESHOLD_INCREASE_QUALITY_TWICE = 6;

	public BackstageItem(int sellIn, int quality) {
		super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
	}

	@Override
	public void update() {
		increaseQuality();

		updateBackstageQuality();

		decreaseSellIn();

		if (isSellInReached()) {
			setQuality(0);
		}
	}

	private void updateBackstageQuality() {
		if (getSellIn() < SELLIN_THRESHOLD_INCREASE_QUALITY_ONCE) {
			increaseQuality();
		}

		if (getSellIn() < SELLIN_THRESHOLD_INCREASE_QUALITY_TWICE) {
			increaseQuality();
		}
	}

}
