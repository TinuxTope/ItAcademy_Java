package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n01.S05T01N01TomasCristina.model.dto;

import java.util.Arrays;
import java.util.List;

public class CountryAmerica {
    public static final List<String> COUNTRIES = Arrays.asList(
            "Antigua and Barbuda", "Argentina", "Bahamas", "Barbados", "Belize", "Bolivia",
            "Brazil", "Canada", "Chile", "Colombia", "Costa Rica", "Cuba", "Dominica",
            "Dominican Republic", "Ecuador", "El Salvador", "Grenada", "Guatemala", "Guyana",
            "Haiti", "Honduras", "Jamaica", "Mexico", "Nicaragua", "Panama", "Paraguay", "Peru",
            "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines",
            "Suriname", "Trinidad and Tobago", "United States", "Uruguay", "Venezuela"
    );

    public static boolean isCountry(String country) {
        return COUNTRIES.contains(country);
    }
}
