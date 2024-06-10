package TascaS1_07.N2.n2exercici1CristinaTomas;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface JsonSerializable {
    String nomArxiu() default "src/main/java/TascaS1_07/N2/n2exercici1CristinaTomas/Objecte.json";

}
