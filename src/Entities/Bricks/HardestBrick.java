package entities.Bricks;

import interfaces.Board;
import interfaces.Wall;

/**
 * Created by vb on 13.4.2016 г..
 */
public class HardestBrick extends NormalBrick {
    public HardestBrick(int x, int y, Wall wall, Board table) {
        super(x, y,wall,table);
        this.hitPoint=3;

    }
}
