package tomas.reisenman.practice.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class StakeHolder extends AbstractPersistentObject {

	@Column(unique = true)
	private String contactEmail;

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
}
