package com.app.TrainTicketReservation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.TrainTicketReservation.Repository.TicketRepository;
import com.app.TrainTicketReservation.Service.BookingService;
import com.app.TrainTicketReservation.Service.LoginManagementService;
import com.app.TrainTicketReservation.Service.TicketService;
import com.app.TrainTicketReservation.Service.UserService;
import com.app.TrainTicketReservation.model.Booking;
import com.app.TrainTicketReservation.model.Ticket;
import com.app.TrainTicketReservation.model.User;

@Controller
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private UserService userService;

	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@PostMapping("/purchaseConfirm")
	public String purchase(Model model, @ModelAttribute Booking booking) {
		User user = userService.findUser();
		model.addAttribute("email", user.getEmail());
		boolean purchaseRes = ticketService.purchase(user, booking);
	
		if (purchaseRes) {
			model.addAttribute("numOfSeats", booking.getNumOfSeats());
			model.addAttribute("user", booking.getUser());
			model.addAttribute("totalPrice", booking.getPrice());
			model.addAttribute("fromDestination", booking.getFromDestination());
			model.addAttribute("ToDestination", booking.getToDestination());
			return "purchaseConfirm";
		} else {
			return "puchaseFail";
		}
	}

	@GetMapping("/ticketCancel")
	public String cancel(@RequestParam("id") long ticketId, Model model) {
		Ticket ticket = ticketRepository.findOne(ticketId);
		model.addAttribute("numOfSeats", ticket.getNumOfSeats());
		model.addAttribute("user", ticket.getUser());
		model.addAttribute("totalPrice", ticket.getPrice());
		
		User user = userService.findUser();
		if (ticketService.cancel(ticketId)) {
			String msg = "The following booking has been successfully cancelled!";
		} else {
			String msg = "The following booking cannot be cancelled. Please cancel your ticket(s) earlier.";		
		}
		return "ticketCancel";
	}
	

	
}
