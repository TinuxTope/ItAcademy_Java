package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n01.S05T01N01TomasCristina.model.dto;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n01.S05T01N01TomasCristina.exceptions.SucursalNotFoundException;

public class SucursalDTO {
    private Integer pk_SucursalID;
    private String nomSucursal;
    private String paisSucursal;
    private String tipusSucursal;
    public SucursalDTO() {}

    public SucursalDTO(Integer pk_SucursalID, String nomSucursal, String paisSucursal) {
        this.pk_SucursalID = pk_SucursalID;
        this.nomSucursal = nomSucursal;
        this.paisSucursal = paisSucursal;
        this.tipusSucursal = determineSucursalType(paisSucursal);
    }
    public Integer getPk_SucursalID() {
        return pk_SucursalID;
    }

    public void setPk_SucursalID(Integer pk_SucursalID) {
        this.pk_SucursalID = pk_SucursalID;
    }

    public String getNomSucursal() {
        return nomSucursal;
    }

    public void setNomSucursal(String nomSucursal) {
        this.nomSucursal = nomSucursal;
    }

    public String getPaisSucursal() {
        return paisSucursal;
    }

    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
    }

    public String getTipusSucursal() {
        return tipusSucursal;
    }

    public void setTipusSucursal(String tipusSucursal) {
        this.tipusSucursal = tipusSucursal;
    }

    private String determineSucursalType(String paisSucursal) {
        if (CountryEurope.isCountry(paisSucursal)) {
            return "Europe";
        } else if (CountryAsia.isCountry(paisSucursal)) {
            return "Asia";
        } else if (CountryAfrica.isCountry(paisSucursal)) {
            return "Africa";
        } else if (CountryAmerica.isCountry(paisSucursal)) {
            return "America";
        } else if (CountryOceania.isCountry(paisSucursal)) {
            return "Oceania";
        } else {
            throw new SucursalNotFoundException("País desconocido: " + paisSucursal);
        }
    }
}
