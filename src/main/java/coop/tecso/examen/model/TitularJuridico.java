package coop.tecso.examen.model;


import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
public class TitularJuridico extends Titular {

    @Size(max = 100, message = "Razon social no puede tener mas de 100 caracteres")
    private String razonSocial;

    private String foundationYear;

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(String foundationYear) {
        this.foundationYear = foundationYear;
    }
}
