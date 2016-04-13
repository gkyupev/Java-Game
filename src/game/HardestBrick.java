package game;

import gfx.ImageLoader;

/**
 * Created by vb on 13.4.2016 г..
 */
public class HardestBrick extends Bricks {
    public HardestBrick(int x, int y, int hight, int wight) {
        super(x, y, hight, wight);
        this.hitPoint=3;
        this.img= ImageLoader.loadImage("/bricks.png");
    }
}
