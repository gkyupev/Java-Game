package game;

import gfx.ImageLoader;
import java.awt.*;
import java.util.ArrayList;

public class Bricks {
    public  int x , y,wight,hight;

    public Rectangle boundingBox;
     protected static Image img;
    protected int hitPoint;
    protected  int score =10;
    public Bricks(int x, int y, int hight, int wight) {
        this.x = x;
        this.y = y;
        this.hitPoint=1;
        this.hight=hight;
        this.wight=wight;


        this.boundingBox=new Rectangle(x,y,wight,hight);

    this.img=ImageLoader.loadImage("/bricks.png");
    }

    public int getScore() {
        return score;
    }

    public int getHitPoint() {
        return hitPoint;
    }

public void tick(){
//    this.boundingBox.setBounds(this.x,this.y,this.wight,this.hight);
}
    public  void drawBrick(Graphics g){

            g.drawImage(img,this.x,this.y,this.wight,this.hight,null);
g.drawRect(boundingBox.x,boundingBox.y,boundingBox.width,boundingBox.height);
    }
    //    public boolean intersect(Rectangle enemy){
//        if (boundigbox.contains(enemy.x,enemy.y)|| enemy.contains(boundigbox.x,boundigbox.y)){
//            return true;
//        }
//        return false;
//    }
//    public static ArrayList<Bricks> fillBricks(int x,int y, int hight,int wight,int numberOfBricks){
//        ArrayList<Bricks> allBricks = new ArrayList<>();
//        int endOfTheLine = x;
//        int numberBrickOnLine = 15;
//        int countLine =0;
//        for (int i = 0; i <numberOfBricks; i++) {
//            if (countLine==numberBrickOnLine){
//                y+=25;
//                x=endOfTheLine+50;
//                endOfTheLine=x;
//                numberBrickOnLine-=2;
//                countLine=0;
//            }
//            allBricks.add(new Bricks(x, y, hight, wight, false));
//            x+=45;
//            countLine++;
//        }
//        return allBricks;
   // }
public void getHit(){
    this.hitPoint--;
}
}
