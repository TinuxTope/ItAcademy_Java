package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n01.S05T01N01TomasCristina.model.dto;

import java.util.Arrays;
import java.util.List;

public class CountryOceania {
    public static final List<String> COUNTRIES = Arrays.asList(
            "australia", "fiji", "kiribati", "marshall islands", "micronesia", "nauru", "new zealand",
            "palau", "papua new guinea", "samoa", "solomon islands", "tonga", "tuvalu", "vanuatu"
    );

    public static boolean isCountry(String country) {
        return COUNTRIES.contains(country.toLowerCase());
    }
}
