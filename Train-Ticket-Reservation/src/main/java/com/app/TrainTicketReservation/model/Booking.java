package com.app.TrainTicketReservation.model;

import java.util.List;

import javax.swing.text.Segment;

import jakarta.persistence.Column;

public class Booking {

	private String departureDate;
	private int numOfSeats;
	private List<String> User;
	private double price;
    private Long trainNo;
	private String trainName;
	private String fromDestination;
	private String toDestination;

	
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
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
	
	public List<String> getUser() {
		return User;
	}
	public void setUser(List<String> user) {
		User = user;
	}
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
	
}
