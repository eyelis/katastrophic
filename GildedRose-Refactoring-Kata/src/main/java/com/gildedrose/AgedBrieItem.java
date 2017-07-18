package com.gildedrose;

public class AgedBrieItem extends Item {

    public AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        decreaseSellIn();

        increaseQuality();

        if (isSellInReached()) {
            increaseQuality();
        }
    }

}