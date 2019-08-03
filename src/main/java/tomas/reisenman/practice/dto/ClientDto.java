package tomas.reisenman.practice.dto;

import tomas.reisenman.practice.model.Client;

public class ClientDto {

    private Long id;
    private String address;
    private String industry;
    private String contactEmail;

    public ClientDto(Client client) {
        this.id = client.getId();
        this.address = client.getAddress();
        this.industry = client.getIndustry();
        this.contactEmail = client.getContactEmail();
    }

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

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
