import junit.framework.TestCase;

public class GameTest extends TestCase {
    private Game game;

    public GameTest(String name) {
        super(name);
    }

    public void setUp() {
        game = new Game(5);
    }

    public void testASingleCellShouldDie() {
        game.switchCellStatus(2,2);
        game.gameLogic();
        assertEquals(0, game.getCellNeighbors(2,2));
        assertFalse(game.getCellStatus(2,2));
    }

    public void testLivedCellHasMoreThanThreeNeighbors() {
        game.switchCellStatus(1,1);
        game.switchCellStatus(1,2);
        game.switchCellStatus(1,3);
        game.switchCellStatus(2,2);
        game.switchCellStatus(2,3);
        assertEquals(4, game.getCellNeighbors(1,2));
        assertEquals(4, game.getCellNeighbors(2,2));
        game.gameLogic();
        assertFalse(game.getCellStatus(1,2));
        assertFalse(game.getCellStatus(2,2));
    }

    public void testDeadCellHasThreeNeighbors() {
        game.switchCellStatus(1,2);
        game.switchCellStatus(2,2);
        game.switchCellStatus(3,2);
        assertEquals(3, game.getCellNeighbors(2,1));
        assertEquals(3, game.getCellNeighbors(2,3));
        game.gameLogic();
        assertTrue(game.getCellStatus(2,1));
        assertTrue(game.getCellStatus(2,3));
    }

    public void testLivedCellHasTwoOrThreeNeighbors() {
        game.switchCellStatus(2,1);
        game.switchCellStatus(2,3);
        game.switchCellStatus(1,2);
        game.switchCellStatus(3,2);
        assertEquals(2, game.getCellNeighbors(2,1));
        assertEquals(2, game.getCellNeighbors(2,3));
        assertEquals(2, game.getCellNeighbors(1,2));
        assertEquals(2, game.getCellNeighbors(3,2));
        game.gameLogic();
        assertEquals(2, game.getCellNeighbors(2,1));
        assertEquals(2, game.getCellNeighbors(2,3));
        assertEquals(2, game.getCellNeighbors(1,2));
        assertEquals(2, game.getCellNeighbors(3,2));
    }

    public void testDeadCellHasNoNeighbors() {
        game.switchCellStatus(1,1);
        game.switchCellStatus(1,2);
        game.switchCellStatus(1,3);
        assertEquals(2, game.getCellNeighbors(2,1));
        assertEquals(2, game.getCellNeighbors(2,3));
        assertEquals(0, game.getCellNeighbors(3,3));
        game.gameLogic();
        assertFalse(game.getCellStatus(1,1));
        assertTrue(game.getCellStatus(1,2));
        assertFalse(game.getCellStatus(1,3));
        assertFalse(game.getCellStatus(3,3));
    }
}
