package com.guestapp.mapper;

import java.util.HashMap;
import java.util.List;

import com.guestapp.vo.GuestVO;

public interface GuestMapper {

	public void insert(GuestVO guest);
	
	public List<GuestVO> list(HashMap<String, Object> hm);
	
	public void update(GuestVO guest);
	
	public void delete(int num);
	
	public GuestVO view(int num);
	
	public int count(HashMap<String,Object> hm);
}
