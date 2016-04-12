package game;

import java.awt.*;

public class Table {
    private int rectX, rectY, rectWidth, rectHeight, velocity;
private Rectangle boundingBox;
    public static boolean goingLeft;
    public static boolean goingRight;


    public Table() {
        this.rectX = 350;
        this.rectY = 550;
        this.rectWidth = 100;
        this.rectHeight = 20;
        this.velocity = 30;
         boundingBox=new Rectangle(this.rectX,this.rectY,this.rectWidth,this.rectHeight);
        goingLeft = false;
        goingRight = false;
    }

    public void tick() {
        if (goingLeft && this.rectX > 0) { // 00000000000000000
//            System.out.println("left"); // <-- debug
            this.rectX -= this.velocity;
            System.out.println(this.rectX); // <-- debug
        } else if (goingRight && this.rectX < 700) {  // 0000000000000
//            System.out.println("right"); // <-- debug
            this.rectX += this.velocity;
            System.out.println(this.rectX); // <-- debug
        }
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.fillRect(this.rectX, this.rectY, this.rectWidth, this.rectHeight);

    }

    public int getRectX() {
        return rectX;
    }

    public int getRectY() {
        return rectY;
    }
}
