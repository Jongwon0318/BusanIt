package com.myapp.model;

import java.util.HashMap;
import java.util.List;

public interface BoardDAO {
	
	//�߰�
	public void dao_insert(BoardVO board);
	
	//����
	public void dao_update(BoardVO board);
	
	//����
	public void dao_delete(int num);
	
	//���
	public List<BoardVO> dao_list(HashMap<String,Object> hm);
	
	//�󼼺���
	public BoardVO dao_detail(int num);
	
	//ī��Ʈ
	public int dao_count(HashMap<String, Object> hm);
	
	//��ȸ��
	public int dao_hitCount(int num);
	
	//����߰�
	public void dao_addComment(CommentVO comment);
	
	//��۸��
	public List<CommentVO> dao_getComments(int bnum);
	
	//��ۻ���
	public void dao_commentDelete(int cnum);
	
	//��۹�ȯ
	public CommentVO dao_commentDetail(int cnum);
}
