package Main.Items;

public class NormalItem extends Item implements Strategy {

    public NormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void endOfDayUpdate(){
        sellIn--;
        if (quality > 0) {
            if(sellIn > 0){
                quality--;
            } else quality -=2;
        }
    }
}