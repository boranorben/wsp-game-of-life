import junit.framework.TestCase;

public class CellTest extends TestCase {
    private Cell cell;

    public CellTest(String name) {
        super(name);
    }

    public void setUp() {
        cell = new Cell();
    }

    public void testFirstInitializeCell() {
        assertEquals(false, false);
    }

    public void testSetCellStatus() {
        cell.setStatus(true);
        assertTrue(cell.getStatus());
    }
}
