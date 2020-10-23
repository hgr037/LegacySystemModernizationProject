package Main;

import Main.Items.*;

import java.util.ArrayList;
import java.util.Collection;

public class GildedRoseApp {
    private ArrayList<Item> items = new ArrayList<>();
    private Item contextItem = new Item();

    public static void main(String[] args){
        GildedRoseApp gildedRoseAppRunner = new GildedRoseApp();
        gildedRoseAppRunner.run();
    }

    private void run(){
        int allItemsUpdated = endOfDayUpdate();

        if (allItemsUpdated != items.size()){
            System.err.println("Did not update all Items");
        } else System.out.println("Items Updated Successfully");

        printItems();
    }

    private void printItems() {
        System.out.printf("-------------Item Stock-------------%n" +
                "%-18s %-8s %s %n", "Name","Sell In","Quality");
        for(Item item:items){
            item.printItem();
        }
    }

    public void addItemToList(Item... args){
        for(Item item : args){
            items.add(item);
        }
    }

    public int endOfDayUpdate() {
        int numberUpdated = 0;
        for(Item item:items){
            contextItem.setItem(item);
            contextItem.endOfDayUpdate();
            numberUpdated++;
        }
        return numberUpdated;
    }

    public Collection<Item> getItems() {
        return items;
    }
}