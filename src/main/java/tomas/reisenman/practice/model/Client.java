package tomas.reisenman.practice.model;


import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
public class Client extends StakeHolder {

    @Size(max = 100, message = "Address can't have more than 100 characters")
    private String address;

    private String industry;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }
}
