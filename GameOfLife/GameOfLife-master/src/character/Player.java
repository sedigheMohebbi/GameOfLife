package character;

import map.Map;
import map.Tile;

public class Player extends Character {
    public Player(Map map, Tile position) {
        super(map);
        this.position = position;
        health = 6;
    }

    @Override
    public String getStat() {
        return "P[" + health + "]";
    }

}
