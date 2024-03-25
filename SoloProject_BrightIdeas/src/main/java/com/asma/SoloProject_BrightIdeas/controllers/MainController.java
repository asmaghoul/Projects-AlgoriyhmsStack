package com.asma.SoloProject_BrightIdeas.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asma.SoloProject_BrightIdeas.models.Like;
import com.asma.SoloProject_BrightIdeas.models.Idea;
import com.asma.SoloProject_BrightIdeas.models.User;
import com.asma.SoloProject_BrightIdeas.services.LikeService;
import com.asma.SoloProject_BrightIdeas.services.IdeaService;
import com.asma.SoloProject_BrightIdeas.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller

public class MainController {
	
	@Autowired
	private UserService userServ;
	@Autowired
	private IdeaService iServ;
	@Autowired
	private LikeService lServ;
	
	// Your Ideas section
	@GetMapping("/dashboard")
	public String dash(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		if(session.getAttribute("userId")==null)
    	{
    		return "redirect:/logout";
    		}
		 User loggedUser = userServ.findUser(userId);
		    model.addAttribute("loggedUser", loggedUser);
    	model.addAttribute("user", userServ.findUser(userId));
    	 // Add the newIdea attribute to the model
    	
    	// Fetch ideas ordered by the number of likes
        List<Idea> ideas = iServ.findAllOrderedByLikes();
    	
    	
        model.addAttribute("newIdea", new Idea());
        model.addAttribute("newLike", new Like());
    	model.addAttribute("ideas", ideas);
    	model.addAttribute("likes", iServ.getAllLikes());
    	User user = userServ.findUser((Long)session.getAttribute("userId"));
		model.addAttribute("user", user);
		
		return "/dashboard.jsp";
	}
	
	
	//User Ideas and Likes
	@GetMapping("/users/{id}")
	public String ideaslikes(@PathVariable("id")Long id, HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		if(session.getAttribute("userId")==null)
    	{
    		return "redirect:/logout";
    		}
		 User loggedUser = userServ.findUser(userId);
		    model.addAttribute("loggedUser", loggedUser);
 	model.addAttribute("user", userServ.findUser(userId));	
 	
	User user = userServ.findUser((Long)session.getAttribute("userId"));
	model.addAttribute("user", user);
	
	 // Fetch the user's liked ideas and add them to the model
    List<Idea> likedIdeas = userServ.likedIdeas(userId);
    model.addAttribute("likedideas", likedIdeas);

    // Fetch the user's created ideas and add them to the model
    List<Idea> userIdeas = userServ.findIdeasCreatedByUser(userId);
    model.addAttribute("ideas", userIdeas);

	
	return "/userdash.jsp";
	}
	/*// New Idea
	@GetMapping("/ideas/new")
	public String newIdea(@ModelAttribute("newIdea")Idea newIdea, Model model, HttpSession session) {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		User user = userServ.findUser((Long)session.getAttribute("userId"));
		model.addAttribute("user", user);
		return "/new.jsp";
	}*/
	
	// Create New Idea
	@PostMapping("/ideas/new/idea")
	public String postIdea(@Valid @ModelAttribute("newIdea")Idea newIdea, BindingResult result,Model model, HttpSession session) {
		 Long userId = (Long) session.getAttribute("userId");
		if(result.hasErrors()) {
			return "/dashboard.jsp";
		}
		 // Retrieve the logged-in user
	    User loggedUser = userServ.findUser(userId);
	    model.addAttribute("loggedUser", loggedUser);
		User user = userServ.findUser((Long) session.getAttribute("userId"));
		
		iServ.create(newIdea, user);
		return "redirect:/dashboard";
	}
	
	
	// Edit Idea
	@GetMapping("/ideas/edit/{id}")
	public String editIdea(@PathVariable("id")Long id, Model model) {
		String[] weekdays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		model.addAttribute("weekdays", weekdays);
		Idea editIdea = iServ.findById(id);
		model.addAttribute("editIdea", editIdea);
		return "edit.jsp";
	}
	
	// Confirm Edit
	
	@PutMapping("/ideas/edit/{id}")
	public String updateIdea(@Valid @ModelAttribute("editIdea") Idea editIdea, BindingResult result,
	                         @RequestParam("userId") Long userId,
	                         
	                         Model model,
	                         HttpSession session) {
	    if (result.hasErrors()) {
	        return "edit.jsp";
	    }
	    
	    // Retrieve the user associated with the idea
	    User user = userServ.findUser(userId);
	    editIdea.setUser(user); // Set the user associated with the idea
	    
	    iServ.update(editIdea);
	    return "redirect:/dashboard";
	}
	
