package io.loel;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private int level = 0;
    private Hero player;
    private String[] monsters = {"RANGED", "CLOSE", "FLYING"};
    Random rng = new Random();
    Scanner scanner = new Scanner(System.in);
    public Game (Hero player) {
        this.player = player;
    }

    // Return level
    public int play() {
        System.out.println("You enter the infinite tower.");
        return this.play_level();
    }

    private int play_level() {
        this.level++;
        System.out.println("Level " + this.level);
        if (rng.nextBoolean()) {
            System.out.println("You lucked out, no one was there");
            return play_level();
        }
        Monster monster = new Monster(monsters[rng.nextInt(monsters.length)]);
        int turns = 0;
        System.out.println(
                String.format("The %s type monster's health is %s",
                    monster.getType(),
                    monster.getHealth()
                )
        );
        while (turns < 10 && this.player.getHealth() > 0) {
            turns++;
            if (this.get_action()) {
                if (monster.receiveDMG(this.player.attack(), this.player.getType())) {
                    return this.play_level();
                }
            } else if (this.player.flee(monster.getType())) {
                return this.play_level();
            }
            this.player.recieveDMG(monster.attack(), monster.getType());
            System.out.println("Your health is " + this.player.getHealth());

        }
        if (this.player.getHealth() <= 0) {
            System.out.println("You died...");
            return this.level;
        }
        return play_level();
    }

    // True - attack
    // False - Flee
    private boolean get_action(){
        System.out.println("0 - Attack\n1 - Flee");
        switch (scanner.nextInt()) {
            case 0:
                return true;
            case 1:
                return false;
            default:
                System.out.println("Invalid choice");
                return get_action();
        }
    }

}
