package Test;

import Main.*;
import Main.Items.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests {

    //Item Tests
    @Test
    public void itemCreateHasCorrectValues(){
        String name = "Aged Brie";
        int sellIn = 10;
        int quality = 40;
        Item item = new Item(name, sellIn, quality);

        Assertions.assertEquals(name, item.getName());
        Assertions.assertEquals(sellIn, item.getSellIn());
        Assertions.assertEquals(quality, item.getQuality());
    }

    //SellIn Tests
    @Test
    public void sellInDepreciatesByOneOnEndOfDayUpdate(){
        String name = "Aged Brie";
        int sellIn = 10;
        int quality = 40;
        int sellInAfterUpdate = sellIn - 1;
        AgedBrieItem item = new AgedBrieItem(name, sellIn, quality);
        item.endOfDayUpdate();
        Assertions.assertEquals(sellInAfterUpdate, item.getSellIn());
    }

    @Test
    public void ItemSulfurasSellInDoesntChange(){
        String name = "Sulfuras";
        int sellIn = 1;
        int quality = 80;
        SulfurasItem item = new SulfurasItem(name, sellIn, quality);
        item.endOfDayUpdate();
        Assertions.assertEquals(sellIn, item.getSellIn());
    }

    //Quality Tests
    @Test
    public void QualityOfNormalItemDepreciatesByOneEveryDay(){
        String name = "foo";
        int sellIn = 30;
        int quality = 30;
        int qualityAfterUpdate = quality - 1;
        NormalItem item = new NormalItem(name, sellIn, quality);
        item.endOfDayUpdate();
        Assertions.assertEquals(qualityAfterUpdate, item.getQuality());
    }

    @Test
    public void QualityDegradesTwiceAsFastIfSellInIsNegative(){
        String name = "foo";
        int sellIn = -1;
        int quality = 10;
        int qualityAfterUpdate = quality - 2;
        NormalItem item = new NormalItem(name, sellIn, quality);
        item.endOfDayUpdate();
        Assertions.assertEquals(qualityAfterUpdate, item.getQuality());
    }


    @Test
    public void AgedBrieQualityIncreases(){
        String name = "Aged Brie";
        int sellIn = 30;
        int quality = 30;
        int qualityAfterUpdate = quality + 1;
        AgedBrieItem item = new AgedBrieItem(name, sellIn, quality);
        item.endOfDayUpdate();
        Assertions.assertEquals(qualityAfterUpdate, item.getQuality());
    }

    @Test
    public void sulfurasQualityIs80(){
        String name = "Sulfuras";
        int sellIn = 30;
        int quality = 0;
        int qualityAfterUpdate = 80;
        SulfurasItem item = new SulfurasItem(name, sellIn, quality);
        item.endOfDayUpdate();
        Assertions.assertEquals(qualityAfterUpdate, item.getQuality());
    }

    @Test
    public void backstagePassQualityIncreases(){
        String name = "Backstage Passes";
        int sellIn = 20;
        int quality = 30;
        int qualityAfterUpdate = quality + 1;
        BackStagePassesItem item = new BackStagePassesItem(name, sellIn, quality);
        item.endOfDayUpdate();
        Assertions.assertEquals(qualityAfterUpdate, item.getQuality());
    }

    @Test
    public void backstagePassesSellIn10OrLessQualityIncreaseBy2(){
        String name = "Backstage Passes";
        int sellIn = 10;
        int quality = 30;
        int qualityAfterUpdate = quality + 2;
        BackStagePassesItem item = new BackStagePassesItem(name, sellIn, quality);
        item.endOfDayUpdate();
        Assertions.assertEquals(qualityAfterUpdate, item.getQuality());
    }

    @Test
    public void backStagePassesSellIn5OrLessQualityIncreaseBy3(){
        String name = "Backstage Passes";
        int sellIn = 5;
        int quality = 30;
        int qualityAfterUpdate = quality + 3;
        BackStagePassesItem item = new BackStagePassesItem(name, sellIn, quality);
        item.endOfDayUpdate();
        Assertions.assertEquals(qualityAfterUpdate, item.getQuality());
    }

    @Test
    public void backstagePassesSellInIs0QualityIs0(){
        String name = "Backstage Passes";
        int sellIn = 1;
        int quality = 50;
        int qualityAfterUpdate = 0;
        BackStagePassesItem item = new BackStagePassesItem(name, sellIn, quality);
        item.endOfDayUpdate();
        Assertions.assertEquals(qualityAfterUpdate, item.getQuality());
    }

    @Test
    public void conjuredQualityDecreasesTwiceAsFast(){
        String name = "Conjured";
        int sellIn = 15;
        int quality = 50;
        int qualityAfterUpdate = quality - 2;
        ConjuredItem item = new ConjuredItem(name, sellIn, quality);
        item.endOfDayUpdate();
        Assertions.assertEquals(qualityAfterUpdate, item.getQuality());
    }

    @Test
    public void itemIsNotSulfurasQualityNoGreaterThan50(){
        String name = "Aged Brie";
        int sellIn = 5;
        int quality = 50;
        int qualityAfterUpdate = 50;
        AgedBrieItem agedBrie = new AgedBrieItem(name, sellIn, quality);
        int sulfurasSellin = 1;
        int sulfurasQuality = 80;
        int sulfurasQualityAfterUpdate = 80;
        SulfurasItem sulfuras = new SulfurasItem("Sulfuras", sulfurasSellin,sulfurasQuality);
        sulfuras.endOfDayUpdate();
        Assertions.assertEquals(qualityAfterUpdate, agedBrie.getQuality());
        Assertions.assertEquals(sulfurasQualityAfterUpdate, sulfuras.getQuality());
    }

    //App Runner Tests
    @Test
    public void itemsCanBeAddedToTheList(){
        GildedRoseApp gildedRoseApp = new GildedRoseApp();
        String name = Item.AGED_BRIE;
        int sellIn = 60;
        int quality = 30;
        AgedBrieItem agedBrieItem = new AgedBrieItem(name,sellIn,quality);
        gildedRoseApp.addItemToList(agedBrieItem);
        Assertions.assertEquals(1,gildedRoseApp.getItems().size());
    }

    @Test
    public void endOfDayUpdatesAllItemsInList(){
        GildedRoseApp gildedRoseApp2 = new GildedRoseApp();
        AgedBrieItem agedBrieItem = new AgedBrieItem(Item.AGED_BRIE,60,30);
        SulfurasItem sulfurasItem = new SulfurasItem(Item.SULFURAS,1,80);
        BackStagePassesItem backStagePassesItem = new BackStagePassesItem(Item.BACKSTAGE_PASSES,20,30);
        gildedRoseApp2.addItemToList(agedBrieItem,sulfurasItem,backStagePassesItem);
        int numberUpdatedToBeUpdated = 3;
        Assertions.assertEquals(numberUpdatedToBeUpdated,gildedRoseApp2.endOfDayUpdate());
    }
}

