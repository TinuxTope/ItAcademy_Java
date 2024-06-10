package TascaS1_05.N1.n1exercici3CristinaTomas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
public class GuardarFichero {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Por favor, proporciona la ruta del directorio como argumento.");
            return;
        }

        String rutaDirectorio = args[0];

        try {
            File archivoSalida = new File("./src/main/java/TascaS1_05/N1/n1exercici3CristinaTomas/resultado_listado.txt");
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoSalida));
            listarDirectorioRecursivo(new File(rutaDirectorio), 0, escritor);
            escritor.close();
            System.out.println("El listado se ha guardado correctamente en resultado_listado.txt");
        } catch (IOException | FileNotFoundException e) {
            System.err.println("¡Ups! Ha ocurrido un error al escribir en el archivo.");
            System.err.println("¡Ups! Ha ocurrido un error al escribir en el archivo: " + e.getMessage());

        }
    }

    public static void listarDirectorioRecursivo(File directorio, int nivel, BufferedWriter escritor) throws IOException, FileNotFoundException {
        if (!directorio.exists() || !directorio.isDirectory()) {
            throw new FileNotFoundException("¡El directorio especificado no existe o no es válido!");
        }

        File[] archivos = directorio.listFiles();
        if (archivos == null) {
            return;
        }

        Arrays.sort(archivos);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        for (File archivo : archivos) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nivel; i++) {
                sb.append("  ");
            }
            sb.append(archivo.isDirectory() ? "Directorio" : "Archivo");
            sb.append(": ");
            sb.append(archivo.getName());
            sb.append(" (Última modificación: ");
            sb.append(sdf.format(new Date(archivo.lastModified())));
            sb.append(")\n");

            escritor.write(sb.toString());

            if (archivo.isDirectory()) {
                listarDirectorioRecursivo(archivo, nivel + 1, escritor);
            }
        }
    }
}
