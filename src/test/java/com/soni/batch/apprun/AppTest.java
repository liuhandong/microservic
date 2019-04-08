package com.soni.batch.apprun;

import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.soni.repository.CustomizedRepository;

//import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*; 
 
import junit.framework.TestCase;
/**
 * Junit4中的新断言 https://blog.csdn.net/smxjant/article/details/78206435
 * @author handong.liu
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest extends TestCase {

	@Autowired
	private CustomizedRepository customizedRepository;
	
	// MyBatis insert
	@Test
	public void testInsertSQL() throws Exception {
		/*
insert into person (name,age,nation,address) value('test01',20,'china','dalian');
insert into person (name,age,nation,address) value('test02',45,'china','dalian');
insert into person (name,age,nation,address) value('test03',23,'china','dalian');
insert into person (name,age,nation,address) value('test04',18,'china','dalian');
		 */
		String sql="insert into person (name,age,nation,address) values('test01',20,'china','dalian')," + 
				"('test02',45,'china','dalian')," + 
				"('test03',23,'china','dalian')," + 
				"('test04',18,'china','dalian')";
		customizedRepository.myBatisUpdateSQL(sql);
		List<LinkedHashMap<String, Object>> items = customizedRepository.myBatisSelectSQL("SELECT * FROM person");
		assertEquals(items.size(), is(4));
		customizedRepository.myBatisUpdateSQL("delete from person");
		List<LinkedHashMap<String, Object>> delitems = customizedRepository.myBatisSelectSQL("SELECT * FROM person");
		assertEquals(delitems.size(),0);
		
	}
	

	// MyBatis Select
	@Test
	public void testSelectSQL() throws Exception {
		String sql="insert into person (name,age,nation,address) values('test01',20,'china','dalian')," + 
				"('test02',45,'china','dalian')," + 
				"('test03',23,'china','dalian')," + 
				"('test04',18,'china','dalian')";
		customizedRepository.myBatisUpdateSQL(sql);
		List<LinkedHashMap<String, Object>> items = customizedRepository.myBatisSelectSQL("SELECT * FROM person");
		for (LinkedHashMap<String, Object> hashMap : items) {
			for (String key : hashMap.keySet()) {
				System.out.println(key + ":" + hashMap.get(key));
			}
			System.out.println("--------------");
		}
		customizedRepository.myBatisUpdateSQL("delete from person");
	}
}
