import junit.framework.*;

public class BoardTest extends TestCase {
    private Board board;

    public BoardTest(String name) {
        super(name);
    }

    public void setUp() {
        board = new Board(5);
    }

    public void testNumberOfNeighbors() {
        board.getCellGrid()[1][1].setStatus(true);
        assertEquals(1, board.computeNeighbors(2,2));
        assertEquals(0, board.computeNeighbors(3,3));
    }

    public void testThreeXThreeEightNeighbors() {
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                board.getCellGrid()[i][j].setStatus(true);
            }
        }
        assertEquals(8, board.computeNeighbors(2, 2));
    }

}