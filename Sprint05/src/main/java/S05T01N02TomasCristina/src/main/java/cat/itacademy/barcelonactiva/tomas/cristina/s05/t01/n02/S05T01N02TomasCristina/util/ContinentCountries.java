package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n02.S05T01N02TomasCristina.util;

import java.util.Arrays;
import java.util.List;

public class ContinentCountries {
    private static final List<String> EUROPE_COUNTRIES = Arrays.asList(
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

    private static final List<String> AFRICA_COUNTRIES = Arrays.asList(
            "algeria", "angola", "benin", "botswana", "burkina faso", "burundi", "cabo verde",
            "cameroon", "central african republic", "chad", "comoros", "congo", "dr congo",
            "djibouti", "egypt", "equatorial guinea", "eritrea", "eswatini", "ethiopia", "gabon",
            "gambia", "ghana", "guinea", "guinea-bissau", "ivory coast", "kenya", "lesotho",
            "liberia", "libya", "madagascar", "malawi", "mali", "mauritania", "mauritius",
            "morocco", "mozambique", "namibia", "niger", "nigeria", "rwanda", "sao tome and principe",
            "senegal", "seychelles", "sierra leone", "somalia", "south africa", "south sudan",
            "sudan", "tanzania", "togo", "tunisia", "uganda", "zambia", "zimbabwe"
    );

    private static final List<String> ASIA_COUNTRIES = Arrays.asList(
            "afghanistan", "armenia", "azerbaijan", "bahrain", "bangladesh", "bhutan", "brunei",
            "cambodia", "china", "cyprus", "georgia", "india", "indonesia", "iran", "iraq",
            "israel", "japan", "jordan", "kazakhstan", "kuwait", "kyrgyzstan", "laos", "lebanon",
            "malaysia", "maldives", "mongolia", "myanmar", "nepal", "north korea", "oman",
            "pakistan", "palestine", "philippines", "qatar", "saudi arabia", "singapore",
            "south korea", "sri lanka", "syria", "taiwan", "tajikistan", "thailand", "timor-leste",
            "turkey", "turkmenistan", "united arab emirates", "uzbekistan", "vietnam", "yemen"
    );

    private static final List<String> AMERICA_COUNTRIES = Arrays.asList(
            "antigua and barbuda", "argentina", "bahamas", "barbados", "belize", "bolivia",
            "brazil", "canada", "chile", "colombia", "costa rica", "cuba", "dominica",
            "dominican republic", "ecuador", "el salvador", "grenada", "guatemala", "guyana",
            "haiti", "honduras", "jamaica", "mexico", "nicaragua", "panama", "paraguay", "peru",
            "saint kitts and nevis", "saint lucia", "saint vincent and the grenadines",
            "suriname", "trinidad and tobago", "united states", "uruguay", "venezuela"
    );

    private static final List<String> OCEANIA_COUNTRIES = Arrays.asList(
            "australia", "fiji", "kiribati", "marshall islands", "micronesia", "nauru", "new zealand",
            "palau", "papua new guinea", "samoa", "solomon islands", "tonga", "tuvalu", "vanuatu"
    );

    public static String getContinent(String country) {
        if (EUROPE_COUNTRIES.contains(country.toLowerCase())) {
            return "Europe";
        } else if (AFRICA_COUNTRIES.contains(country.toLowerCase())) {
            return "Africa";
        } else if (ASIA_COUNTRIES.contains(country.toLowerCase())) {
            return "Asia";
        } else if (AMERICA_COUNTRIES.contains(country.toLowerCase())) {
            return "America";
        } else if (OCEANIA_COUNTRIES.contains(country.toLowerCase())) {
            return "Oceania";
        } else {
            return "Unknown";
        }
    }
}
