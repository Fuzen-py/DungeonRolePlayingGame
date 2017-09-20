package io.loel;

import java.util.Random;

public class Monster {

    Random rng = new Random();
    private int attack = 3;
    private int health = 20;
    private String type;

    public Monster(String type) {
        this.type = type;
    }

    public int attack() {
        int dmgDealt=attack;
        dmgDealt += rng.nextInt(5); // Dmg amplifier
        System.out.println(String.format("You took %s damage!", dmgDealt));
        return dmgDealt;
    }

    public String getType() {
        return this.type;
    }

    public int getHealth() {
        return this.health;
    }

    // Returns a boolean representing dead or alive
    public boolean receiveDMG(int dmg, String hero_type) {
        if (hero_type.equalsIgnoreCase("magicians")) {
            if (this.type.equalsIgnoreCase("flying")) {
                System.out.println("It's super effective, you deal an additional 2 dmg");
                dmg+=2;
            }
        } else if (hero_type.equalsIgnoreCase("figher")) {
            if (this.type.equalsIgnoreCase("close")) {
                System.out.println("It's super effective, you deal an additional 2 dmg");
                dmg+=2;
            }
        }
        this.health-=dmg;
        return (this.health <= 0);
    }
}