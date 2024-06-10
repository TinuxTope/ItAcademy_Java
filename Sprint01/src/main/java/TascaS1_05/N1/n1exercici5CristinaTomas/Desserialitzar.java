package TascaS1_05.N1.n1exercici5CristinaTomas;

import java.io.*;
public class Desserialitzar {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Uso incorrecto. Por favor, proporciona el nombre del objeto y el nombre del archivo como argumentos.");
            return;
        }

        String nomObjeto = args[0];
        String nomArchivo = args[1];

        MyObject objecte = new MyObject(nomObjeto);
        serializarObjeto(objecte, nomArchivo);

        MyObject objetoDeserializado = deserializarObjeto(nomArchivo);
        if (objetoDeserializado != null) {
            System.out.println("Objeto deserializado: " + objetoDeserializado.getNom());
        } else {
            System.err.println("No se pudo deserializar el objeto.");
        }
    }

    public static void serializarObjeto(MyObject objeto, String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(objeto);
            System.out.println("Objeto serializado y guardado en " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al serializar el objeto: " + e.getMessage());
        }
    }

    public static MyObject deserializarObjeto(String nombreArchivo) {
        MyObject objeto = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            objeto = (MyObject) ois.readObject();
            System.out.println("Objeto deserializado desde " + nombreArchivo);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al deserializar el objeto: " + e.getMessage());
        }
        return objeto;
    }
}
