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

    public int computeNeighbors(int posX, int posY) {
        int neighbors = 0;
        if (posX != 0 && posY != 0 && posX != cellGridSize - 1 && posY != cellGridSize - 1) {
            neighbors += cellGrid[posX-1][posY-1].getStatusInInt();
            neighbors += cellGrid[posX][posY-1].getStatusInInt();
            neighbors += cellGrid[posX+1][posY-1].getStatusInInt();
            neighbors += cellGrid[posX-1][posY].getStatusInInt();
            neighbors += cellGrid[posX+1][posY].getStatusInInt();
            neighbors += cellGrid[posX-1][posY+1].getStatusInInt();
            neighbors += cellGrid[posX][posY+1].getStatusInInt();
            neighbors += cellGrid[posX+1][posY+1].getStatusInInt();
        }
        return neighbors;
    }

    public boolean getCellStatus(int posX, int posY) {
        return cellGrid[posX][posY].getStatus();
    }

    public boolean getCellChange(int posX, int posY) {
        return cellGrid[posX][posY].getChanged();
    }

    public void setCellChanged(int posX, int posY, boolean isChanged) {
        cellGrid[posX][posY].setChange(isChanged);
    }

    public void switchStatus(int posX, int posY) {
        Cell cell = cellGrid[posX][posY];
        if (cell.getStatus()) {
            cell.setStatus(false);
        } else {
            cell.setStatus(true);
        }
    }
}
