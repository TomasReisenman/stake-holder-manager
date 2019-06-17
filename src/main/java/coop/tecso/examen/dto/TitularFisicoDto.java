package coop.tecso.examen.dto;

import coop.tecso.examen.model.TitularFisico;

public class TitularFisicoDto {

    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String cuit;

    public TitularFisicoDto(TitularFisico titularFisico) {
        this.id = titularFisico.getId();
        this.nombre = titularFisico.getNombre();
        this.apellido = titularFisico.getApellido();
        this.dni = titularFisico.getDni();
        this.cuit = titularFisico.getCuit();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }
}
