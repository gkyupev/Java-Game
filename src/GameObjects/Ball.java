package GameObjects;

import game.Table;

import java.awt.*;
import java.util.Vector;
import java.util.concurrent.atomic.DoubleAccumulator;

/**
 * Created by vb on 11.4.2016 г..
 */
public class Ball {
    public int x,y;
  private double velocityX,velocityY;
    private double velocityCorrection;
    private Rectangle boundingBox;
    public static boolean isRelease=false;
private Table table;
    public Ball( Table table) {
        this.table=table;
        this.x = table.getRectX()+40;
        this.y =table.getRectY()-20;
        this.velocityX = 10;
        this.velocityY = 10;

        boundingBox=new Rectangle(this.x,this.y,20,20);
    }
    public void tick(){
        this.boundingBox.setBounds(this.x, this.y, 20, 20);
if(!isRelease) {
    this.x = table.getRectX() + 40;
    this.y = table.getRectY() - 20;
}else{
   bounseOfTable();
    this.x += velocityX;
    this.y -= velocityY;
    if ((x >= 790) || (x <= 0)) {

        velocityX = velocityX * -1;
    }
    if ( (y < 0)) {
        bounseOfTop();
    }
}
    }
    public void render(Graphics graf){

        graf.setColor(Color.red);
        graf.fillOval(this.x,this.y,20,20);

    }
public void bounseOfTop(){
    velocityY = velocityY * -1;
}
     private void bounseOfTable(){
    if(this.boundingBox.contains(table.getBoundingBox()) || table.getBoundingBox().contains(this.boundingBox)) {

        this.velocityY*=-1;
    }


}
}
