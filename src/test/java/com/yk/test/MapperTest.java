package com.yk.test;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yk.dao.DepartMentMapper;
import com.yk.dao.UserMapper;
import com.yk.pojo.DepartMent;
import com.yk.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	DepartMentMapper deptmapper;
	@Autowired
	UserMapper usermapper;
	@Autowired
	SqlSession sqlsessoin;
	
	@Test
	public void test() {
		/*deptmapper.insertSelective(new DepartMent(null,"开发部","028-1234"));
		deptmapper.insertSelective(new DepartMent(null,"销售部","028-3521"));*/
		usermapper.insertSelective(new User(null,10001,"123456","杨宽","男",new Date(),"","",null,null));
		System.out.println("添加完成");
	}
}
