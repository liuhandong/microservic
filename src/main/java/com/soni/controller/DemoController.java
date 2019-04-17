package com.soni.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController {
	//@Autowired
    SimpleJobLauncher jobLauncher;

    //@Autowired
    Job importJob;

    public JobParameters jobParameters;
    
    @Scheduled(cron = "0 0/5 * * * ?")
    @RequestMapping("/runjob")
    public void imp() throws  Exception{
        jobParameters = new JobParametersBuilder()
                .addLong("time",System.currentTimeMillis())
                .toJobParameters();
        jobLauncher.run(importJob,jobParameters);
    }
    
    @RequestMapping(value="login",method=RequestMethod.GET)
    public String login() {
    	return "login";
    }

    @RequestMapping({"/","/index"})
    public String index() {
    	return "index";
    }
}
