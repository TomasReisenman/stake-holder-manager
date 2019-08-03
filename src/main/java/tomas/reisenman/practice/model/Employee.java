package tomas.reisenman.practice.model;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
public class Employee extends StakeHolder {

    @Size(max = 80, message = "Name can't have more than 80 characters")
    private String name;

    @Size(max = 250, message = "Surname can't have more than 250 characters")
    private String surname;
    private String position;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
