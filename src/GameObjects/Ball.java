package GameObjects;

import game.BrickWall;
import game.Bricks;
import game.Table;

import java.awt.*;


/**
 * Created by vb on 11.4.2016 г..
 */
public class Ball {
    private int x, y, directionX, directionY;
    private double velocityX, velocityY;
    private double velocityCorrection;
    private Rectangle boundingBox;
private BrickWall wall;
    public static boolean isRelease = false;
    private Table table;

    public Ball(Table table, BrickWall wall) {
        this.table = table;
        this.x = table.getRectX() + 40;
        this.y = table.getRectY() - 20;
        this.velocityX = 10;
        this.velocityY = 10;
        this.directionX = 1;
        this.directionY = -1;
this.wall=wall;
        boundingBox = new Rectangle(this.x, this.y, 20, 20);
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    public void tick() {
bounceOfBrick();
        if (!isRelease) {
            this.x = table.getRectX() + 40;
            this.y = table.getRectY() - 20;
        } else {
            bounceOfTable();
            this.x += velocityX * directionX;
            this.y += velocityY * directionY;

            if ((x >= 790) || (x <= 0)) {
                // velocityX=10;
                velocityY = 10;
                directionX *= -1;
            }
            if ((y < 0)) {
                bounceOfTop();
            }

        }
        this.boundingBox.setBounds(this.x, this.y, 20, 20);
    }

    public void render(Graphics graf) {

        graf.setColor(Color.red);
        graf.fillOval(this.x, this.y, 20, 20);
        graf.drawRect(boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height);
    }

    public void bounceOfTop() {

        directionY = -1 * directionY;
        velocityY = 10;
        System.out.println(directionY);
        System.out.println(velocityY);

    }

    private void bounceOfTable() {
        if (this.boundingBox.contains(table.getBoundingBox()) || table.getBoundingBox().contains(this.boundingBox)) {
            velocityCorrection = Math.abs((this.boundingBox.getMinX() + 10) - (this.table.getBoundingBox().getMinX() + 25));

            System.out.println(velocityCorrection);
           // velocityY = 6;
            directionY = -1 * directionY;
            System.out.println(directionY);
            System.out.println(velocityY);
            System.out.println("col");
        }
    }
    private void bounceOfBrick() {
        for (Bricks brick : this.wall.getWall()) {
            if (this.boundingBox.intersects(brick.boundingBox) || brick.boundingBox.intersects(this.boundingBox)) {
                brick.getHit();
               directionY*=-1;
            }

        }

    }
}
