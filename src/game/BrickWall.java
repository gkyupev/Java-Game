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
     if (wall.size()==0){

     }
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
        switch (GUI.getInstance().getLevel()){
            case 1 : this.lavel1Wall();
                break;
        }

    }
private void lavel1Wall(){
    int numberOfBricks=64;
    int x= 50;
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
        wall.add(new Bricks(x, y));

        x += 45;
        countLine++;
    }
}
}
