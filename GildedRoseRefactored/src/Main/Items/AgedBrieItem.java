package Main.Items;

public class AgedBrieItem extends Item implements Strategy {

    public AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void endOfDayUpdate() {
        sellIn--;
        if (quality < 50){
            quality++;
        }
    }
}