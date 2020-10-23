package Main.Items;

public class BackStagePassesItem extends Item implements Strategy {

    public BackStagePassesItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void endOfDayUpdate() {
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
}