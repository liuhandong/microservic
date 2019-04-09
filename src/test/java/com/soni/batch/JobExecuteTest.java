package com.soni.batch;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.soni.config.PersonJobConfig;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {PersonJobConfig.class})
public class JobExecuteTest {

}
