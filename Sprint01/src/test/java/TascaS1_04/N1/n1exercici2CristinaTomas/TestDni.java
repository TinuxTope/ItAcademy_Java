package TascaS1_04.N1.n1exercici2CristinaTomas;


import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TestDni {
    @ParameterizedTest
    @ValueSource(ints = {60011686, 87066953, 26606639, 74288256, 37621064})
    public void lletraCorrecta(int dniNumber) {
        char[] expectedLetters = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        char calculatedLetter = CalculDni.lletraDni(dniNumber);
        int index = dniNumber % 23;
        assertEquals(expectedLetters[index], calculatedLetter);
    }

    @Test
    public void noCorrecto() {
        int invalidDniNumber = 100000000;
        assertThrows(IllegalArgumentException.class, () -> CalculDni.lletraDni(invalidDniNumber));
    }
}
