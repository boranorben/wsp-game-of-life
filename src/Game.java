import java.util.Random;
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

    public void switchCellStatus(int posX, int posY) {
        if (getCellStatus(posX, posY)) {
            setCellStatus(posX, posY, false);
        } else {
            setCellStatus(posX, posY, true);
        }
    }

    public void setCellStatus(int posX, int posY, boolean status) {
        getBoard().getCellGrid()[posX][posY].setStatus(status);
    }

    public boolean getCellStatus(int posX, int posY) {
        return getBoard().getCellGrid()[posX][posY].getStatus();
    }

    public int getCellNeighbors(int posX, int posY) {
        return getBoard().computeNeighbors(posX, posY);
    }

    public void setCellChanged(int posX, int posY, boolean isChanged) {
        getBoard().getCellGrid()[posX][posY].setChange(isChanged);
    }

    public boolean getCellChanged(int posX, int posY) {
        return getBoard().getCellGrid()[posX][posY].getChanged();
    }

    public void randomInitialCell() {
        Random random = new Random();
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                int rand = random.nextInt(boardSize + 1) + 1;
                if (j == rand) {
                    switchCellStatus(i,j);
                }
            }
        }
    }

    public void gameLogic() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                int neighbors = getCellNeighbors(i, j);
                if (getCellStatus(i, j)) {
                    if (neighbors < 2 || neighbors > 3) {
                        setCellChanged(i, j, true);
                    }
                } else {
                    if (neighbors == 3) {
                        setCellChanged(i, j, true);
                    }
                }
            }
        }
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (getCellChanged(i, j)) {
                    switchCellStatus(i, j);
                    setCellChanged(i, j, false);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game(10);
        game.randomInitialCell();
        for (int s = 0; s < 5; s++) {
            for (int i = 0; i < 10; i++) {
                System.out.println();
                for (int j = 0; j < 10; j++) {
                    if (game.getCellStatus(i, j)) {
                        System.out.print("x ");
                    } else {
                        System.out.print("  ");
                    }
                }
            }
            game.gameLogic();
            scanner.nextLine();
        }
    }
}
