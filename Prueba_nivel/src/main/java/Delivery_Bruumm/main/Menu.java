package Delivery_Bruumm.main;

import Delivery_Bruumm.acciones.Pedido;
import Delivery_Bruumm.acciones.Producto;
import Delivery_Bruumm.enums.TipoProducto;
import Delivery_Bruumm.logica.GestorPedidos;
import Delivery_Bruumm.personas.Cliente;
import Delivery_Bruumm.personas.Repartidor;
import Delivery_Bruumm.util.CustomException;
import Delivery_Bruumm.util.Entry;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private GestorPedidos gestorPedidos;

    public Menu() {
        this.gestorPedidos = new GestorPedidos();
    }

    public void mostrarMenu() {
        try (Scanner input = new Scanner(System.in)) {
            boolean salir = false;
            while (!salir) {
                System.out.println("1 - Crear un nuevo pedido");
                System.out.println("2 - Marcar un pedido como entregado");
                System.out.println("3 - Listar los pedidos pendientes");
                System.out.println("4 - Listar los pedidos entregados");
                System.out.println("5 - Salir");

                int opcion = Entry.readInt("Seleccione una opción: ", input);

                try {
                    switch (opcion) {
                        case 1 -> crearPedido(input);
                        case 2 -> marcarPedidoComoEntregado(input);
                        case 3 -> listarPedidosPendientes();
                        case 4 -> listarPedidosEntregados();
                        case 5 -> salir = true;
                        default -> System.out.println("Opción no válida.");
                    }
                } catch (CustomException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (InputMismatchException e) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número.");
                    input.next(); // clear the invalid input
                } catch (Exception e) {
                    System.out.println("Error desconocido: " + e.getMessage());
                }
            }
        }
    }

    private void crearPedido(Scanner input) throws CustomException {
        String nombreCliente = Entry.readString("Nombre del cliente: ", input);
        String direccionCliente = Entry.readString("Dirección del cliente: ", input);
        Cliente cliente = new Cliente(nombreCliente, direccionCliente);

        List<Producto> productos = new ArrayList<>();
        boolean agregarMas = true;

        while (agregarMas) {
            try {
                int tipoProducto = Entry.readInt("Tipo de producto (1-Burrito, 2-Hamburguesa, 3-Kebab, 4-Pizza): ", input);
                TipoProducto tipo = TipoProducto.values()[tipoProducto - 1];
                productos.add(new Producto(tipo, tipo.getPrecio()));

                System.out.print("¿Desea agregar otro producto? (1-Sí, 2-No): ");
                agregarMas = Entry.readInt("", input) == 1;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Tipo de producto no válido. Por favor, intente de nuevo.");
            }
        }

        List<Repartidor> repartidoresDisponibles = gestorPedidos.getRepartidoresDisponibles();
        if (repartidoresDisponibles.isEmpty()) {
            throw new CustomException("No hay repartidores disponibles.");
        }

        System.out.println("Modos de reparto disponibles:");
        for (int i = 0; i < repartidoresDisponibles.size(); i++) {
            System.out.println((i + 1) + " - " + repartidoresDisponibles.get(i).getModo());
        }

        try {
            int modoReparto = Entry.readInt("Seleccione un modo de reparto: ", input);
            Repartidor repartidorSeleccionado = repartidoresDisponibles.get(modoReparto - 1);
            gestorPedidos.crearPedido(cliente, productos, repartidorSeleccionado);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Modo de reparto no válido. Por favor, intente de nuevo.");
        }
    }

    private void marcarPedidoComoEntregado(Scanner input) throws CustomException {
        int idPedido = Entry.readInt("ID del pedido a marcar como entregado: ", input);
        gestorPedidos.marcarPedidoComoEntregado(idPedido);
    }

    private void listarPedidosPendientes() {
        List<Pedido> pedidosPendientes = gestorPedidos.listarPedidosPendientes();
        if (pedidosPendientes.isEmpty()) {
            System.out.println("No hay pedidos pendientes.");
        } else {
            pedidosPendientes.forEach(System.out::println);
        }
    }

    private void listarPedidosEntregados() {
        List<Pedido> pedidosEntregados = gestorPedidos.listarPedidosEntregados();
        if (pedidosEntregados.isEmpty()) {
            System.out.println("No hay pedidos entregados.");
        } else {
            pedidosEntregados.forEach(System.out::println);
        }
    }
}
