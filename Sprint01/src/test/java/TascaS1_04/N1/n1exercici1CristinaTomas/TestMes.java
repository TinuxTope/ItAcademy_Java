package TascaS1_04.N1.n1exercici1CristinaTomas;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import static TascaS1_04.N1.n1exercici1CristinaTomas.LlistaMesos.inserirMesos;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestMes {
    private List<Mes> mesos;

    @BeforeEach
    public void setUp(){
        mesos = LlistaMesos.inserirMesos();
    }
    @Test
    public void longitudLlista() {
        List<Mes> mesos = inserirMesos();
        assertEquals(12, mesos.size());
    }
    @Test
    public void testNull(){
        List<Mes> mesos = inserirMesos();
        assertNotNull(mesos);
    }
    @Test
    public void testAgostAPosicio8() {
        List<Mes> mesos = inserirMesos();
        assertEquals("agost", mesos.get(7).getNom());
    }
}