	// Delete a idea
	/*@RequestMapping("/{id}/delete")
	public String deleteIdea(@PathVariable("id")Long id) {
		iServ.delete(id);
		return "redirect:/home";
	}*/
	@RequestMapping("/{id}/delete")
	public String deleteIdea(@PathVariable("id") Long id) {
	    // Retrieve the idea by its ID
	    Idea idea = iServ.findById(id);
	    
	    // Check if the idea exists
	    if (idea != null) {
	        // Delete all likes associated with the idea
	        List<Like> likes = idea.getLikes();
	    	
	        		for (Like like : likes) {
	            lServ.deleteLike(like.getId());
	        }
	        
	        // Delete the idea itself
	        iServ.delete(id);
	    }
	    
	    return "redirect:/dashboard";
	}
	

	
	@GetMapping("/ideas/view/{ideaId}")
	public String showNewLikeForm(@PathVariable("ideaId") Long ideaId, Model model, HttpSession session) {
	    // Check if the user is logged in
	    Long userId = (Long) session.getAttribute("userId");
	    if (userId == null) {
	        return "redirect:/logout"; // Redirect to logout if the user is not logged in
	    }

	    // Retrieve the logged-in user
	    User loggedUser = userServ.findUser(userId);
	    model.addAttribute("loggedUser", loggedUser);

	    // Retrieve the idea by its ID
	    Idea idea = iServ.findById(ideaId);
	    if (idea == null) {
	        // If the idea is not found, you can handle it accordingly
	        // For example, you can redirect to an error page or display a message
	        return "redirect:/dashboard"; // Redirect to the ideas page
	    }

	    // Retrieve the logged-in user (already retrieved)
	    User user = userServ.findUser(userId);

	    // Add the idea and user objects to the model
	    model.addAttribute("idea", idea);
	    model.addAttribute("user", user);

	 
	    
	    // Create a new Like object and add it to the model
	   Like newLike = new Like();
	    model.addAttribute("newLike", newLike);

	    // Add the idea ID to the model
	    model.addAttribute("ideaId", ideaId);

	    // Return the view containing the form for creating a new like
	    return "show.jsp"; // Assuming you have a JSP file named newLikeForm.jsp
	}


	
	@PostMapping("/ideas/{ideaId}/addlike")
	public String addLikeToIdea(
	    @Valid @ModelAttribute("newLike") Like newLike, BindingResult result,
	    @PathVariable("ideaId") Long ideaId,
	    HttpSession session, Model model) {
		 Long userId = (Long) session.getAttribute("userId");
	    // Check if the user is logged in
	    if (session.getAttribute("userId") == null) {
	        return "redirect:/logout"; // Redirect to logout if the user is not logged in
	    }
	 // Check if the user has already liked the idea
	    if (lServ.hasUserLikedIdea(userId, ideaId)) {
	        // User has already liked the idea, handle accordingly (e.g., display a message)
	        return "redirect:/ideas/view/" + ideaId; // Redirect back to the idea view page
	    }

	    // Retrieve the logged-in user
	  
	    User user = userServ.findUser(userId);

	    // Retrieve the idea by its ID
	    Idea idea = iServ.findById(ideaId);
	    if (idea == null) {
	        // If the idea is not found, you can handle it accordingly
	        // For example, you can redirect to an error page or display a message
	        return "redirect:/dashboard"; // Redirect to the ideas page
	    }

	    // Check if the size of likes is less than 9
	   
	        // Set the user and idea for the new like
	        newLike.setUser(user);
	        newLike.setIdea(idea);

	        // Add the new like to the idea
	        idea.getLikes().add(newLike);

	        // Save the updated idea with the new like
	        iServ.update(idea);

	        // Redirect to the idea view page after adding the like
	        return "redirect:/ideas/view/" + ideaId;
	    
	}

	@RequestMapping("/ideas/{ideaId}/like/{likeId}/delete")
	public String deleteLike(@PathVariable("ideaId") Long ideaId, @PathVariable("likeId") Long likeId) {
	    // Assuming you have a method in your service to delete a like by ID and idea ID
	    lServ.deleteLikeFromIdea(likeId, ideaId);
	    return "redirect:/ideas/view/" + ideaId;
	}
	
}