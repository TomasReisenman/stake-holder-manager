package coop.tecso.examen.model;

import javax.persistence.Entity;

@Entity
public class TitularFisico extends Titular {

    private String nombre;
    private String apellido;
    private String dni;

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
}