package game;

import display.Display;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

    private Thread thread;

    private String title;
    private int width, height;
    private boolean isRunning;

    private Display display;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;

    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    public void init() {
        this.display = new Display(this.title, this.width, this.height);
    }

    public void tick() {

    }

    public void render() {
        this.bufferStrategy = this.display.getCanvas().getBufferStrategy();

        if (this.bufferStrategy == null) {
            this.display.getCanvas().createBufferStrategy(2); //    - test 1 or 3 for best work
            this.bufferStrategy = this.display.getCanvas().getBufferStrategy();
        }

        this.graphics = this.bufferStrategy.getDrawGraphics();

        this.graphics.fillRect(200, 200, 100, 100);

        this.graphics.dispose();
        this.bufferStrategy.show();

    }

    @Override   // - "implements Runnable" - Creating Threads and Loops
    public void run() {
        this.init();

        while (isRunning) {
            tick();
            render();
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
