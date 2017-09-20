package io.loel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game(choseHero(scanner));
        game.play();
    }

    private static Hero choseHero(Scanner scanner) {
        System.out.println("0 - Rouge\n1 - Magician\n2 - Fighter");
        Hero player;
        switch (scanner.nextInt()){
            case 0: return new Hero("Rouge");
            case 1: return new Hero("Magician");
            case 2: return new Hero("Fighter");
            default:
                System.out.println("Invalid option.");
                return choseHero(scanner);

        }
    }
}
