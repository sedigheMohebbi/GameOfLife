package map;

import character.Character;
import gameObjects.Potion;

public class Tile {
    public boolean occupied;
    int x;

    public Tile(int i) {
        x = i;
        occupied = false;
    }

    public int getX() {
        return x;
    }

    public Potion getPotion() {
        return potion;
    }

    Potion potion;
    // Hazard
}
