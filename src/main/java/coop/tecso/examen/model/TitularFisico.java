package coop.tecso.examen.model;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
public class TitularFisico extends Titular {

    @Size(max = 80, message = "Nombre no puede tener mas de 80 caracteres")
    private String nombre;

    @Size(max = 250, message = "Apellido no puede tener mas de 250 caracteres")
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
