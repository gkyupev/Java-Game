package GameObjects;

import java.awt.*;
import java.util.Vector;

/**
 * Created by vb on 11.4.2016 г..
 */
public class Ball {
    public int x,y,velocityX,velocityY;

    private Rectangle rect;

    public Ball(int x, int y, int velocityX , int velocityY) {
        this.x = x;
        this.y = y;
        this.velocityX=velocityX;
        this.velocityY=velocityY;
        rect=new Rectangle(this.x,this.y,20,20);
    }
    public void tick(){

       this.x+=velocityX;
       this.y+=velocityY;
        if ((x > 790) || (x < 0)) {
            velocityX = velocityX * -1;
        }
        if ((y > 550) || (y < 0)) {
            velocityY = velocityY * -1;
        }

    }
    public void render(Graphics graf){

        graf.setColor(Color.red);
        graf.fillOval(this.x,this.y,20,20);
}
}