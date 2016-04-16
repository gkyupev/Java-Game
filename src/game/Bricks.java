package game;

import gfx.Assets;
import gfx.ImageLoader;

import java.awt.*;
import java.util.ArrayList;

public class Bricks {
    public int x, y;
    private final int WIGHT = 40;
    private final int HIGHT = 10;
    public Rectangle boundingBox;
    protected static Image img;
    protected int hitPoint=1;
    protected int score = 10;

    public Bricks(int x, int y) {
        this.x = x;
        this.y = y;


        this.boundingBox = new Rectangle(x, y, WIGHT, HIGHT);

    }

    public int getScore() {
        return score;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void tick() {

    }

    public void drawBrick(Graphics g) {
        switch (hitPoint) {
            case 1:
                g.drawImage(Assets.brick, this.x, this.y, this.WIGHT, this.HIGHT, null);
                break;
            case 2:
                g.drawImage(Assets.harderBrick, this.x, this.y, this.WIGHT, this.HIGHT, null);
                break;

            case 3:
                g.drawImage(Assets.hardestBrick, this.x, this.y, this.WIGHT, this.HIGHT, null);
                break;

        }

   //      g.drawImage(Assets.brick, this.x, this.y, this.WIGHT, this.HIGHT, null);
        //  g.drawRect(boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height);
    }

    public void getHit() {
        this.hitPoint--;
    }
}
