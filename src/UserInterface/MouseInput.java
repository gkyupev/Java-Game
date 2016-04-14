package UserInterface;

import display.Display;
import game.Game;
import game.GameState;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by vb on 14.4.2016 г..
 */
public class MouseInput implements MouseListener {
    public MouseInput(Display display) {
        display.getCanvas().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        //Play
        if (Game.State == GameState.MainMenu) {
            if (mouseX > Game.width / 2 - 50 && mouseX < Game.width / 2 + 50) {
                if (mouseY > Game.height / 3 + 75 && mouseY < Game.height + 125) {
                    Game.State = GameState.Game;
                }
            }
            //Help
            if (mouseX > Game.width / 2 + 150 && mouseX < Game.width / 2 + 250) {
                if (mouseY > Game.height / 3 + 175 && mouseY < Game.height + 225) {
                    // TODO: 14.4.2016 г.
                }
            }
            //Quit
            if (mouseX > Game.width / 2 - 50 && mouseX < Game.width / 2 + 50) {
                if (mouseY > Game.height / 3 + 275 && mouseY < Game.height + 325) {
                    System.exit(0);
                }
            }
        } else if (Game.State == GameState.PauseMenu) {
            if (mouseX > 350 && mouseX < 450) {
                if (mouseY > 300 && mouseY < 350) {
                    System.exit(0);
                }
            }
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
