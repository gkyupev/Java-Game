package gfx;

import gfx.ImageLoader;

import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage background;
    public static BufferedImage paddle;
    public static BufferedImage mainManuBackground;
    public static BufferedImage ball;
    public static BufferedImage gameOver;

    public static void Init() {
        background = ImageLoader.loadImage("/background.jpg");
        paddle = ImageLoader.loadImage("/paddle.png");
        mainManuBackground=ImageLoader.loadImage("/mainmenu.jpg");
        ball=ImageLoader.loadImage("/ball.png");
        gameOver=ImageLoader.loadImage("/GameOver.jpg");

    }
}
