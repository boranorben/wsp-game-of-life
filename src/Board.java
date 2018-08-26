public class Board {
    private Cell[][] cellGrid;
    private int cellGridSize;

    public Board(int size) {
        cellGridSize = size;
        cellGrid = new Cell[cellGridSize][cellGridSize];
        for (int i = 0; i < cellGridSize; i++) {
            for (int j = 0; j < cellGridSize; j++) {
                cellGrid[i][j] = new Cell();
            }
        }
    }

    public Cell[][] getCellGrid() {
        return cellGrid;
    }

    public int computeNeighbors(int posX, int posY) {
        int neighbors = 0;
        if (posX != 0 && posY != 0 && posX != cellGridSize - 1 && posY != cellGridSize - 1) {
            neighbors += convertStatusToInt(posX - 1, posY - 1);
            neighbors += convertStatusToInt(posX, posY - 1);
            neighbors += convertStatusToInt(posX + 1, posY - 1);
            neighbors += convertStatusToInt(posX - 1, posY);
            neighbors += convertStatusToInt(posX + 1, posY);
            neighbors += convertStatusToInt(posX - 1, posY + 1);
            neighbors += convertStatusToInt(posX, posY + 1);
            neighbors += convertStatusToInt(posX + 1, posY + 1);
        }
        return neighbors;
    }

    public int convertStatusToInt(int posX, int posY) {
        return (cellGrid[posX][posY].getStatus()) ? 1 : 0;
    }
}
