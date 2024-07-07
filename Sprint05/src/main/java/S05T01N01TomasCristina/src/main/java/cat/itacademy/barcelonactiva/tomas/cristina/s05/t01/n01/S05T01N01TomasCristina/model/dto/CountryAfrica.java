package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n01.S05T01N01TomasCristina.model.dto;

import java.util.Arrays;
import java.util.List;

public class CountryAfrica {
    public static final List<String> COUNTRIES = Arrays.asList(
            "algeria", "angola", "benin", "botswana", "burkina faso", "burundi", "cabo verde",
            "cameroon", "central african republic", "chad", "comoros", "congo", "dr congo",
            "djibouti", "egypt", "equatorial guinea", "eritrea", "eswatini", "ethiopia", "gabon",
            "gambia", "ghana", "guinea", "guinea-bissau", "ivory coast", "kenya", "lesotho",
            "liberia", "libya", "madagascar", "malawi", "mali", "mauritania", "mauritius",
            "morocco", "mozambique", "namibia", "niger", "nigeria", "rwanda", "sao tome and principe",
            "senegal", "seychelles", "sierra leone", "somalia", "south africa", "south sudan",
            "sudan", "tanzania", "togo", "tunisia", "uganda", "zambia", "zimbabwe"
    );

    public static boolean isCountry(String country) {
        return COUNTRIES.contains(country.toLowerCase());
    }
}
