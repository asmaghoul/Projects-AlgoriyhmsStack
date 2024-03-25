package com.AsmaSouad.choreTracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AsmaSouad.choreTracker.models.Job;

@Repository
public interface JobRepository extends CrudRepository<Job, Long> {
	List<Job> findAll();
	//Optional<Job> findById(Long id);
	  List<Job> findByPickedBy(com.AsmaSouad.choreTracker.models.User pickedBy);

}
