package com.soni.batch.apprun;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



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
		System.out.println("####################################################");
	}
}
