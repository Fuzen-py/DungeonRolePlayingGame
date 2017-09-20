package io.loel;

import java.util.Random;

public class Hero {

    Random rng = new Random();

    private int health = 20;
    private int attack = 10;
    private int accuracy = 10;
    private int evasion = 10;
    private String type;

    public Hero(String type) {
        this.type = type;
    }

    public int attack() {
        int dmgDone = 0;
        int hitCheck = rng.nextInt(15);
        int dmgVariation = rng.nextInt((10)-5);
        if (this.accuracy >= hitCheck) {
            dmgDone = this.attack + dmgVariation;
            System.out.println("Hit for " + dmgDone);
        } else {
            System.out.println("Miss!");
        }
        return dmgDone;
    }

    public boolean flee(String monster_type) {
        int evasion = this.evasion;
        if (this.type.equalsIgnoreCase("rouge")) {
            if (monster_type.equalsIgnoreCase("range")) {
                evasion += 5;
            }
        } else if (this.type.equalsIgnoreCase("mage")) {
            if (monster_type.equalsIgnoreCase("close")) {
                evasion += 5;
            }
        }
        int fleeCheck = rng.nextInt(20);
        if (evasion >= fleeCheck){
            System.out.println("Evasion Successful!");
            return true;
        }
        System.out.println("Evasion Failed!");
        return false;
    }

    public String getType() {
        return this.type;
    }

    public int getHealth() {
        return this.health;
    }

    // Did they die?
    public boolean recieveDMG(int dmg, String dealer_type) {
        if (this.type.equalsIgnoreCase("fighter")) {
            if (dealer_type.equalsIgnoreCase("ranged")) {
                System.out.println("Attack was super effective, an additional 2 health was lost");
                dmg+=2;
            } else if (dealer_type.equalsIgnoreCase("flying")) {
                System.out.println("Attack was super effective, an additional 2 health was lost");
                dmg+=2;
            }
        } else if (this.type.equalsIgnoreCase("magician")) {
            if (dealer_type.equalsIgnoreCase("close")) {
                System.out.println("Attack was super effective, an additional 2 health was lost");
                dmg+=2;
            }
        }
        this.health-=dmg;
        return health>=0;
    }

}
