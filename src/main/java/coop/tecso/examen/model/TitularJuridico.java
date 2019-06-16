package coop.tecso.examen.model;


import javax.persistence.Entity;

@Entity
public class TitularJuridico extends Titular {

    private String razonSocial;
    //(maximo 100 caracteres)
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
