package game;

import GameObjects.Ball;
import UserInterface.*;
import display.Display;
import gfx.Assets;
import gfx.ImageLoader;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
    public static int width, height;
    private static   Table table;
    public static GameState State = GameState.MainMenu;
  private static boolean restart =false;
    private Thread thread;
    private String title;
    private boolean isRunning;
    private MouseInput mouseInput;
    private Display display;
    private InputHandler inputHandler;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;
    private Ball ball;
    private BrickWall wall;
    private Image background;
    private MainMenu mainMenu;
    private PauseMenu pauseMenu;
    private GameOver gameOver;

    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    public void init() {
        Assets.Init();
        wall = new BrickWall();
        wall.fillBricks();
        this.display = new Display(this.title, this.width, this.height);
        this.inputHandler = new InputHandler(this.display);
        this.mouseInput = new MouseInput(this.display);
        this.background = ImageLoader.loadImage("/background.jpg");
        table = new Table();
        ball = new Ball(this.table, this.wall);
        mainMenu = new MainMenu();
        pauseMenu = new PauseMenu();
        gameOver = new GameOver();
    }

    public void tick() {
       if (restart){
           this.wall.fillBricks();
       }
        if (State == GameState.Game) {
            table.tick();
            ball.tick();
            wall.tick();
            GUI.getInstance().tick();
        }

    }

    public void render() {
        this.bufferStrategy = this.display.getCanvas().getBufferStrategy();
        if (this.bufferStrategy == null) {
            this.display.getCanvas().createBufferStrategy(2); //    - test 1 or 3 for best work
            this.bufferStrategy = this.display.getCanvas().getBufferStrategy();
        }

        this.graphics = this.bufferStrategy.getDrawGraphics();
        this.graphics.clearRect(0, 0, this.width, this.height);
        if (State == GameState.Game || State == GameState.PauseMenu) {
            this.graphics.drawImage(this.background, 0, 0, this.width, this.height, null);
            table.render(graphics);
            ball.render(graphics);
            wall.render(graphics);
            GUI.getInstance().render(graphics);
            if (State == GameState.PauseMenu) {
                pauseMenu.render(graphics);
            }
        } else if (State == GameState.MainMenu) {
            mainMenu.render(graphics);
        } else if (State == GameState.GameOver) {
            gameOver.render(graphics);
        }

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
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
                //   System.out.println("Ticks and Frames: " + ticks);
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
public static void restart(){
    GUI.getInstance().Reset();
    table=new Table();
    Ball.isRelease=false;
    restart=true;
}

}
