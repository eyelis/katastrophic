package com.gildedrose;

public class SulfurasItem extends Item {

    public SulfurasItem(int sellIn, int quality) {
        super("Sulfuras, Hand of Ragnaros", sellIn, quality);
    }

    @Override
    public void update() {
        // Sulfuras quality should not changed when sellin decrease
    }

}
