package interfaces;

/**
 * Created by vb on 20.4.2016 г..
 */
public interface GameBall extends Tickable, Renderable {
    void setWall(interfaces.Wall wall);

    void stickToBorad();


    void setTable(Board table);

    void changeSpeed();
}
