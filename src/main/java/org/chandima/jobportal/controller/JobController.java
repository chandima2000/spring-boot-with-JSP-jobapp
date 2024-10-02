package org.chandima.jobportal.controller;

import org.chandima.jobportal.model.JobPost;
import org.chandima.jobportal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping({"/","home"})
    public String home(){
        return "home";
    }

    @GetMapping("addjob")
    public String addJob(){
        return "addjob";
    }

    @PostMapping("handleForm")
    public String handleForm(@ModelAttribute JobPost jobPost){
        jobService.addJob(jobPost);
        return "success";
    }

    @GetMapping("viewalljobs")
    public String viewAllJobs(Model model){ // Use Model
        List<JobPost> jobs = jobService.getAllJobs();  // Get the List of Jobs
        model.addAttribute("jobPosts",jobs); // Send the List of Jobs to the Frontend
        return "viewalljobs";
    }
}
