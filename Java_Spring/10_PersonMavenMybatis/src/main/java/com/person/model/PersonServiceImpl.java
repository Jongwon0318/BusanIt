package com.person.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.vo.PersonVO;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired //@Resource, @Inject
	private PersonDAOImpl dao;
	
	@Override
	public void insert(PersonVO person) {
		dao.dao_insert("insert", person);		
	}

	@Override
	public List<PersonVO> list(String field, String word) {
		//field.isEmpty() ?  System.out.println("필드값 없음") : map.put("field", field);
		//word.isEmpty() ? System.out.println("검색값 없음") : map.put("word", word);
//		System.out.println("서비스 field, word"+field+word);

//		if(field==null || word==null || field.equals("선택하세요")) {
//			System.out.println("필드값 또는 검색값 없음");
//			return dao.dao_list("list");
//		}else {
//			HashMap<String,String> map=new HashMap<>();
//			map.put("field", field);
//			map.put("word", word);
//			return dao.dao_searchList("searchList",map);
//		}
		HashMap<String,String> map=new HashMap<>();

		if(field==null || word==null || field.equals("선택하세요")) {
			System.out.println("필드값 또는 검색값 없음");
		}else {
			map.put("field", field);
			map.put("word", word);
		}
		return dao.dao_list("list", map);
	}

	@Override
	public PersonVO detail(String id) {
		return dao.dao_detail("detail", id);
	}

	@Override
	public void update(PersonVO person) {
		dao.dao_update("update", person);
	}

	@Override
	public void delete(String id) {
		dao.dao_delete("delete", id);
	}

	@Override
	public int count(String field, String word) {
		HashMap<String,String> map=new HashMap<>();

		if(field==null || word==null || field.equals("선택하세요")) {
			System.out.println("필드값 또는 검색값 없음");
		}else {
			map.put("field", field);
			map.put("word", word);
		}
		return dao.dao_count("count",map);
	}

}
