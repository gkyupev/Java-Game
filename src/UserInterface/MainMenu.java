package UserInterface;

import game.Game;
import gfx.Assets;

import java.awt.*;

/**
 * Created by vb on 14.4.2016 г..
 */
public class MainMenu {
    public Rectangle playButton = new Rectangle(Game.width / 2 - 50, Game.height / 3 + 75, 100, 50);
    public Rectangle helpButton = new Rectangle(Game.width / 2 - 50, Game.height / 3 + 175, 100, 50);
    public Rectangle quitButton = new Rectangle(Game.width / 2 - 50, Game.height / 3 + 275, 100, 50);

    public void render(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D)graphics;
        graphics.drawImage(Assets.mainManuBackground, 0, 0, Game.width, Game.height, null);
        Font fontTitle = new Font("ariel", Font.BOLD, 50);
        graphics.setFont(fontTitle);
        graphics.setColor(Color.WHITE);
        graphics.drawString("Java Game", Game.width / 2 -120, Game.height / 3);
        Font fontButtons = new Font("ariel",Font.BOLD, 30);
        graphics.setFont(fontButtons);
        graphics.drawString("Play",playButton.x+20,playButton.y+35);
        graphics.drawString("Help",helpButton.x+20,helpButton.y+35);
        graphics.drawString("Quit",quitButton.x+20,quitButton.y+35);

        graphics2D.draw(playButton);
        graphics2D.draw(helpButton);
        graphics2D.draw(quitButton);
    }


}
