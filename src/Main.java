import GameSystem.GameFlow;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your player from the list");
        int playerChosen = scanner.nextInt();
        GameFlow game = new GameFlow(playerChosen);
        game.ActivateGame();
    }
}