package TascaS1_04.N3.n3exercici2CristinaTomas;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import org.junit.Test;
public class Diferencies {
@Test
    public void equals(){
        Object piano = new Object();
        Object instrument = piano;

        assertSame(piano,instrument);
    }

    public void different(){
    Object flauta = new Object();
    Object guitarra = new Object();

    assertNotSame(flauta,guitarra);
    }
}
