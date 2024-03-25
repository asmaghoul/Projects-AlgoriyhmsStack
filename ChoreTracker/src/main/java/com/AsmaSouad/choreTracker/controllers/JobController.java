
package com.AsmaSouad.choreTracker.controllers;



import java.util.ArrayList;
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

import com.AsmaSouad.choreTracker.models.Job;
import com.AsmaSouad.choreTracker.models.User;
import com.AsmaSouad.choreTracker.services.JobService;
import com.AsmaSouad.choreTracker.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class JobController {
	@Autowired
	private JobService jobServ; 
	@Autowired
	private UserService userServ; 
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
	    // Route guard
	    Long userId = (Long) session.getAttribute("user_id");
	    if (userId == null) {
	        return "redirect:/";
	    }

	    User loggedUser = userServ.findUser(userId);
	    model.addAttribute("loggedUser", loggedUser);

	    // Fetch all jobs
	    List<Job> allJobs = jobServ.allJobs();
	    
	    // Filter out jobs that are picked by the logged-in user
	    List<Job> pickedJobs = new ArrayList<>();
	    List<Job> remainingJobs = new ArrayList<>();
	    for (Job job : allJobs) {
	        if (job.getPickedBy() != null && job.getPickedBy().getId().equals(userId)) {
	            pickedJobs.add(job);
	        } else {
	            remainingJobs.add(job);
	        }
	    }

	    model.addAttribute("allJobs", remainingJobs);
	    model.addAttribute("pickedJobs", pickedJobs);

	    return "/Jobs/dashboard.jsp";
	}
	
	//Add Job
	@GetMapping("/addJob")
    public String newJob(@ModelAttribute("job") Job job,Model m,HttpSession s) {
    	//Route guard
    Long userId =(Long)s.getAttribute("user_id");
    if(userId == null) {
    	return "redirect:/";
    }
 
		
    	return "Jobs/jobForm.jsp";
    }
  
    @PostMapping("/jobs")
    public String create(@Valid@ModelAttribute("job") Job job, BindingResult result, HttpSession s) {
    Long userId = (Long)s.getAttribute("user_id");
    User loggedUser = userServ.findUser(userId);
    	
    	if (result.hasErrors()) {
            return "/Jobs/jobForm.jsp";
        } else {
        	job.setCreatedBy(loggedUser);
        	jobServ.createJob(job);
    	return "redirect:/dashboard";
        }
    }
    //pick a job and add it
  
    @GetMapping("/joinJob/{id}")
    public String pickJob(@PathVariable("id") Long id, HttpSession session) {
        if (session.getAttribute("user_id") == null) {
            return "redirect:/";
        }
        Job job = jobServ.findJob(id);
        job.setPickedBy(userServ.findUser((Long) session.getAttribute("user_id")));
        jobServ.updateJob(job);
        return "redirect:/dashboard";
    }
    
 // Edit a job 
    @GetMapping("/edit/{id}")
    public String editJobForm(@PathVariable("id") Long id, Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("user_id");
        if (userId == null) {
            return "redirect:/";
        }
        Job job = jobServ.findJob(id);
        if (job == null) {
            return "redirect:/dashboard";
        }
        model.addAttribute("job", job);
        return "/Jobs/editJob.jsp";
    }

    // Update a job 
    @PutMapping("/edit/{id}")
    public String updateJob(@PathVariable("id") Long id, @Valid @ModelAttribute("job") Job updatedJob, BindingResult result, HttpSession session) {
        Long userId = (Long) session.getAttribute("user_id");
        User loggedUser = userServ.findUser(userId);
        if (result.hasErrors()) {
            return "/Jobs/editJob.jsp";
        } else {
            Job job = jobServ.findJob(id);
            if (job == null || !job.getCreatedBy().equals(loggedUser)) {
                return "redirect:/dashboard";
            }
            updatedJob.setCreatedBy(loggedUser);
            updatedJob.setId(job.getId());
            jobServ.updateJob(updatedJob);
            return "redirect:/dashboard";
        }
    }
    
    //Show a Job 
    @RequestMapping("/view/{id}")
    public String viewJob(@PathVariable("id") Long id, Model model) {
	  Job job = jobServ.findJob(id);
	  System.out.println(job.getId());
	  model.addAttribute("id", id);
        model.addAttribute("job", job);
        return "/Jobs/viewJob.jsp";
    }

    //Delete a Job
    @GetMapping("/delete/{id}")
    public String deleteJob(@PathVariable("id") Long id) {
        jobServ.deleteJob(id);
        return "redirect:/dashboard";
    }

}
