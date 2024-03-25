package com.asma.SoloProject_BrightIdeas.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asma.SoloProject_BrightIdeas.models.Like;

@Repository
public interface LikeRepository extends CrudRepository<Like, Long> {
	List<Like> findAll();
	
	@Query("SELECT COUNT(l) > 0 FROM Like l WHERE l.user.id = :userId AND l.idea.id = :ideaId")
    boolean existsByUserIdAndIdeaId(@Param("userId") Long userId, @Param("ideaId") Long ideaId);
	
}