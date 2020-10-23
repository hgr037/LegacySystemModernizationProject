package Main.Items;

public class ConjuredItem extends Item implements Strategy {

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void endOfDayUpdate() {
        sellIn--;
            if (quality > 1) {
                if (sellIn > 0) {
                    quality -= 2;
                } else quality -= 4;
            } else quality = 0;
    }
}