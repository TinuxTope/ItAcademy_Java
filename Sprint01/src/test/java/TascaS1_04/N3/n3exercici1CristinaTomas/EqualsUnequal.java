package TascaS1_04.N3.n3exercici1CristinaTomas;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class EqualsUnequal {
    @Test
    public void testEquals() {
        Integer num1 = 5;
        Integer num2 = 5;

        assertEquals(num1,num2);
    }

    @Test
    public void testUnequal() {
        Integer num1 = 5;
        Integer num2 = 8;

        Assert.assertNotEquals(num1,num2);

    }
}
