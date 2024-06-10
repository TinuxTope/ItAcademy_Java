package Delivery_Bruumm.acciones;

import Delivery_Bruumm.enums.EstadoPedido;
import Delivery_Bruumm.personas.Cliente;
import Delivery_Bruumm.personas.Repartidor;

import java.util.List;

public class Pedido {
    private int pedidoId;
    private static int nextPedidoId = 1;
    private Cliente cliente;
    private List<Producto> productos;
    private Repartidor repartidor;
    private EstadoPedido estado;
    private String regalo;

    public Pedido (Cliente cliente, List<Producto> productos, Repartidor repartidor){
        this.pedidoId = nextPedidoId++;
        this.cliente = cliente;
        this.productos = productos;
        this.repartidor = repartidor;
        this.estado = EstadoPedido.PENDIENTE;
        this.regalo = regalo;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public String getRegalo() {
        return regalo;
    }

    public void entregado() {
        this.estado = EstadoPedido.ENTREGADO;
        repartidor.setDisponible(true);
    }

    public double calcularTotalPrecio() {
        double total = productos.stream().mapToDouble(Producto::getPrecio).sum();
        switch (repartidor.getModo()) {
            case BICICLETA:
                total *= 1.01;
                break;
            case MOTO:
                total *= 1.02;
                break;
            default:
                break;
        }
        return total;
    }
    //public String entregaRegalo(){}

    @Override
    public String toString() {
        return "Pedido --> " + this.pedidoId + " / Cliente --> " + this.cliente +
                " productos: " + this.productos + " -- repartidor -- " + this.repartidor
                + " ESTADO: " + this.estado + ".";
    }
}
