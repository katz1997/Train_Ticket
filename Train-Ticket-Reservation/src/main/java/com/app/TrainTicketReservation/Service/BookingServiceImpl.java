package com.app.TrainTicketReservation.Service;

import org.springframework.transaction.annotation.Transactional;

import com.app.TrainTicketReservation.Repository.TicketRepository;
import com.app.TrainTicketReservation.model.Ticket;
import com.app.TrainTicketReservation.model.Train;

import java.util.function.Predicate;

public class BookingServiceImpl implements BookingService {
	
	
	@Autowired
	private TrainService trainService;
	
	@Autowired
	private TicketRepository ticketRepository;

	
	@Override
	@Transactional
	public Ticket bookTicket(Ticket ticket) {

		// fetching complete train details and saving to ticket before booking
		Train train = trainService.getTrainByNumber(ticket.getTrain().getTrainNo());

		train.setFromDestination(ticket.getTrain().getFromDestination());
		train.setToDestination(ticket.getTrain().getToDestination());

		Integer seatsAvailable = train.getSeats();

		Ticket ticketBookingResult = null;

		// predicate checks if the required seats are not available.
		Predicate<Ticket> areSeatsUnavailable =  
				requestedTicket  -> requestedTicket.getSeatsRequired() > train.getSeats();
		
				
		if (areSeatsUnavailable.test(ticket)) {
			String userFriendlyMessage = "Only " + seatsAvailable + " seats are available on this train!";
			
		} else {
			seatsAvailable = seatsAvailable - ticket.getSeatsRequired();

			// updating available seats with the new number
			train.setSeats(seatsAvailable);

			try {
				String transactionId = ticket.getTransactionId();
				Double fare = train.getPrice();
				Integer seatsRequired = ticket.getSeatsRequired();
				Double totalAmount = fare * seatsRequired;

				// ticket details updating
				ticket.setTransactionId(transactionId);
				ticket.setTicketAmount(totalAmount);

				// creating ticket and confirmation
				ticketBookingResult = ticketRepository.save(ticket);
				// setting complete train detailas to display after booking ticket
				trainService.saveOrUpdateTrain(train);

				// adding train's complete information to ticketBookingResult object for
				// displaying
				ticketBookingResult.setTrain(train);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return ticketBookingResult;
	}

}
