import java.util.Scanner;

public class Game {
    private Board board;
    private int boardSize;

    public Game(int size) {
        board = new Board(size);
        boardSize = size;
    }

    public Board getBoard() {
        return board;
    }

    public void gameLogic() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                int neighbors = getBoard().computeNeighbors(i, j);
                if (getBoard().getCellStatus(i, j)) {
                    if (neighbors < 2 || neighbors > 3) {
                        System.out.println("die: " + i + "," + j + " = " + neighbors);
                        getBoard().setCellChanged(i, j, true);
                    } else {
                        System.out.println("still alive: " + i + "," + j + " = " + neighbors);
                    }
                } else {
                    if (neighbors == 3) {
                        System.out.println("born: " + i + "," + j + " = " + neighbors);
                        getBoard().setCellChanged(i, j, true);
                    }
                }
            }
        }
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (getBoard().getCellChange(i, j)) {
                    System.out.print("x: " + i + ",y: " + j + " change from " + getBoard().getCellStatus(i, j));
                    getBoard().switchStatus(i, j);
                    System.out.println(" to " + getBoard().getCellStatus(i, j));
                    getBoard().setCellChanged(i, j,false);
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game(17);
        game.getBoard().switchStatus(4, 2);
        game.getBoard().switchStatus(5, 2);
        game.getBoard().switchStatus(6, 2);
        game.getBoard().switchStatus(10, 2);
        game.getBoard().switchStatus(11, 2);
        game.getBoard().switchStatus(12, 2);
        game.getBoard().switchStatus(2, 4);
        game.getBoard().switchStatus(2, 5);
        game.getBoard().switchStatus(2, 6);
        game.getBoard().switchStatus(7, 4);
        game.getBoard().switchStatus(7, 5);
        game.getBoard().switchStatus(7, 6);
        game.getBoard().switchStatus(9, 4);
        game.getBoard().switchStatus(9, 5);
        game.getBoard().switchStatus(9, 6);
        game.getBoard().switchStatus(14, 4);
        game.getBoard().switchStatus(14, 5);
        game.getBoard().switchStatus(14, 6);
        game.getBoard().switchStatus(4, 7);
        game.getBoard().switchStatus(5, 7);
        game.getBoard().switchStatus(6, 7);
        game.getBoard().switchStatus(10, 7);
        game.getBoard().switchStatus(11, 7);
        game.getBoard().switchStatus(12, 7);
        game.getBoard().switchStatus(4, 9);
        game.getBoard().switchStatus(5, 9);
        game.getBoard().switchStatus(6, 9);
        game.getBoard().switchStatus(10, 9);
        game.getBoard().switchStatus(11, 9);
        game.getBoard().switchStatus(12, 9);
        game.getBoard().switchStatus(2, 10);
        game.getBoard().switchStatus(2, 11);
        game.getBoard().switchStatus(2, 12);
        game.getBoard().switchStatus(7, 10);
        game.getBoard().switchStatus(7, 11);
        game.getBoard().switchStatus(7, 12);
        game.getBoard().switchStatus(9, 10);
        game.getBoard().switchStatus(9, 11);
        game.getBoard().switchStatus(9, 12);
        game.getBoard().switchStatus(14, 10);
        game.getBoard().switchStatus(14, 11);
        game.getBoard().switchStatus(14, 12);
        game.getBoard().switchStatus(4, 14);
        game.getBoard().switchStatus(5, 14);
        game.getBoard().switchStatus(6, 14);
        game.getBoard().switchStatus(10, 14);
        game.getBoard().switchStatus(11, 14);
        game.getBoard().switchStatus(12, 14);
        for (int s = 0; s < 3; s++) {
            for (int i = 0; i < 17; i++) {
                System.out.println();
                for (int j = 0; j < 17; j++) {
                    if (game.getBoard().getCellStatus(i, j)) {
                        System.out.print("x ");
                    } else {
                        System.out.print("  ");
                    }
                }
            }
            scanner.nextLine();
            game.gameLogic();
        }
    }
}
