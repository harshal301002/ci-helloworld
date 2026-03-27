import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayUtilsTest {

    // -----------------------------------------------------------------------
    // findLast
    // -----------------------------------------------------------------------

    @Test
    public void testFindLastNull() {
        assertThrows(NullPointerException.class, () -> ArrayUtils.findLast(null, 3));
    }

    @Test
    public void testFindLastEmpty() {
        assertEquals(-1, ArrayUtils.findLast(new int[]{}, 3));
    }

    @Test
    public void testFindLastNonExistent() {
        assertEquals(-1, ArrayUtils.findLast(new int[]{1, 2}, 3));
    }

    @Test
    public void testFindLastExistsFirstElement() {
        assertEquals(0, ArrayUtils.findLast(new int[]{2, 3, 5}, 2));
    }

    @Test
    public void testFindLastExistsLastElement() {
        assertEquals(2, ArrayUtils.findLast(new int[]{1, 2, 3}, 3));
    }

    // -----------------------------------------------------------------------
    // oddOrPos
    // -----------------------------------------------------------------------

    @Test
    public void testOddOrPosNull() {
        assertThrows(NullPointerException.class, () -> ArrayUtils.oddOrPos(null));
    }

    @Test
    public void testOddOrPosEmpty() {
        assertEquals(0, ArrayUtils.oddOrPos(new int[]{}));
    }

    @Test
    public void testOddOrPosOddValue() {
        // x[i] % 2 != 0 is true → short-circuit, count++
        assertEquals(1, ArrayUtils.oddOrPos(new int[]{3}));
    }

    @Test
    public void testOddOrPosEvenPositive() {
        // x[i] % 2 != 0 is false, x[i] > 0 is true → count++
        assertEquals(1, ArrayUtils.oddOrPos(new int[]{2}));
    }

    @Test
    public void testOddOrPosEvenNonPositive() {
        // x[i] % 2 != 0 is false, x[i] > 0 is false → no count
        assertEquals(0, ArrayUtils.oddOrPos(new int[]{-2}));
    }

    @Test
    public void testOddOrPosMixed() {
        assertEquals(3, ArrayUtils.oddOrPos(new int[]{-3, -2, 0, 1, 4}));
    }

    // -----------------------------------------------------------------------
    // countOf
    // -----------------------------------------------------------------------

    @Test
    public void testCountOfNull() {
        assertThrows(NullPointerException.class, () -> ArrayUtils.countOf(null, 3));
    }

    @Test
    public void testCountOfEmpty() {
        assertEquals(0, ArrayUtils.countOf(new int[]{}, 5));
    }

    @Test
    public void testCountOfNotFound() {
        // a == target is false → count stays 0
        assertEquals(0, ArrayUtils.countOf(new int[]{1, 2, 3}, 5));
    }

    @Test
    public void testCountOfFound() {
        // a == target is true → count incremented
        assertEquals(2, ArrayUtils.countOf(new int[]{1, 2, 1, 3}, 1));
    }

    @Test
    public void testCountOfAllMatch() {
        assertEquals(3, ArrayUtils.countOf(new int[]{5, 5, 5}, 5));
    }
}
