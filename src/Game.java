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

    public void gameLogic() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                int neighbors = getCellNeighbors(i, j);
                if (getCellStatus(i, j)) {
                    if (neighbors < 2 || neighbors > 3) {
                        System.out.println("die: (" + i + "," + j + ") = " + neighbors);
                        setCellChanged(i, j, true);
                    } else {
                        System.out.println("still alive: (" + i + "," + j + ") = " + neighbors);
                    }
                } else {
                    if (neighbors == 3) {
                        System.out.println("born: (" + i + "," + j + ") = " + neighbors);
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
        Game game = new Game(17);
        game.switchCellStatus(4, 2);
        game.switchCellStatus(5, 2);
        game.switchCellStatus(6, 2);
        game.switchCellStatus(10, 2);
        game.switchCellStatus(11, 2);
        game.switchCellStatus(12, 2);
        game.switchCellStatus(2, 4);
        game.switchCellStatus(2, 5);
        game.switchCellStatus(2, 6);
        game.switchCellStatus(7, 4);
        game.switchCellStatus(7, 5);
        game.switchCellStatus(7, 6);
        game.switchCellStatus(9, 4);
        game.switchCellStatus(9, 5);
        game.switchCellStatus(9, 6);
        game.switchCellStatus(14, 4);
        game.switchCellStatus(14, 5);
        game.switchCellStatus(14, 6);
        game.switchCellStatus(4, 7);
        game.switchCellStatus(5, 7);
        game.switchCellStatus(6, 7);
        game.switchCellStatus(10, 7);
        game.switchCellStatus(11, 7);
        game.switchCellStatus(12, 7);
        game.switchCellStatus(4, 9);
        game.switchCellStatus(5, 9);
        game.switchCellStatus(6, 9);
        game.switchCellStatus(10, 9);
        game.switchCellStatus(11, 9);
        game.switchCellStatus(12, 9);
        game.switchCellStatus(2, 10);
        game.switchCellStatus(2, 11);
        game.switchCellStatus(2, 12);
        game.switchCellStatus(7, 10);
        game.switchCellStatus(7, 11);
        game.switchCellStatus(7, 12);
        game.switchCellStatus(9, 10);
        game.switchCellStatus(9, 11);
        game.switchCellStatus(9, 12);
        game.switchCellStatus(14, 10);
        game.switchCellStatus(14, 11);
        game.switchCellStatus(14, 12);
        game.switchCellStatus(4, 14);
        game.switchCellStatus(5, 14);
        game.switchCellStatus(6, 14);
        game.switchCellStatus(10, 14);
        game.switchCellStatus(11, 14);
        game.switchCellStatus(12, 14);
        for (int s = 0; s < 3; s++) {
            for (int i = 0; i < 17; i++) {
                System.out.println();
                for (int j = 0; j < 17; j++) {
                    if (game.getCellStatus(i, j)) {
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
