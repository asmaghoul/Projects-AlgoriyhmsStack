package com.asma.SoloProject_BrightIdeas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asma.SoloProject_BrightIdeas.models.Idea;
import com.asma.SoloProject_BrightIdeas.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	Optional<User> findByEmail(String email);
	List<User> findAll();
	
	 
	   @Query("SELECT i FROM Idea i WHERE i.user.id = :userId")
	    List<Idea> findIdeasCreatedByUser(@Param("userId") Long userId);
	    
	    @Query("SELECT l.idea FROM Like l WHERE l.user.id = :userId")
	    List<Idea> findLikedIdeasByUserId(@Param("userId") Long userId);
}
