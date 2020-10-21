package character;

import map.Map;
import map.Tile;

import java.util.List;

public abstract class Character {

    int health;
    int attackDamage;
    int maxHealth;
    Tile position;
    Map map;

    public Tile getPosition() {
        return position;
    }

    public Character(Map map) {
        this.map = map;
        health = 5;
    }

    public void jump(int direction) {
        if (Math.abs(direction) > 1) {
            throw new ArithmeticException();
        }
        Tile target = map.getNextTile(position, direction * 2);
        if (!target.occupied) {
            position.occupied = false;
            position = target;
        }
    }

    public void move(int direction) {
        if (Math.abs(direction) > 1) {
            throw new ArithmeticException();
        }
        Tile target = map.getNextTile(position, direction);
        if (!target.occupied) {
            position.occupied = false;
            position = target;
        }
    }

    public void attack(int direction, List<Character> characters) {
        if (Math.abs(direction) > 1) {
            throw new ArithmeticException();
        }
        Tile target = map.getNextTile(position, direction);
        Character foundCharacter = null;
        if (target.occupied) {
            for (Character character : characters) {
                if (character.position.equals(target)) {
                    if (!character.getClass().equals(this.getClass())) {
                        character.health -= 1;
                        if (character.health == 0) {
                            target.occupied = false;
                            foundCharacter = character;
                        }
                    }
                }

            }
            characters.remove(foundCharacter);
        }


    }

    public abstract String getStat();
}
