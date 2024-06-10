package TascaS1_04.N2.n2exercici1CristinaTomas;

import org.junit.Test;
import TascaS1_04.N2.n2exercici1CristinaTomas.LongitudCadenaMatcher;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestMatcher {
    @Test
    public void testLongitudMordor() {
        String mordor = "Mordor";
        assertThat(mordor, LongitudCadenaMatcher.tieneLongitudEsperada());
    }
    @Test
    public void testLongitudCorrecta() {
        String cadena = "Longitud";
        assertThat(cadena, LongitudCadenaMatcher.tieneLongitudEsperada());
    }

    @Test(expected = AssertionError.class)
    public void testLongitudIncorrecta() {
        String cadenaCorta = "Mordor";
        assertThat(cadenaCorta, LongitudCadenaMatcher.tieneLongitudEsperada());
    }

}
