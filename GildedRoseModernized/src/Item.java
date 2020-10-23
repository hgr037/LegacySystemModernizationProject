public class Item {
    public static final String SULFURAS = "Sulfuras";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage Passes";
    public static final String CONJURED = "Conjured";
    private String name;
    private int sellIn;
    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void endOfDayUpdate() {
        switch (name){
            case SULFURAS:
                handleSulfurasItem();
                break;
            case AGED_BRIE:
                handleAgedBrieItem();
                break;
            case BACKSTAGE_PASSES:
                handleBackstagePassesItem();
                break;
            case CONJURED:
                handleConjuredItem();
                break;
            default:
                handleNormalItem();
        }
    }

    private void handleNormalItem() {
        sellIn--;
        if (quality > 0) {
            if(sellIn > 0){
                quality--;
            } else quality -=2;
        }
    }

    private void handleConjuredItem() {
        sellIn--;
        if (quality > 1) {
            if (sellIn > 0) {
                quality -= 2;
            } else quality -= 4;
        } else quality = 0;
    }

    private void handleBackstagePassesItem() {
        sellIn--;
        if(sellIn <= 10){
            if(sellIn <= 5){
                if(sellIn <= 0) {
                    quality = 0;
                }else if(quality + 3 <= 50){
                    quality += 3;
                }
            } else if (quality + 2 <= 50){
                quality += 2;
            }
        }else if(quality < 50){
            quality++;
        }
    }

    private void handleAgedBrieItem() {
        sellIn--;
        if (quality < 50){
            quality++;
        }
    }

    private void handleSulfurasItem() {
        quality = 80;
    }

    public void printItem() {
        System.out.printf("%-18s %-8d %d %n", name, sellIn, quality);
    }
}