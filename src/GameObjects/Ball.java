package GameObjects;

import UserInterface.GUI;
import game.BrickWall;
import game.Bricks;
import game.Table;
import gfx.Assets;

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
    private boolean isBounced = false;

    public Ball(Table table, BrickWall wall) {
        this.table = table;
        this.x = table.getRectX() + 40;
        this.y = table.getRectY() - 20;
        this.velocityX = 10;
        this.velocityY = 10;
        this.directionX = 1;
        this.directionY = -1;

        this.wall = wall;
        boundingBox = new Rectangle(this.x, this.y, 20, 20);
    }


    public int getY() {
        return y;
    }

    public void tick() {
        bounceOfBrick();
        if (!isRelease) {
            this.x = table.getRectX() + 40;
            this.y = table.getRectY() - 20;
        } else {
            bounceOfTable();
            fall();
            this.x += velocityX * directionX;
            this.y += velocityY * directionY;

            if ((x >= 790) || (x <= 0)) {
                isBounced = false;
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
        graf.drawImage(Assets.ball, this.x, this.y, 20, 20, null);
    }

    public void bounceOfTop() {

        isBounced = false;
        directionY = -1 * directionY;
        //  velocityY = 10;
        System.out.println(directionY);
        System.out.println(velocityY);

    }

    private void bounceOfTable() {
        if (this.boundingBox.intersects(table.getBoundingBox()) || table.getBoundingBox().intersects(this.boundingBox)) {
            velocityCorrection = Math.abs((this.boundingBox.getMinX() + 10) - (this.table.getBoundingBox().getMinX() + 50));

            if (!isBounced) {
                Assets.bounce.setFramePosition(0);
                Assets.bounce.loop(0);
                System.out.println(velocityCorrection);
                if (velocityCorrection >= 30) {
                    velocityY = 6;
                } else if (velocityCorrection < 30 && velocityCorrection > 10) {
                    velocityY = 10;
                } else if (velocityCorrection <= 10) {
                    velocityY = 16;
                }

                directionY = -1 * directionY;
                isBounced = true;
            }

        }
    }

    private void bounceOfBrick() {
        for (Bricks brick : this.wall.getWall()) {
            if (this.boundingBox.intersects(brick.boundingBox) || brick.boundingBox.intersects(this.boundingBox)) {
                isBounced = false;
                Assets.brickBreak.setFramePosition(0);
                Assets.brickBreak.loop(0);
                brick.getHit();
                GUI.getInstance().setScores(brick.getScore());
                directionY *= -1;
                velocityY = 10;
            }

        }
    }

    private void fall() {
        if (y > 620) {
            isRelease = false;
            this.directionX = 1;
            this.directionY = -1;
            GUI.getInstance().setBalls();

        }
    }
}
