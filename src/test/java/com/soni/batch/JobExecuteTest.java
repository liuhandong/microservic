package com.soni.batch;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.soni.config.JobConfig;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {JobConfig.class})
public class JobExecuteTest {

}
