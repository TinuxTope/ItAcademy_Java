package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n01.S05T01N01TomasCristina.model.dto;

import java.util.Arrays;
import java.util.List;

public class CountryEurope {
    public static final List<String> COUNTRIES = Arrays.asList(
            "Austria", "Belgium", "Bulgaria", "Croatia", "Cyprus", "Czech Republic", "Denmark",
            "Estonia", "Finland", "France", "Germany", "Greece", "Hungary", "Ireland", "Italy",
            "Latvia", "Lithuania", "Luxembourg", "Malta", "Netherlands", "Poland", "Portugal",
            "Romania", "Slovakia", "Slovenia", "Spain", "Sweden", "Norway", "Switzerland",
            "Iceland", "Liechtenstein", "Monaco", "San Marino", "Andorra", "Albania",
            "Bosnia and Herzegovina", "Kosovo", "Macedonia", "Moldova", "Montenegro", "Serbia",
            "Ukraine", "Vatican City"
    );

    public static boolean isCountry(String country) {
        return COUNTRIES.contains(country);
    }
}
