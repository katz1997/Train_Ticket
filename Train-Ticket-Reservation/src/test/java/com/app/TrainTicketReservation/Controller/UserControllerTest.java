package com.app.TrainTicketReservation.Controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.app.TrainTicketReservation.Repository.UserRepository;
import com.app.TrainTicketReservation.model.User;

@ExtendWith(MockitoExtension.class)

public class UserControllerTest {

	    @Mock
	    private UserRepository userRepository;

	    @InjectMocks
	    private UserController userController;

	    // Write test cases 
	    @Test
	    void testDeleteUserSuccess() {
	        long userId = 1L;
	        User existingUser = new User();
	        existingUser.setId(userId);

	        when(userRepository.findById(userId)).thenReturn(java.util.Optional.of(existingUser));

	        ResponseEntity<String> response = userController.deleteUser(userId);

	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals("User deleted successfully", response.getBody());
	        verify(userRepository, times(1)).delete(existingUser);
	    }

	    @Test
	    void testDeleteUserNotFound() {
	        long userId = 1L;

	        when(userRepository.findById(userId)).thenReturn(java.util.Optional.empty());

	        ResponseEntity<String> response = userController.deleteUser(userId);

	        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	        assertEquals("User not found", response.getBody());
	        verify(userRepository, never()).delete(any());
	    }

	    @Test
	    void testModifyUserSeatSuccess() {
	        long userId = 1L;
	        String newSeatSection = "B";
	        User existingUser = new User();
	        existingUser.setId(userId);

	        when(userRepository.findById(userId)).thenReturn(java.util.Optional.of(existingUser));
	        when(userRepository.save(any())).thenReturn(existingUser);

	        ResponseEntity<String> response = userController.modifyUserSeat(userId, newSeatSection);

	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals("User seat modified successfully", response.getBody());
	        assertEquals(newSeatSection, existingUser.getAllocatedSeatSection());
	        verify(userRepository, times(1)).save(existingUser);
	    }

	    @Test
	    void testModifyUserSeatNotFound() {
	        long userId = 1L;
	        String newSeatSection = "B";

	        when(userRepository.findById(userId)).thenReturn(java.util.Optional.empty());

	        ResponseEntity<String> response = userController.modifyUserSeat(userId, newSeatSection);

	        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	        assertEquals("User not found", response.getBody());
	        verify(userRepository, never()).save(any());
	    }

	}
