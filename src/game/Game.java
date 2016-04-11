package game;

import display.Display;
import gfx.ImageLoader;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

    private Thread thread;

    private String title;
    private int width, height;
    private boolean isRunning;

    private Display display;
    private InputHandler inputHandler;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;

//    public static Rectangle rectangle;
    public static Table table;

    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    public void init() {
        this.display = new Display(this.title, this.width, this.height);
        this.inputHandler = new InputHandler(this.display);

        table = new Table();
    }

    public void tick() {
        table.tick();

    }

    public void render() {
        this.bufferStrategy = this.display.getCanvas().getBufferStrategy();

        if (this.bufferStrategy == null) {
            this.display.getCanvas().createBufferStrategy(2); //    - test 1 or 3 for best work
            this.bufferStrategy = this.display.getCanvas().getBufferStrategy();
        }

        this.graphics = this.bufferStrategy.getDrawGraphics();
        this.graphics.clearRect(0, 0, this.width, this.height);

        this.graphics.drawImage(ImageLoader.loadImage("/background.jpg"), 0, 0, this.width, this.height, null);
        //Table t = new Table(100, 100, 20, 200);
        //this.graphics.fillRect(t.rectangle.x, t.rectangle.y, t.rectangle.width, t.rectangle.height);

        //this.graphics.fillRect(350, 550, 100, 20);
        table.render(graphics);
        //System.out.println("render");

        this.graphics.dispose();
        this.bufferStrategy.show();

    }

    @Override   // - "implements Runnable" - Creating Threads and Loops
    public void run() {
        this.init();

        int fps = 30;
        double timePerTick = 1_000_000_000.0 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (isRunning) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if (timer >= 1_000_000_000) {
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        this.stop();
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        this.isRunning = true;
    }

    public synchronized void stop() {
        try {
            this.isRunning = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
