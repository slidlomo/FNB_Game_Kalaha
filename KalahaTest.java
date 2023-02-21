import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KalahaTest {
        private Kalaha kalaha;

        @BeforeEach
        public void setup() {
            kalaha = new Kalaha();
        }

        @Test
        public void testInitialBoard() {
            int[] expectedPits = {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
            Assertions.assertArrayEquals(expectedPits, kalaha.getPits());
            int[] expectedKalaha = {0, 0};
            Assertions.assertArrayEquals(expectedKalaha, kalaha.getKalaha());
            Assertions.assertEquals(0, kalaha.getCurrentPlayer());

        }

        @Test
        public void testInvalidMove() {
            Assertions.assertFalse(kalaha.makeMove(-1));
            Assertions.assertFalse(kalaha.makeMove(12));
            Assertions.assertFalse(kalaha.makeMove(0));
            Assertions.assertFalse(kalaha.makeMove(1));
            kalaha.makeMove(0);
            kalaha.makeMove(6);
            kalaha.makeMove(7);
            Assertions.assertFalse(kalaha.makeMove(6));
            Assertions.assertFalse(kalaha.makeMove(7));
        }

        @Test
        public void testSimpleMove() {
            kalaha.makeMove(0);
            int[] expectedPits = {0, 5, 5, 5, 5, 4, 4, 4, 4, 4, 4, 4};
            Assertions.assertArrayEquals(expectedPits, kalaha.getPits());
        }
    }

