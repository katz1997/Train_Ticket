package com.app.TrainTicketReservation.Service;

import com.app.TrainTicketReservation.Repository.UserRepository;
import com.app.TrainTicketReservation.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	 @Autowired
	    private UserRepository userRepository;

	    public User createUser(User user, String allocatedSeatSection) {
	    	user.setAllocatedSeatSection(allocatedSeatSection);
	        return userRepository.save(user);
	    }
}