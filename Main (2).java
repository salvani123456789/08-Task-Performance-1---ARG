import java.util.Scanner;

interface GameMode {
    void displayGameModes();
    void selectGameMode(int mode);
}

interface GameStart {
    void startGame();
}

interface PlayerActions {
    void setPlayerName(String name);
}

class TextGame implements GameMode, GameStart, PlayerActions {
    private String playerName;
    private String selectedMode;

    @Override
    public void setPlayerName(String name) {
        this.playerName = name;
    }

    @Override
    public void displayGameModes() {
        System.out.println("Press 1 or 2 to select your game mode.");
        System.out.println("1 - Story");
        System.out.println("2 - Survival");
    }

    @Override
    public void selectGameMode(int mode) {
        if (mode == 1) {
            selectedMode = "Story";
        } else if (mode == 2) {
            selectedMode = "Survival";
        } else {
            selectedMode = "Unknown";
        }
    }

    @Override
    public void startGame() {
        System.out.println("Press P to start playing, " + playerName + ".");
        System.out.println("Starting " + selectedMode + " mode...");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextGame game = new TextGame();

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        game.setPlayerName(name);

        game.displayGameModes();
        System.out.print("Enter your choice: ");
        int mode = scanner.nextInt();
        game.selectGameMode(mode);

        System.out.print("Press P to start playing: ");
        char start = scanner.next().charAt(0);
        if (start == 'P' || start == 'p') {
            game.startGame();
        } else {
            System.out.println("Invalid input. Exiting game.");
        }

        scanner.close();
    }
}