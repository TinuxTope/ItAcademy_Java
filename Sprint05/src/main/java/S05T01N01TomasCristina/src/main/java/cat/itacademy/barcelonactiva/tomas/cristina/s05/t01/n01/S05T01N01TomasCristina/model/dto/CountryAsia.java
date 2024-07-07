package S05T01N01TomasCristina.src.main.java.cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n01.S05T01N01TomasCristina.model.dto;

import java.util.Arrays;
import java.util.List;

public class CountryAsia {
    public static final List<String> COUNTRIES = Arrays.asList(
            "afghanistan", "armenia", "azerbaijan", "bahrain", "bangladesh", "bhutan", "brunei",
            "cambodia", "china", "cyprus", "georgia", "india", "indonesia", "iran", "iraq",
            "israel", "japan", "jordan", "kazakhstan", "kuwait", "kyrgyzstan", "laos", "lebanon",
            "malaysia", "maldives", "mongolia", "myanmar", "nepal", "north korea", "oman",
            "pakistan", "palestine", "philippines", "qatar", "saudi arabia", "singapore",
            "south korea", "sri lanka", "syria", "taiwan", "tajikistan", "thailand", "timor-leste",
            "turkey", "turkmenistan", "united arab emirates", "uzbekistan", "vietnam", "yemen"
    );

    public static boolean isCountry(String country) {
        return COUNTRIES.contains(country.toLowerCase());
    }
}
