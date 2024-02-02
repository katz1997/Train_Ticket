package com.app.TrainTicketReservation.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.TrainTicketReservation.Repository.UserRepository;
import com.app.TrainTicketReservation.model.Ticket;
import com.app.TrainTicketReservation.model.User;

@Service
public class ReceiptService {

	 @Autowired
	    private UserRepository userRepository;

	 @Autowired
	 private Ticket ticket;
	 
	    public String generateReceipt(Long userId) {
	        User user = userRepository.findUser(userId).orElse(null);

	        if (user == null) {
	            return "User not found";
	        }

	        StringBuilder receipt = new StringBuilder();
	        receipt.append("Receipt Details:\n");
	        receipt.append("Name: ").append(user.getFirstName()).append(" ").append(user.getLastName()).append("\n");
	        receipt.append("Email: ").append(user.getEmail()).append("\n");
	        receipt.append("Seat Section: ").append(user.getAllocatedSeatSection()).append("\n");
	        receipt.append("Ticket Price: $").append(ticket.getPrice()).append("\n");


	        return receipt.toString();
	    }
	}