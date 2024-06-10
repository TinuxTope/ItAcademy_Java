package Delivery_Bruumm.empresa;

import Delivery_Bruumm.acciones.Pedido;
import Delivery_Bruumm.acciones.Producto;
import Delivery_Bruumm.enums.EstadoPedido;
import Delivery_Bruumm.enums.ModoRepartir;
import Delivery_Bruumm.personas.Cliente;
import Delivery_Bruumm.personas.Repartidor;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Repartidor> repartidores;
    private List<Pedido> pedidos;

    public Empresa(){
        this.repartidores = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        inicializarRepartidores();
    }

    private void inicializarRepartidores() {
        repartidores.add(new Repartidor("Sheldon", ModoRepartir.BICICLETA));
        repartidores.add(new Repartidor("Koothrappali", ModoRepartir.MOTO));
        repartidores.add(new Repartidor("Leonard", ModoRepartir.PIE));
    }

    public void crearPedido(Cliente cliente, List<Producto> productos) throws Exception {
        if (cliente == null || productos == null || productos.isEmpty()) {
            throw new Exception("Para crear pedidos es necesario el cliente y los productos.");
        }

        Repartidor repartidorDisponible = repartidores.stream()
                .filter(Repartidor::isDisponible)
                .findAny()
                .orElseThrow(() -> new Exception("No hay repartidores disponibles."));

        Pedido pedido = new Pedido(cliente, productos, repartidorDisponible);
        repartidorDisponible.setDisponible(false);
        pedidos.add(pedido);

        System.out.println("Pedido en marcha: " + pedido);

    }

    public void marcarPedidoComoEntregado(int idPedido) {
        Pedido pedido = pedidos.stream()
                .filter(p -> p.getPedidoId() == idPedido)
                .findFirst()
                .orElse(null);

        if (pedido != null && pedido.getEstado() == EstadoPedido.PENDIENTE) {
            pedido.entregado();
            System.out.println("Pedido entregado: " + pedido);
        } else {
            System.out.println("Pedido no encontrado o ya entregado.");
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

    public List<Repartidor> getRepartidores() {
        return repartidores;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}
