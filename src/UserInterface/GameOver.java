package UserInterface;

import Game.Game;
import FX.Assets;

import Interfaces.Renderable;

import java.awt.*;

/**
 * Created by vb on 14.4.2016 г..
 */
public class GameOver implements Renderable {
    public void render(Graphics graphics){
        graphics.drawImage(Assets.gameOver, 0, 0, 800, 600, null);
        Font fontTitle = new Font("ariel", Font.BOLD, 50);
        graphics.setFont(fontTitle);
        graphics.setColor(Color.WHITE);
        graphics.drawString("Restart", 50, 500);
        graphics.drawString("Quit", 630, 500);
    }
}
