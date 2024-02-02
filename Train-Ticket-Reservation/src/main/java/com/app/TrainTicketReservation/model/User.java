package com.app.TrainTicketReservation.model;


import java.util.ArrayList;
import java.util.Collection;



import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="USER")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private long userId;

	@Column(name="EMAIL", nullable = false, unique = true)
	private String email;
    private String firstName;
    private String lastName;
    
    // allocated seat section
    private String allocatedSeatSection;
    
  
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
    
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	 public String getAllocatedSeatSection() {
			return allocatedSeatSection;
		}

		public void setAllocatedSeatSection(String allocatedSeatSection) {
			this.allocatedSeatSection = allocatedSeatSection;
		}


   

}

