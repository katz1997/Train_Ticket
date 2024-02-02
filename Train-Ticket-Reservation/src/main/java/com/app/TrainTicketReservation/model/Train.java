package com.app.TrainTicketReservation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "train")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Train {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "train_no")
	
	private Long trainNo;

	
	@Column(name = "train_name")
	private String trainName;

	
	@Column(name = "from_destination")
	private String fromDestination;

	/**
	 * The destination station of the train.
	 */
	@Column(name = "to_destination")
	private String toDestination;

	/**
	 * The number of available seats on the train.
	 */
	@Column(name = "seats_available")
	private Integer seats;

	
	private Double Price;


	public Long getTrainNo() {
		return trainNo;
	}


	public void setTrainNo(Long trainNo) {
		this.trainNo = trainNo;
	}


	public String getTrainName() {
		return trainName;
	}


	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}


	public String getFromDestination() {
		return fromDestination;
	}


	public void setFromDestination(String fromDestination) {
		this.fromDestination = fromDestination;
	}


	public String getToDestination() {
		return toDestination;
	}


	public void setToDestination(String toDestination) {
		this.toDestination = toDestination;
	}


	public Integer getSeats() {
		return seats;
	}


	public void setSeats(Integer seats) {
		this.seats = seats;
	}


	public Double getPrice() {
		return Price;
	}


	public void setPrice(Double price) {
		Price = price;
	}
}
