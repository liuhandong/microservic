package com.soni.repository;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.soni.mybatis.PersonMapper;
@Repository
public class CustomizedRepositoryImpl implements CustomizedRepository{
	@Autowired
    PersonMapper employeeMapper;
 
    @Override
    public List<LinkedHashMap<String, Object>> myBatisSelectSQL(String sql)
    {
        return employeeMapper.myBatisSelectSQL(sql);
    }
 
    @Override
    public int myBatisUpdateSQL(String sql)
    {
        return employeeMapper.myBatisUpdateSQL(sql);
    }
}
