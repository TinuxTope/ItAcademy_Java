package Delivery_Bruumm.enums;

public enum TipoProducto {
    BURRITO(6.5, "pin"),
    HAMBURGUESA(8.9, "gorra"),
    KEBAB(4.5, "Sin regalo"),
    PIZZA(7.9, "Sin regalo");

    private final double precio;
    private final String regalo;

    TipoProducto(double precio, String regalo) {
        this.precio = precio;
        this.regalo = regalo;
    }

    public double getPrecio() {
        return precio;
    }

    public String getRegalo() {
        return regalo;
    }
}
