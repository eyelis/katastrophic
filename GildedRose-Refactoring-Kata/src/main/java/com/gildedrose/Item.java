package com.gildedrose;

public class Item implements Updatable {

    private static final int MIN_QUALITY = 0;

    private static final int MAX_QUALITY = 50;

    private static final int MIN_SELLIN = 0;

    private String name;

    private int sellIn;

    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void update() {
        decreaseSellIn();

        decreaseQuality();

        if (isSellInReached()) {
            decreaseQuality();
        }
    }

    protected void decreaseQuality() {
        if (quality > MIN_QUALITY) {
            quality--;
        }
    }

    protected void increaseQuality() {
        if (isLowerThanMaxQuality()) {
            quality++;
        }
    }

    protected void decreaseSellIn() {
        sellIn--;
    }

    protected boolean isLowerThanMaxQuality() {
        return quality < MAX_QUALITY;
    }

    protected boolean isSellInReached() {
        return sellIn < MIN_SELLIN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

}
