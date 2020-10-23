package Main.Items;

public class SulfurasItem extends Item implements Strategy {

    public SulfurasItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void endOfDayUpdate() {
        quality = 80;
    }
}