package com.app.TrainTicketReservation.model;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name="TICKET")
public class Ticket {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TICKET_ID")
	private long ticketId;
	
	@Column(name="IS_CANCELLED", nullable=false)
	private boolean isCancelled;
	
	@Column(name="NUM_OF_SEATS", nullable=false)
	private int numOfSeats;
	
	@Column (name="PRICE", nullable=false)
	private double price;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID", nullable=false)
	private User user;
	
	
	
	
	@ManyToMany(cascade= CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="DEPART_TRAINS", 
				joinColumns= {@JoinColumn(name="TICKET_ID", referencedColumnName="TICKET_ID")}, 
				inverseJoinColumns= {@JoinColumn(name="DEPART_TRAIN_ID",referencedColumnName="TRAIN_ID")}) 
	private List<Train> departTrains;
	
	@ManyToMany(cascade= CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="RETURN_TRAINS", 
				joinColumns= {@JoinColumn(name="TICKET_ID", referencedColumnName="TICKET_ID")}, 
				inverseJoinColumns= {@JoinColumn(name="RETURN_TRAIN_ID",referencedColumnName="TRAIN_ID")}) 
	private List<Train> returnTrains;
	
	public Ticket() {
		super();
	}
	
	public long getTicketId() {
		return ticketId;
	}

	public boolean isCancelled() {
		return isCancelled;
	}

	public void setCancelled(boolean isCancelled) {
		this.isCancelled = isCancelled;
	}

	public int getNumOfSeats() {
		return numOfSeats;
	}

	public void setNumOfSeats(int numOfSeats) {
		this.numOfSeats = numOfSeats;
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Train> getDepartTrains() {
		return departTrains;
	}

	public void setDepartTrains(List<Train> departTrains) {
		this.departTrains = departTrains;
	}

	public List<Train> getReturnTrains() {
		return returnTrains;
	}

	public void setReturnTrains(List<Train> returnTrains) {
		this.returnTrains = returnTrains;
	}
}