package com.gildedrose;

import java.util.List;

class GildedRose {

    private List<Updatable> items;

    public List<Updatable> getItems() {
        return items;
    }

    public GildedRose(List<Updatable> items) {
        this.items = items;
    }

    public void updateQuality() {
        items.forEach(item -> item.update());
    }

}