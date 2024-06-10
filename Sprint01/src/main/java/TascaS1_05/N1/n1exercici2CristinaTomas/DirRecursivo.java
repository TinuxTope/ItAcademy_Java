package TascaS1_05.N1.n1exercici2CristinaTomas;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


public class DirRecursivo {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Por favor, proporciona la ruta del directorio como argumento.");
            return;
        }

        String rutaDirectorio = args[0];

        try {
            listarDirectorioRecursivo(new File(rutaDirectorio), 0);
        } catch (FileNotFoundException e) {
            System.err.println("Ups! el directorio no existe.");
        }
    }

    public static void listarDirectorioRecursivo(File directorio, int nivel) throws FileNotFoundException {
        if (!directorio.exists() || !directorio.isDirectory()) {
            throw new FileNotFoundException("El directorio especificado no existe o no es válido.");
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
            sb.append(")");

            System.out.println(sb.toString());

            if (archivo.isDirectory()) {
                listarDirectorioRecursivo(archivo, nivel + 1);
            }
        }
    }
}