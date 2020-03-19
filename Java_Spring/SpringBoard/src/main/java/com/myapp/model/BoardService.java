package com.myapp.model;

import java.util.HashMap;
import java.util.List;

public interface BoardService {
	
	//�߰�
	public void insert(BoardVO board);
	
	//����
	public void update(BoardVO board);
	
	//����
	public void delete(int num);
	
	//���
	public List<BoardVO> list(HashMap<String,Object> hm);
	
	//�󼼺���
	public BoardVO detail(int num);
	
	//ī��Ʈ
	public int count(HashMap<String, Object> hm);
	
	//��ȸ��
	public int hitCount(int num);
}
