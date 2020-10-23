package Main.Items;

public class Item {

    //special Items
    public static final String SULFURAS = "Sulfuras";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage Passes";
    public static final String CONJURED = "Conjured";

    //Item values
    protected String name;
    protected int sellIn;
    protected int quality;

    //Strategy Item (following Strategy Design Pattern)
    private Item item;

    public void setItem(Item item){
        this.item = item;
    }

    //execute strategy
    public void endOfDayUpdate(){
        item.endOfDayUpdate();
    }

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public Item(){ }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void printItem() {
        System.out.printf("%-18s %-8d %d %n", name, sellIn, quality);
    }
}