
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
        Item item = new Item(name, sellIn, quality);
        item.endOfDayUpdate();
        Assertions.assertEquals(sellInAfterUpdate, item.getSellIn());
    }

    @Test
    public void ItemSulfurasSellInDoesntChange(){
        String name = "Sulfuras";
        int sellIn = 1;
        int quality = 80;
        Item item = new Item(name, sellIn, quality);
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
        Item item = new Item(name, sellIn, quality);
        item.endOfDayUpdate();
        Assertions.assertEquals(qualityAfterUpdate, item.getQuality());
    }

    @Test
    public void QualityDegradesTwiceAsFastIfSellInIsNegative(){
        String name = "foo";
        int sellIn = -1;
        int quality = 10;
        int qualityAfterUpdate = quality - 2;
        Item item = new Item(name, sellIn, quality);
        item.endOfDayUpdate();
        Assertions.assertEquals(qualityAfterUpdate, item.getQuality());
    }


    @Test
    public void AgedBrieQualityIncreases(){
        String name = "Aged Brie";
        int sellIn = 30;
        int quality = 30;
        int qualityAfterUpdate = quality + 1;
        Item item = new Item(name, sellIn, quality);
        item.endOfDayUpdate();
        Assertions.assertEquals(qualityAfterUpdate, item.getQuality());
    }

    @Test
    public void sulfurasQualityIs80(){
        String name = "Sulfuras";
        int sellIn = 30;
        int quality = 0;
        int qualityAfterUpdate = 80;
        Item item = new Item(name, sellIn, quality);
        item.endOfDayUpdate();
        Assertions.assertEquals(qualityAfterUpdate, item.getQuality());
    }

    @Test
    public void backstagePassQualityIncreases(){
        String name = "Backstage Passes";
        int sellIn = 20;
        int quality = 30;
        int qualityAfterUpdate = quality + 1;
        Item item = new Item(name, sellIn, quality);
        item.endOfDayUpdate();
        Assertions.assertEquals(qualityAfterUpdate, item.getQuality());
    }

    @Test
    public void backstagePassesSellIn10OrLessQualityIncreaseBy2(){
        String name = "Backstage Passes";
        int sellIn = 10;
        int quality = 30;
        int qualityAfterUpdate = quality + 2;
        Item item = new Item(name, sellIn, quality);
        item.endOfDayUpdate();
        Assertions.assertEquals(qualityAfterUpdate, item.getQuality());
    }

    @Test
    public void backStagePassesSellIn5OrLessQualityIncreaseBy3(){
        String name = "Backstage Passes";
        int sellIn = 5;
        int quality = 30;
        int qualityAfterUpdate = quality + 3;
        Item item = new Item(name, sellIn, quality);
        item.endOfDayUpdate();
        Assertions.assertEquals(qualityAfterUpdate, item.getQuality());
    }

    @Test
    public void backstagePassesSellInIs0QualityIs0(){
        String name = "Backstage Passes";
        int sellIn = 1;
        int quality = 50;
        int qualityAfterUpdate = 0;
        Item item = new Item(name, sellIn, quality);
        item.endOfDayUpdate();
        Assertions.assertEquals(qualityAfterUpdate, item.getQuality());
    }

    @Test
    public void conjuredQualityDecreasesTwiceAsFast(){
        String name = "Conjured";
        int sellIn = 15;
        int quality = 50;
        int qualityAfterUpdate = quality - 2;
        Item item = new Item(name, sellIn, quality);
        item.endOfDayUpdate();
        Assertions.assertEquals(qualityAfterUpdate, item.getQuality());
    }

    @Test
    public void itemIsNotSulfurasQualityNoGreaterThan50(){
        String name = "Aged Brie";
        int sellIn = 5;
        int quality = 50;
        int qualityAfterUpdate = 50;
        Item agedBrie = new Item(name, sellIn, quality);
        int sulfurasSellin = 1;
        int sulfurasQuality = 80;
        int sulfurasQualityAfterUpdate = 80;
        Item sulfuras = new Item("Sulfuras", sulfurasSellin,sulfurasQuality);
        sulfuras.endOfDayUpdate();
        Assertions.assertEquals(qualityAfterUpdate, agedBrie.getQuality());
        Assertions.assertEquals(sulfurasQualityAfterUpdate, sulfuras.getQuality());
    }

    //App Runner Tests
    @Test
    public void itemsCanBeAddedToTheList(){
        GildedRoseAppRunner gildedRoseAppRunner = new GildedRoseAppRunner();
        String name = Item.AGED_BRIE;
        int sellIn = 60;
        int quality = 30;
        gildedRoseAppRunner.addItem(name,sellIn,quality);
        Assertions.assertEquals(1, gildedRoseAppRunner.getItems().size());
    }

    @Test
    public void endOfDayUpdatesAllItemsInList(){
        GildedRoseAppRunner gildedRoseAppRunner2 = new GildedRoseAppRunner();
        gildedRoseAppRunner2.addItem(Item.AGED_BRIE,60,30);
        gildedRoseAppRunner2.addItem(Item.SULFURAS,1,80);
        gildedRoseAppRunner2.addItem(Item.BACKSTAGE_PASSES,20,30);
        int numberUpdatedToBeUpdated = 3;
        gildedRoseAppRunner2.printItems();
        int numberUpdated = gildedRoseAppRunner2.endOfDayUpdate();
        gildedRoseAppRunner2.printItems();
        Assertions.assertEquals(numberUpdatedToBeUpdated,numberUpdated);
    }
}

