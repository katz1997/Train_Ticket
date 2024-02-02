package com.app.TrainTicketReservation.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.TrainTicketReservation.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	
    @Query("SELECT u.firstName AS firstName, u.lastName AS lastName, u.emailAddress AS emailAddress FROM User u")
    List<User> findUser(User user);
   
    List<User> findByAllocatedSeatSection(String allocatedSeatSection);
}
