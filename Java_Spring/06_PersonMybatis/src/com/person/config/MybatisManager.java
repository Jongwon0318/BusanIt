package com.person.config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisManager {
	
	private static SqlSessionFactory sqlMapper;
	
	static {
		String resource="com/person/config/Configuration.xml";
		try {
			Reader reader=Resources.getResourceAsReader(resource);
			sqlMapper=new SqlSessionFactoryBuilder().build(reader);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getMapper() {
		return sqlMapper;
	}

}
