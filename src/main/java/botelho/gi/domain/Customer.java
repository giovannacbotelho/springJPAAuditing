package botelho.gi.domain;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners({AuditingEntityListener.class})
public class Customer extends AbstractAuditable<User, Long>{

    private String firstName;
    private String lastName;

    protected Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer {" +
				"id='" + getId() + "', " +
				"data='" + getFirstName() + "', " +
				"version='" + getLastName() + "', " +
				"createdDate='" + getCreatedDate() + "', " +
				"createdBy='" + getCreatedBy() + "', " +
				"lastModifiedDate='" + getLastModifiedDate() + "', " +
				"lastModifiedBy='" + getLastModifiedBy() + "'} ";
    }

	private String getLastName() {
		return this.lastName;
	}

	private String getFirstName() {
		return this.firstName;
	}

}