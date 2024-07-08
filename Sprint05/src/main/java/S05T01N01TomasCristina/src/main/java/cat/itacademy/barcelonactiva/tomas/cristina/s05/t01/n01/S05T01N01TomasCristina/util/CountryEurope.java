package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n01.S05T01N01TomasCristina.util;

import java.util.Arrays;
import java.util.List;

public class CountryEurope {
    public static final List<String> COUNTRIES = Arrays.asList(
            "albania", "andorra", "armenia", "austria", "azerbaijan", "belarus",
            "belgium", "bosnia and herzegovina", "bulgaria", "croatia", "cyprus",
            "czech republic", "denmark", "estonia", "finland", "france", "georgia",
            "germany", "greece", "hungary", "iceland", "ireland", "italy", "kazakhstan",
            "kosovo", "latvia", "liechtenstein", "lithuania", "luxembourg", "malta",
            "moldova", "monaco", "montenegro", "netherlands", "north macedonia", "norway",
            "poland", "portugal", "romania", "russia", "san marino", "serbia", "slovakia",
            "slovenia", "spain", "sweden", "switzerland", "turkey", "ukraine", "united kingdom",
            "vatican city"
    );

    public static boolean isCountry(String country) {
        return COUNTRIES.contains(country.toLowerCase());
    }
}
