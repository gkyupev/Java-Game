package GameObjects;

import game.Table;

import java.awt.*;
import java.util.Timer;
import java.util.Vector;
import java.util.concurrent.atomic.DoubleAccumulator;

/**
 * Created by vb on 11.4.2016 г..
 */
public class Ball {
    public int x,y,directionX,directionY;
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
        this.directionX=1;
        this.directionY=-1;

        boundingBox=new Rectangle(this.x,this.y,20,20);
    }
    public void tick(){
        this.boundingBox.setBounds(this.x, this.y, 20, 20);
if(!isRelease) {
    this.x = table.getRectX() + 40;
    this.y = table.getRectY() - 20;
}else{
    bounseOfTable();
    this.x += velocityX*directionX;
    this.y += velocityY*directionY;
    if ((x >= 790) || (x <= 0)) {
       // velocityX=10;
velocityY=10;
       directionX*=-1;
    }
    if ( (y < 0)) {
        bounseOfTop();
    }

}
    }
    public void render(Graphics graf){

        graf.setColor(Color.red);
        graf.fillOval(this.x,this.y,20,20);
graf.drawRect(boundingBox.x,boundingBox.y,boundingBox.width,boundingBox.height);
    }
public void bounseOfTop(){

    directionY =-1*directionY;
    velocityY=10;
    System.out.println(directionY);
    System.out.println(velocityY);

}
        private void bounseOfTable(){
       if(this.boundingBox.contains(table.getBoundingBox()) || table.getBoundingBox().contains(this.boundingBox)) {
       velocityCorrection=Math.abs((this.boundingBox.getMinX()+10)-(this.table.getBoundingBox().getMinX()+25));

           System.out.println(velocityCorrection);
        //  velocityY=5.77;
           directionY=-1*directionY;
           System.out.println(directionY);

           System.out.println("col");
}
}}
