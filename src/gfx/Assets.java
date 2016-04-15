package gfx;

import gfx.ImageLoader;

import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage background;
    public static BufferedImage paddle;
    public static BufferedImage mainManuBackground;
    public static BufferedImage ball;
    public static BufferedImage gameOver;
    public static Clip bounce;
   public static  Clip brickBreak;
    public static void Init() {
        background = ImageLoader.loadImage("/background.jpg");
        paddle = ImageLoader.loadImage("/paddle.png");
        mainManuBackground=ImageLoader.loadImage("/mainmenu.jpg");
        ball=ImageLoader.loadImage("/ball.png");
        gameOver=ImageLoader.loadImage("/GameOver.jpg");
         bounce=AudioLoader.loadAudio("/bounce.wav");
        brickBreak=AudioLoader.loadAudio("/brickBreak.wav");
    }
}
