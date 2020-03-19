package com.person.model;

import java.util.HashMap;
import java.util.List;

import com.person.vo.PersonVO;

public interface PersonDAO {
	
	public void dao_insert(String idName, PersonVO person);
	
	public List<PersonVO> dao_list(String idName, HashMap<String,String> map);

//	public List<PersonVO> dao_searchList(String idName, HashMap<String,String> map);

	
	public PersonVO dao_detail(String idName, String id);
	
	public void dao_update(String idName, PersonVO person);
	
	public void dao_delete(String idName, String id);

	public int dao_count(String idName,HashMap<String, String> map);
	
//	public int dao_searchCount(String idName,HashMap<String, String> map);
}
