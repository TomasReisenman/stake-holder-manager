package coop.tecso.examen.dto;

import coop.tecso.examen.model.TitularJuridico;

public class TitularJuridicoDto {

    private Long id;
    private String razonSocial;
    private String foundationYear;
    private String cuti;

    public TitularJuridicoDto(TitularJuridico titularJuridico) {
        this.id = titularJuridico.getId();
        this.razonSocial = titularJuridico.getRazonSocial();
        this.foundationYear = titularJuridico.getFoundationYear();
        this.cuti = titularJuridico.getCuit();
    }

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

    public String getCuti() {
        return cuti;
    }

    public void setCuti(String cuti) {
        this.cuti = cuti;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
