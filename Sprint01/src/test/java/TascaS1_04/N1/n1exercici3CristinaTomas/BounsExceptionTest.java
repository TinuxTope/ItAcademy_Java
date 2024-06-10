package TascaS1_04.N1.n1exercici3CristinaTomas;

import org.junit.Test;
import TascaS1_04.N1.n1exercici3CristinaTomas.BoundsException;
import static org.junit.Assert.assertThrows;

public class BounsExceptionTest {
    @Test
    public void testThrowExceptionWithAssertThrows() {
        BoundsException example = new BoundsException();
        assertThrows(ArrayIndexOutOfBoundsException.class, example::generateArrayBounds);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testThrowExceptionWithExpected() {
        BoundsException example = new BoundsException();
        example.generateArrayBounds();
    }
}
