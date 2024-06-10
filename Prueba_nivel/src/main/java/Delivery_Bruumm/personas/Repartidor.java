package Delivery_Bruumm.personas;

import Delivery_Bruumm.enums.ModoRepartir;

public class Repartidor {
    private String nombre;
    private boolean disponible;
    private ModoRepartir modo;

    public Repartidor(String nombre, ModoRepartir modo){
        this.nombre = nombre;
        this.modo = modo;
        this.disponible = true;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public ModoRepartir getModo() {
        return modo;
    }

    @Override
    public String toString() {
        return "El repartidor " + this.nombre + " -- disponoble -- " + this.disponible +
                " reparte a/en " + this.modo + ".";
    }
}
