package UserInterface;

import game.Game;
import gfx.Assets;

import java.awt.*;

/**
 * Created by vb on 14.4.2016 г..
 */
public class GameOver {
    public void render(Graphics graphics){
        graphics.drawImage(Assets.gameOver, 0, 0, Game.width, Game.height, null);
    }
}
