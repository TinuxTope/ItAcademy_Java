package TascaS1_04.N2.n2exercici1CristinaTomas;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import static org.hamcrest.CoreMatchers.equalTo;

public class LongitudCadenaMatcher extends FeatureMatcher<String, Integer> {
    private static final Matcher<Integer> subMatcher = equalTo(8);
    @Override
    protected Integer featureValueOf(String cadena) {
        return cadena.length();
    }

    public LongitudCadenaMatcher() {
        super(subMatcher, "una cadena con la longitud esperada", "longitud de la cadena");
    }

    public static Matcher<String> tieneLongitudEsperada() {
        return new LongitudCadenaMatcher();
    }
}

