package TascaS1_05.N1.n1exercici1CristinaTomas;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListasDir {
    public static void main(String[] args) {
        String rutaDirectorio;

        if (args.length != 1) {
            rutaDirectorio = obtenerRutaDirectorio();
        } else {
            rutaDirectorio = args[0];
        }

        try {
            List<String> archivos = obtenerContenidoDirectorio(rutaDirectorio);
            if (!archivos.isEmpty()) {
                System.out.println("Contenido del directorio " + rutaDirectorio + ": ");
                for (String archivo : archivos) {
                    System.out.println(archivo);
                }
            } else {
                System.out.println("El directorio está vacío.");
            }
        } catch (IOException e) {
            System.err.println("Error al obtener el contenido del directorio: " + e.getMessage());
        }
    }

    public static String obtenerRutaDirectorio() {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce la ruta del directorio que quieres listar: ");
        String ruta = input.nextLine();
        input.close();
        return ruta;
    }

    public static List<String> obtenerContenidoDirectorio(String rutaDirectorio) throws IOException {
        File directorio = new File(rutaDirectorio);
        if (!directorio.exists() || !directorio.isDirectory()) {
            throw new IllegalArgumentException("La ruta no es un directorio válido.");
        }
        List<String> archivos = new ArrayList<>();
        File[] files = directorio.listFiles();
        if (files != null) {
            for (File archivo : files) {
                archivos.add(archivo.getName());
            }
            Collections.sort(archivos);
        }
        return archivos;
    }
}