package GameObjects;

import java.awt.*;
import java.util.Vector;

/**
 * Created by vb on 11.4.2016 г..
 */
public class Ball {
    public int x,y,velocity;

    private Rectangle rect;

    public Ball(int x, int y, int velocity ) {
        this.x = x;
        this.y = y;
        this.velocity=velocity;
        rect=new Rectangle(this.x,this.y,20,20);
    }
    public void tick(){

       this.x+=velocity;
       this.y+=velocity;

    }
    public void render(Graphics graf){
     graf.fillOval(this.x,this.y,50,50);
}
}
