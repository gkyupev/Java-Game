package game;

import gfx.ImageLoader;

import java.awt.*;
import java.util.ArrayList;

public class Bricks {
    public int x, y, wight, hight;

    public Rectangle boundingBox;
    protected static Image img;
    protected int hitPoint;
    protected int score = 10;

    public Bricks(int x, int y) {
        this.x = x;
        this.y = y;
        this.hitPoint = 1;
        this.hight = 10;
        this.wight = 40;
        this.boundingBox = new Rectangle(x, y, wight, hight);
        this.img = ImageLoader.loadImage("/bricks.png");
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

        g.drawImage(img, this.x, this.y, this.wight, this.hight, null);
        g.drawRect(boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height);
    }

    public void getHit() {
        this.hitPoint--;
    }
}
