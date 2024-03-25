package com.AsmaSouad.choreTracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AsmaSouad.choreTracker.models.Job;
import com.AsmaSouad.choreTracker.models.User;
import com.AsmaSouad.choreTracker.repositories.JobRepository;


@Service
public class JobService {
	@Autowired
	private JobRepository jobRepo;
	
	
	public List<Job> allJobs(){
		return jobRepo.findAll();
	}
	//findByPickedBy method 
	public List<Job> pickedJobs(User pickedBy){
		return jobRepo.findByPickedBy(pickedBy);
	}

	// creates a job
    public Job createJob(Job j) {
        return jobRepo.save(j);
    }
    // retrieves a job
    public Job findJob(Long id) {
        Optional<Job> optionalJob = jobRepo.findById(id);
    	
        if(optionalJob.isPresent()) {
            return optionalJob.get();
        } else {
            return null;
        }
    }
    
    public void deleteJob(Long id) {
    	jobRepo.deleteById(id);
    }
//update
    public Job updateJob(Job j){

    		return jobRepo.save(j);
    	
        
    }
	
}
