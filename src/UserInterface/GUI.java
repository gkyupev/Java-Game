package UserInterface;

import game.Game;
import game.GameState;
import gfx.Assets;

import java.awt.*;

/**
 * Created by vb on 14.4.2016 г..
 */
public class GUI {
    private int balls = 3;
    private int level = 1;
    private int scores = 0;
    private static GUI instance = null;

    private GUI() {
    }

    public static GUI getInstance() {
        if (instance == null) {
            instance = new GUI();
        }
        return instance;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel() {
        this.level ++;
    }

    public void setScores(int scorestoAdd) {
        scores += scorestoAdd;
    }

    public void tick() {
        if (balls <= 0) {
            Game.State = GameState.GameOver;
            Assets.gameOverSound.setFramePosition(0);
            Assets.gameOverSound.loop(0);
    }
    }

    public void setBalls() {
        this.balls--;
    }

    public void render(Graphics graphics) {
        int ballsX = 20;
        for (int i = 0; i < balls; i++) {
            graphics.drawImage(Assets.ball, ballsX, 10, 20, 20, null);
            ballsX += 30;
        }

        Font fontTitle = new Font("ariel", Font.BOLD, 20);
        graphics.setFont(fontTitle);
        graphics.setColor(Color.WHITE);
        graphics.drawString(String.format("Scores:%d", scores), 360, 30);
        graphics.drawString(String.format("Level:%d", level), 700, 30);
    }
    public  void Reset(){
        this.balls=3;
        this.level=1;
        this.scores=0;
    }
}
