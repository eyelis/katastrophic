package com.gildedrose;

public class ConjuredItem extends Item {

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void decreaseQuality() {
        super.decreaseQuality();
        setQuality(getQuality() / 2);
    }

}
