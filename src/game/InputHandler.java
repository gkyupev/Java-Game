package game;

import display.Display;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener{

    public InputHandler(Display display) {
        display.getCanvas().addKeyListener(this);
    }

//    private Canvas canvas;
//
//    public InputHandler(Canvas canvas) {
//        canvas.addKeyListener(this);
//    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_LEFT) {
//            System.out.println("LEFT"); // <-- debug
            Table.goingLeft = true;
            Table.goingRight = false;
        } else if (code == KeyEvent.VK_RIGHT) {
//            System.out.println("RIGHT"); // <-- debug
            Table.goingRight = true;
            Table.goingLeft = false;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_LEFT) {
            Table.goingLeft = false;
            Table.goingRight = false;
        } else if (code == KeyEvent.VK_RIGHT) {
            Table.goingRight = false;
            Table.goingLeft = false;
        }
    }
}