package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n02.S05T01N02TomasCristina.model.dto;

public class FlowerDTO {
    private int id;
    private String name;
    private String country;
    private String continent;

    public FlowerDTO() {}

    public FlowerDTO(int id, String name, String country, String continent) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.continent = continent;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
}
