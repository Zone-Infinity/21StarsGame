import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int stars = 21;
        System.out.println("LET'S TALK ABOUT THE RULES OF THE GAME");
        System.out.println("There are 21 STARS.");
        System.out.println("You may pick 1, 2, 3, or 4 STARS.");
        System.out.println("Whoever is forced to pick the LAST STAR loses the game.\n");

        while (true) {
            System.out.println("\nThere are " + stars + " stars left.");
            System.out.print("Pick stars (1–4): ");

            int playerPick = sc.nextInt();

            if (playerPick < 1 || playerPick > 4) {
                System.out.println("Invalid choice! Pick between 1 and 4.");
                continue;
            }
            if (playerPick > stars) {
                System.out.println("You cannot pick more stars than are left!");
                continue;
            }

            stars -= playerPick;

            // Player loses if they pick the last star.
            if (stars == 0) {
                System.out.println("You picked the last star. YOU LOSE!");
                break;
            }

            // Computer picks (perfect strategy: total of 5 each round)
            int computerPick = 5 - playerPick;

            // But if fewer stars left, adjust
            if (computerPick > stars) {
                computerPick = stars;
            }

            System.out.println("Computer picks: " + computerPick);
            stars -= computerPick;

            // Computer loses if it takes the last star
            if (stars == 0) {
                System.out.println("Computer picked the last star. COMPUTER LOSES!\nYou Win!");
                break;
            }
        }
    }
}