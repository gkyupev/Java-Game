package entities.BonusItems;

import interfaces.Board;
import interfaces.Item;
import userInterface.GUI;

import java.awt.image.BufferedImage;

/**
 * Created by vb on 20.4.2016 г..
 */
public class BonusLive extends BonusItem implements Item {
    public BonusLive(int x, int y, int wigth, int hight, Board table, BufferedImage image) {
        super(x, y, wigth, hight, table, image);
    }

    @Override
   public void takeEffect() {
        GUI.getInstance().ballsUP();
        this.activate(false);

    }
}
