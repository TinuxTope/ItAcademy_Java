package TascaS1_05.N1.n1exercici4CristinaTomas;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class Llegir {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Por favor, proporciona la ruta del archivo TXT como argumento.");
            return;
        }

        String rutaArchivo = args[0];

        try {
            mostrarContenidoArchivo(rutaArchivo);
        } catch (IOException e) {
            System.err.println("¡Ups! Ha ocurrido un error al leer el archivo.");
        }
    }

    public static void mostrarContenidoArchivo(String rutaArchivo) throws IOException {
        File archivo = new File(rutaArchivo);
        BufferedReader lector = new BufferedReader(new FileReader(archivo));

        String linea;
        System.out.println("Contenido del archivo " + rutaArchivo + ":\n");
        while ((linea = lector.readLine()) != null) {
            System.out.println(linea);
        }

        lector.close();
    }
}
