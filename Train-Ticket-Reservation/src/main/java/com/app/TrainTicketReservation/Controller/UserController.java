package com.app.TrainTicketReservation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.TrainTicketReservation.Repository.UserRepository;
import com.app.TrainTicketReservation.Service.ReceiptService;
import com.app.TrainTicketReservation.Service.UserService;
import com.app.TrainTicketReservation.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	

	    @Autowired
	    private UserService userService;

	    @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private ReceiptService receiptService;
	    @PostMapping
	    public User createUser(@RequestBody User user) {
	        // Create a new user and save to the database
	    String	allocatedSeatSection =	userRepository.findByAllocatedSeatSection(section);
	        return userService.createUser(user, allocatedSeatSection);
	    }

	  
	    @GetMapping("/receipt/{userId}")
	    public String getReceiptDetails(@PathVariable Long userId) {
	        return receiptService.generateReceipt(userId);
	    }
	    
	    @GetMapping("/bySection/{section}")
	    public List<User> getUsersBySection(@PathVariable String section) {
	        return userRepository.findByAllocatedSeatSection(section);
	    }
	    
	    //remove a user from the train
	    @DeleteMapping("/{userId}")
	    public String deleteUser(@PathVariable Long userId) {
	        User userToDelete = userRepository.findById(userId).orElse(null);

	        if (userToDelete == null) {
	            return "User not found";
	        }

	        userRepository.delete(userToDelete);
	        return "User deleted successfully";
	    }
	    
	    //modify a users seat
	    @PutMapping("/{userId}/modifySeat")
	    public String modifyUserSeat(@PathVariable Long userId, @RequestParam String newSeatSection) {
	        User userToModify = userRepository.findById(userId).orElse(null);

	        if (userToModify == null) {
	            return "User not found";
	        }

	        // Update the seat section
	        userToModify.setAllocatedSeatSection(newSeatSection);
	        userRepository.save(userToModify);

	        return "User seat modified successfully";
	    }
}
