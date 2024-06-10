package Delivery_Bruumm.logica;

import Delivery_Bruumm.acciones.Pedido;
import Delivery_Bruumm.acciones.Producto;
import Delivery_Bruumm.empresa.Empresa;
import Delivery_Bruumm.enums.TipoProducto;
import Delivery_Bruumm.personas.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionPedidos {
    private Empresa empresa;
    private Scanner input;

    public GestionPedidos() {
        this.empresa = new Empresa();
        this.input = new Scanner(System.in);
    }

    public void mostrarMenu() {
        boolean salir = false;
        while (!salir) {
            System.out.println("1 - Crear un nuevo pedido");
            System.out.println("2 - Marcar un pedido como entregado");
            System.out.println("3 - Listar los pedidos pendientes");
            System.out.println("4 - Listar los pedidos entregados");
            System.out.println("5 - Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = input.nextInt();

            switch (opcion) {
                case 1:
                    crearPedido();
                    break;
                case 2:
                    marcarPedidoComoEntregado();
                    break;
                case 3:
                    listarPedidosPendientes();
                    break;
                case 4:
                    listarPedidosEntregados();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void crearPedido() {
        try {
            System.out.print("Nombre del cliente: ");
            String nombreCliente = input.nextLine();
            input.next();
            System.out.print("Dirección del cliente: ");
            String direccionCliente = input.nextLine();
            Cliente cliente = new Cliente(nombreCliente, direccionCliente);

            List<Producto> productos = new ArrayList<>();
            boolean agregarMas = true;
            boolean tieneBurrito = false;
            boolean tieneHamburgesa = false;

            while (agregarMas) {
                System.out.print("Tipo de producto (1-Burrito, 2-Hamburguesa, 3-Kebab, 4-Pizza): ");
                int tipoProducto = Integer.parseInt(input.nextLine());
                TipoProducto tipo = TipoProducto.values()[tipoProducto - 1];
                double precio = 0;
                switch (tipo) {
                    case BURRITO:
                        precio = 6.5;
                        tieneBurrito = true;
                        break;
                    case HAMBURGUESA:
                        precio = 8.9;
                        tieneHamburgesa = true;
                        break;
                    case KEBAB:
                        precio = 4.5;
                        break;
                    case PIZZA:
                        precio = 7.9;
                        break;
                }
                productos.add(new Producto(tipo, precio));

                System.out.print("¿Desea agregar otro producto? (1-Sí, 2-No): ");
                agregarMas = input.nextInt() == 1;
            }
            if (tieneBurrito) {
                System.out.println("¡Has comprado un burrito! Aquí tienes un pin!.");
            } else if (tieneHamburgesa) {
                System.out.println("¡Has comprado una hamburgesa! Aquí tienes una gorra!.");
            }
            empresa.crearPedido(cliente, productos);
        } catch (Exception e) {
            System.out.println("Error al crear el pedido: " + e.getMessage());
        }
    }

    private void marcarPedidoComoEntregado() {
        System.out.print("ID del pedido a marcar como entregado: ");
        int idPedido = input.nextInt();
        empresa.marcarPedidoComoEntregado(idPedido);
    }

    private void listarPedidosPendientes() {
        List<Pedido> pedidosPendientes = empresa.listarPedidosPendientes();
        if (pedidosPendientes.isEmpty()) {
            System.out.println("No hay pedidos pendientes.");
        } else {
            for (Pedido pedido : pedidosPendientes) {
                System.out.println(pedido);
            }
        }
    }

    private void listarPedidosEntregados() {
        List<Pedido> pedidosEntregados = empresa.listarPedidosEntregados();
        if (pedidosEntregados.isEmpty()) {
            System.out.println("No hay pedidos entregados.");
        } else {
            for (Pedido pedido : pedidosEntregados) {
                System.out.println(pedido);
            }
        }
    }
}
