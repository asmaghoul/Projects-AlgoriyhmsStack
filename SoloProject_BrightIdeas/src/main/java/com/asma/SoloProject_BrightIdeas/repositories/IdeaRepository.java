package com.asma.SoloProject_BrightIdeas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asma.SoloProject_BrightIdeas.models.Idea;

@Repository
public interface IdeaRepository extends CrudRepository<Idea, Long> {

	List<Idea> findAll();


	 @Query("SELECT i FROM Idea i ORDER BY SIZE(i.likes) DESC")
	    List<Idea> findAllOrderedByLikesSize();
	 
	 
}