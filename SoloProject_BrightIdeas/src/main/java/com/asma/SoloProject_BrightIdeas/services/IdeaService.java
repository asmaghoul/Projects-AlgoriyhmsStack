package com.asma.SoloProject_BrightIdeas.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asma.SoloProject_BrightIdeas.models.Idea;
import com.asma.SoloProject_BrightIdeas.models.Like;
import com.asma.SoloProject_BrightIdeas.models.User;
import com.asma.SoloProject_BrightIdeas.repositories.IdeaRepository;


@Service
public class IdeaService {
	
	@Autowired
	private IdeaRepository iRepo;
	
	public Idea findById(Long id) {
		Optional<Idea> result = iRepo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}
	public List<Idea> allIdeas(){
		return iRepo.findAll();
	}
	public Idea create(Idea idea, User user) {
		idea.setUser(user);
		return iRepo.save(idea);
	}
	public Idea update(Idea idea) {
		return iRepo.save(idea);
	}
	
	public void delete(Long id) {
		iRepo.deleteById(id);
	}
	 public List<Like> getAllLikes() {
	        List<Like> allLikes = new ArrayList<>();
	        List<Idea> allIdeas = iRepo.findAll();

	        // Iterate through all ideas and collect their likes
	        for (Idea idea : allIdeas) {
	            if (idea.getLikes() != null) {
	                allLikes.addAll(idea.getLikes());
	            }
	        }

	        return allLikes;
	    }
	// Method to fetch ideas ordered by likes
	    public List<Idea> findAllOrderedByLikes() {
	        return iRepo.findAllOrderedByLikesSize();
	    }
}
	
