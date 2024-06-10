package Delivery_Bruumm.acciones;

import Delivery_Bruumm.enums.TipoProducto;

public class Producto {
    private TipoProducto tipo;
    private double precio;

    public Producto(TipoProducto tipo, double precio){
        this.tipo = tipo;
        this.precio = precio;
    }

    public TipoProducto getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto: " + this.tipo + " --> Precio: " + this.precio + "€.";
    }
}
