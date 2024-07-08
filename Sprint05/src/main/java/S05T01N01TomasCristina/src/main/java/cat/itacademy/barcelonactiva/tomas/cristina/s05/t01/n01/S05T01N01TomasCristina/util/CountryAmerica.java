package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n01.S05T01N01TomasCristina.util;

import java.util.Arrays;
import java.util.List;

public class CountryAmerica {
    public static final List<String> COUNTRIES = Arrays.asList(
            "antigua and barbuda", "argentina", "bahamas", "barbados", "belize", "bolivia",
            "brazil", "canada", "chile", "colombia", "costa rica", "cuba", "dominica",
            "dominican republic", "ecuador", "el salvador", "grenada", "guatemala", "guyana",
            "haiti", "honduras", "jamaica", "mexico", "nicaragua", "panama", "paraguay", "peru",
            "saint kitts and nevis", "saint lucia", "saint vincent and the grenadines",
            "suriname", "trinidad and tobago", "united states", "uruguay", "venezuela"
    );

    public static boolean isCountry(String country) {
        return COUNTRIES.contains(country.toLowerCase());
    }
}
