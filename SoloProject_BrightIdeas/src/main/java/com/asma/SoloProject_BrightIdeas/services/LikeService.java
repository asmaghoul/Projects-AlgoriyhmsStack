package com.asma.SoloProject_BrightIdeas.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asma.SoloProject_BrightIdeas.models.Like;
import com.asma.SoloProject_BrightIdeas.repositories.LikeRepository;

@Service
public class LikeService {
	
	@Autowired
	private LikeRepository likeRepo;
	
	public Like createLike(Like like) {
		return likeRepo.save(like);
	}
	
	public List<Like> allLikes(){
		return likeRepo.findAll();
	}
	
	public Like findLike(Long id) {
		Optional<Like> optionalLike = likeRepo.findById(id);
		if(optionalLike.isPresent()) {
			return optionalLike.get();
		}
		else {
			return null;
		}
	}
	
	public Like updateLike(Like like) {
		return likeRepo.save(like);
	}
	
	public void deleteLike(Long id) {
		Optional<Like> optionalLike=likeRepo.findById(id);
		if(optionalLike.isPresent()) {
			likeRepo.deleteById(id);
		}
	}
	public void deleteLikeFromIdea(Long likeId, Long ideaId) {
        // Retrieve the like from the database
        Like like = likeRepo.findById(likeId).orElse(null);
        if (like == null) {
            // Handle the case where the like does not exist
            throw new IllegalArgumentException("Like not found with ID: " + likeId);
        }

        // Ensure that the like belongs to the specified idea
        if (!like.getIdea().getId().equals(ideaId)) {
            throw new IllegalArgumentException("Like with ID: " + likeId + " does not belong to idea with ID: " + ideaId);
        }

        // Remove the like from the idea
        like.getIdea().getLikes().remove(like);

        // Set the like's idea to null
        like.setIdea(null);

        // Save the changes to update the database
        likeRepo.save(like);
    }
	public boolean hasUserLikedIdea(Long userId, Long ideaId) {
        return likeRepo.existsByUserIdAndIdeaId(userId, ideaId);
    }
	
}