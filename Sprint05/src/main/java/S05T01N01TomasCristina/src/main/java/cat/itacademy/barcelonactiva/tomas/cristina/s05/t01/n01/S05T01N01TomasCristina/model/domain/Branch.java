package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n01.S05T01N01TomasCristina.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String branchName;
    private String branchCountry;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchCountry() {
        return branchCountry;
    }

    public void setBranchCountry(String branchCountry) {
        this.branchCountry = branchCountry;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", branchName='" + branchName + '\'' +
                ", branchCountry='" + branchCountry + '\'' +
                '}';
    }
}
