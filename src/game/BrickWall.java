package game;

import UserInterface.GUI;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by vb on 13.4.2016 г..
 */
public class BrickWall {
    private ArrayList<Bricks> wall;

    public  BrickWall() {
        this.wall = new ArrayList<>();
    }

    public ArrayList<Bricks> getWall() {
        return wall;
    }

    public void tick() {

        for (int i = 0; i <wall.size() ; i++) {
            if (wall.get(i).getHitPoint()<=0){
                wall.remove(i);
            }
        }


    }
        public void render(Graphics graf) {

            for (Bricks bricks : wall) {

                bricks.drawBrick(graf);
            }
    }
    public void fillBricks() {
       this.wall.clear();
        switch (GUI.getInstance().getLevel()){
            case 1 : this.lavel1Wall();
                break;
            case 2 : this.lavel2Wall();
                break;
       default:
           this.lavel1Wall();
        }

    }
private void lavel1Wall() {
    int numberOfBricks = 64;
    int x = 50;
    int y = 50;
    int endOfTheLine = x;
    int numberBrickOnLine = 15;
    int countLine = 0;
    for (int i = 0; i < numberOfBricks; i++) {

        if (countLine == numberBrickOnLine) {
            y += 25;
            x = endOfTheLine + 50;
            endOfTheLine = x;
            numberBrickOnLine -= 2;
            countLine = 0;
        }
        if (countLine == 0 || countLine == numberBrickOnLine - 1) {
            wall.add(new HardestBrick(x, y));
        } else if (countLine == 1 || countLine == numberBrickOnLine - 2) {
            wall.add(new HarderBrick(x, y));
        } else {
            wall.add(new Bricks(x, y));
        }
        x += 45;
        countLine++;
    }


}

    private void lavel2Wall() {
        int x = 0;
        int y = 30;
        for (int i = 0; i < 176; i++) {
           if (i%16==0){
               y+=15;
               x=0;
           }
      if (i<16*5){
       wall.add(new Bricks(x,y));
            x+=50;
        }else if((i>=16*5)&&(i<16*9)){
            wall.add(new HarderBrick(x,y));
          x+=50;
      }else {
          wall.add(new HardestBrick(x,y));
          x+=50;
      }
        }
    }
}
