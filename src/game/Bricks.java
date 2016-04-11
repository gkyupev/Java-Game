package game;

import gfx.ImageLoader;
import java.awt.*;
import java.util.ArrayList;

public class Bricks {
    public  int x , y,wight,hight;
    public boolean isHit;
    public Rectangle boundigbox;
private static Image img;
    public Bricks(int x, int y, int hight, int wight, boolean b) {
        this.x = x;
        this.y = y;
        this.hight=hight;
        this.wight=wight;
        this.isHit=b;
        this.boundigbox=new Rectangle(x,y,hight,wight);
    this.img=ImageLoader.loadImage("/bricks.png");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHight() {
        return hight;
    }

    public int getWight() {
        return wight;
    }

    public boolean isHit() {
        return isHit;
    }

    public void tick(){
        //this.boundigbox.setBounds(this.x,this.y,this.hight,this.wight);
    }
    public static void drawBricks(Graphics g, ArrayList<Bricks> allBricks){
        for (int i = 0; i <allBricks.size() ; i++) {
            g.drawImage(img,allBricks.get(i).getX(),allBricks.get(i).getY(),
                    allBricks.get(i).getHight(),allBricks.get(i).getWight(),null);
        }
    }
    //    public boolean intersect(Rectangle enemy){
//        if (boundigbox.contains(enemy.x,enemy.y)|| enemy.contains(boundigbox.x,boundigbox.y)){
//            return true;
//        }
//        return false;
//    }
    public static ArrayList<Bricks> fillBricks(int x,int y, int hight,int wight,int numberOfBricks){
        ArrayList<Bricks> allBricks = new ArrayList<>();
        int endOfTheLine = x;
        int numberBrickOnLine = 15;
        int countLine =0;
        for (int i = 0; i <numberOfBricks; i++) {
            if (countLine==numberBrickOnLine){
                y+=25;
                x=endOfTheLine+50;
                endOfTheLine=x;
                numberBrickOnLine-=2;
                countLine=0;
            }
            allBricks.add(new Bricks(x, y, hight, wight, false));
            x+=45;
            countLine++;
        }
        return allBricks;
    }
}
