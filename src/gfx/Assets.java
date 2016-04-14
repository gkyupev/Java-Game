package gfx;

import gfx.ImageLoader;

import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage background;
    public static BufferedImage paddle;

    public static void Init() {
        background = ImageLoader.loadImage("/background.jpg");
        paddle = ImageLoader.loadImage("/paddle.png");
    }
}
