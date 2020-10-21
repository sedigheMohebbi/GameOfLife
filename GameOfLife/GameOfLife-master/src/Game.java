import character.Character;
import character.Enemy;
import character.Player;
import map.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Map m = new Map(10);
        ArrayList<Character> characters = new ArrayList<Character>();
        Player p = new Player(m, m.getRandomNonOccupiedTile());
        characters.add(p);
        for (int i = 0; i < 3; i++) {
            Enemy e = new Enemy(m, m.getRandomNonOccupiedTile());
            characters.add(e);
        }
        // Game loop {
        // get input
        // process

        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = getInput(sc);
            process(input, p, characters);
            showResult(m, characters);
        }
    }

    private static void showResult(Map m, ArrayList<Character> characters) {
        for (int i = 0; i < m.getSize(); i++) {
            boolean isCharacterInside = false;
            for (Character character : characters) {
                if (character.getPosition().getX() == i) {
                    System.out.print(character.getStat());
                    isCharacterInside = true;
                }
            }
            if (!isCharacterInside) {
                System.out.print("|___|");
            }
        }
    }


    private static void process(String input, Player player, List<Character> characters) {
        if (input.equals("right")) {
            player.move(1);
        } else if (input.equals("left")) {
            player.move(-1);
        } else if (input.equals("attackRight")) {
            player.attack(1, characters);
        } else if (input.equals("attackLeft")) {
            player.attack(-1, characters);
        } else if (input.equals("jumpRight")) {
            player.jump(1);
        } else if (input.equals("jumpLeft")) {
            player.jump(-1);
        }
    }

    private static String getInput(Scanner sc) {
        String input = sc.nextLine();
        // validation
        return input;
    }
}
