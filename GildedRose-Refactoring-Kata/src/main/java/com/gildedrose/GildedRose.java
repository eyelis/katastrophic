package com.gildedrose;

import java.util.List;

class GildedRose {

    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        items.forEach(item -> item.update());
    }

}