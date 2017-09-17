package com.gildedrose;

public class ConjuredItem extends Item {

    public ConjuredItem(int sellIn, int quality) {
        super("Conjured Mana Cake", sellIn, quality);
    }

    @Override
    protected void decreaseQuality() {
        super.decreaseQuality();
        setQuality(getQuality() / 2);
    }

}
