package com.soni.batch.apprun;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.soni.config.AppConfig;



@SpringBootApplication
@ComponentScan("com.soni.config,com.soni.repository,com.soni.controller,com.soni.repository")
//@MapperScan("com.soni.mybatis")
//@EnableAutoConfiguration
public class Application implements CommandLineRunner
{
//	@Autowired
//	private PersonMapper personMapper;
	
    public static void main( String[] args )
    {
    	SpringApplication.run(Application.class, args);	
    }

	@Override
	public void run(String... args) throws Exception {
		System.out.println("####################################################");
//		System.out.println(personMapper.myBatisSelectSQL("select * from person"));        

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        JobLauncher  jobLauncher = ctx.getBean(JobLauncher.class);
        Job job = (Job)ctx.getBean("myJob");
        try {
            jobLauncher.run(job, new JobParameters());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ctx.close();
		System.out.println("####################################################");
	}
}
