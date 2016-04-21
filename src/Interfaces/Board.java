package interfaces;

/**
 * Created by vb on 20.4.2016 г..
 */
public interface Board extends Collidable,Tickable,Renderable{
    int getRectX();

    int getRectY();

    int getRectWidth();

    void setRectWidth(int rectWidth);
    void  midPosition();
}
