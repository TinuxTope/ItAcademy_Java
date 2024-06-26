package Delivery_Bruumm.logica;

import Delivery_Bruumm.acciones.Pedido;
import Delivery_Bruumm.acciones.Producto;
import Delivery_Bruumm.enums.EstadoPedido;
import Delivery_Bruumm.enums.ModoRepartir;
import Delivery_Bruumm.personas.Cliente;
import Delivery_Bruumm.personas.Repartidor;
import Delivery_Bruumm.util.CustomException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestorPedidos {
    private List<Repartidor> repartidores;
    private List<Pedido> pedidos;

    public GestorPedidos() {
        this.repartidores = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        inicializarRepartidores();
    }

    private void inicializarRepartidores() {
        repartidores.add(new Repartidor("Sheldon", ModoRepartir.BICICLETA));
        repartidores.add(new Repartidor("Koothrappali", ModoRepartir.MOTO));
        repartidores.add(new Repartidor("Leonard", ModoRepartir.PIE));
        repartidores.add(new Repartidor("Thor", ModoRepartir.BICICLETA));
        repartidores.add(new Repartidor("Stark", ModoRepartir.MOTO));
        repartidores.add(new Repartidor("Natasha", ModoRepartir.PIE));
    }

    public List<Repartidor> getRepartidoresDisponibles() {
        return repartidores.stream()
                .filter(Repartidor::isDisponible)
                .collect(Collectors.toList());
    }

    public void crearPedido(Cliente cliente, List<Producto> productos, Repartidor repartidorSeleccionado) throws CustomException {
        if (cliente == null || productos == null || productos.isEmpty()) {
            throw new CustomException("Para crear pedidos es necesario el cliente y los productos.");
        }

        if (!repartidorSeleccionado.isDisponible()) {
            throw new CustomException("El repartidor seleccionado no está disponible.");
        }

        Pedido pedido = new Pedido(cliente, productos, repartidorSeleccionado);
        repartidorSeleccionado.setDisponible(false);
        pedidos.add(pedido);

        System.out.println("Pedido en marcha: " + pedido);
    }

    public void marcarPedidoComoEntregado(int idPedido) throws CustomException {
        Pedido pedido = pedidos.stream()
                .filter(p -> p.getPedidoId() == idPedido)
                .findFirst()
                .orElseThrow(() -> new CustomException("Pedido no encontrado."));

        if (pedido.getEstado() == EstadoPedido.PENDIENTE) {
            pedido.entregado();
            System.out.println("Pedido entregado: " + pedido);
        } else {
            throw new CustomException("El pedido ya fue entregado.");
        }
    }

    public List<Pedido> listarPedidosPendientes() {
        return pedidos.stream()
                .filter(p -> p.getEstado() == EstadoPedido.PENDIENTE)
                .collect(Collectors.toList());
    }

    public List<Pedido> listarPedidosEntregados() {
        return pedidos.stream()
                .filter(p -> p.getEstado() == EstadoPedido.ENTREGADO)
                .collect(Collectors.toList());
    }
}
