package TascaS1_04.N1.n1exercici2CristinaTomas;

public class CalculDni {
    public static char lletraDni(int numDni) {
        if (numDni < 0 || numDni > 99999999) {
            throw new IllegalArgumentException("El número no és correcte.");
        }

        String lletres = "TRWAGMYFPDXBNJZSQVHLCKE";
        int indice = numDni % lletres.length();


        return lletres.charAt(indice);
    }
}
