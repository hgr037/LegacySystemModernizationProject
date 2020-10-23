import java.util.ArrayList;

public class GildedRoseAppRunner {
    private ArrayList<Item> items = new ArrayList<>();

    public static void main(String[] args){
        GildedRoseAppRunner gildedRoseAppRunner = new GildedRoseAppRunner();
        gildedRoseAppRunner.run();
    }

    private void run(){
        int allItemsUpdated = endOfDayUpdate();
        if (allItemsUpdated != items.size()){
            System.err.println("Did not update all Items");
        } else System.out.println("Items Updated Successfully");
        printItems();
    }

    public void printItems() {
        System.out.printf("-------------Item Stock-------------%n" +
                "%-18s %-8s %s %n", "Name","Sell In","Quality");
        for(Item item:items){
            item.printItem();
        }
    }

    public void addItem(String name, int sellIn, int quality) {
        items.add(new Item(name,sellIn,quality));
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public int endOfDayUpdate() {
        int numberUpdated = 0;
        for (Item item:items){
            item.endOfDayUpdate();
            numberUpdated++;
        }
        return numberUpdated;
    }
}