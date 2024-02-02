package com.app.TrainTicketReservation.Service;

import com.app.TrainTicketReservation.model.Ticket;

public interface BookingService {
	
	public Ticket bookTicket(Ticket ticket) throws Exception;

}
