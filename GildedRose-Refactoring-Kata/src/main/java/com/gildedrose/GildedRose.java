package com.gildedrose;

import java.util.List;

class GildedRose {
    private static final int MIN_SELLIN = 0;
    private static final int SELLIN_THRESHOLD_INCREASE_QUALITY_ONCE = 11;
    private static final int SELLIN_THRESHOLD_INCREASE_QUALITY_TWICE = 6;
    private static final int MAX_QUALITY = 50;
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (isAgedBrie(item)) {
                updateAgedBrie(item);
            } else if (isBackstagePasses(item)) {
                updateBackstage(item);
            } else if (!isSulfuras(item)) {
                updateOthers(item);
            }
        }
    }

    private void updateOthers(Item item) {
        if (item.quality > 0) {
            decreaseQuality(item);
        }
        decreaseSellIn(item);
        if (isSellInReached(item)) {
            decreaseQuality(item);
        }
    }

    private void updateBackstage(Item item) {
        if (isLowerThanMaxQuality(item)) {
            increaseQuality(item);
            updateBackstageQuality(item);
        }
        decreaseSellIn(item);
        if (isSellInReached(item)) {
            item.quality = 0;
        }
    }

    private void updateAgedBrie(Item item) {
        if (isLowerThanMaxQuality(item)) {
            increaseQuality(item);
        }
        decreaseSellIn(item);
        if (isSellInReached(item) && isLowerThanMaxQuality(item)) {
            increaseQuality(item);
        }
    }

    private boolean isSellInReached(Item item) {
        return item.sellIn < MIN_SELLIN;
    }

    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    private void updateBackstageQuality(Item item) {
        if (isLowerThanMaxQuality(item)) {
            if (item.sellIn < SELLIN_THRESHOLD_INCREASE_QUALITY_ONCE) {
                increaseQuality(item);
            }

            if (item.sellIn < SELLIN_THRESHOLD_INCREASE_QUALITY_TWICE) {
                increaseQuality(item);
            }
        }
    }

    private boolean isSulfuras(Item item) {
        return SULFURAS.equals(item.name);
    }

    private boolean isLowerThanMaxQuality(Item item) {
        return item.quality < MAX_QUALITY;
    }

    private boolean isBackstagePasses(Item item) {
        return BACKSTAGE_PASSES.equals(item.name);
    }

    private boolean isAgedBrie(Item item) {
        return AGED_BRIE.equals(item.name);
    }

    private int decreaseQuality(Item item) {
        return item.quality--;
    }

    private int increaseQuality(Item item) {
        return item.quality++;
    }
}