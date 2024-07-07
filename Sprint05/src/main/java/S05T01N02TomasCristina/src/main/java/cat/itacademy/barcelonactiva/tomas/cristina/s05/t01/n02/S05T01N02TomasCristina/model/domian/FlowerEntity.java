package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n02.S05T01N02TomasCristina.model.domian;

import jakarta.persistence.*;

@Entity
@Table(name = "flores")
public class FlowerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pk_FlowerID;
    @Column(name = "name", nullable = false, unique = true, length = 50)
    private String name;

    @Column(name = "country", nullable = false, length = 50)
    private String country;

    public FlowerEntity() {
    }

    public FlowerEntity(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Integer getPk_FlowerID() {
        return pk_FlowerID;
    }

    public void setPk_FlowerID(Integer pk_FlowerID) {
        this.pk_FlowerID = pk_FlowerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "FlowerEntity{" +
                "id=" + pk_FlowerID +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

}
