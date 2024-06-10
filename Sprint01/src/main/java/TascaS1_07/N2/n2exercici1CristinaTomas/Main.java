package TascaS1_07.N2.n2exercici1CristinaTomas;

import java.io.IOException;
import java.nio.file.Path;
import java.io.File;
import static java.nio.file.Path.of;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
           serialitzadorJson();
    }
    public static void serialitzadorJson(){
        Treballador treballador = new Treballador("Tina", "Tomás", 25);
        Path path = of(treballador.getClass().getAnnotation(JsonSerializable.class).nomArxiu());

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(String.valueOf(path)), treballador);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
