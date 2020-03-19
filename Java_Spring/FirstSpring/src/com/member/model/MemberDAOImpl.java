package com.member.model;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class MemberDAOImpl implements MemberDAO{
	
	private JdbcTemplate template;
	
	//setter
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
		
	//��ü����
	@Override
	public List<MemberDTO> getMemberList() {
		String sql="SELECT * FROM SPRINGMEMBER";
		//.query��� ��ɾ��� �������� List���·� ����.
		List<MemberDTO> userlist = template.query(sql,new MemberRowMapper());
		return userlist;
	}
	
	//�󼼺���
	@Override
	public MemberDTO findById(String id) {
		//String sql="SELECT * FROM SPRINGMEMBER WHERE ID=?";
		//MemberDTO user=template.queryForObject(sql,new Object[]{id}, new MemberRowMapper());
		String sql="SELECT * FROM SPRINGMEMBER WHERE ID='"+id+"'";
		MemberDTO user=template.queryForObject(sql, new MemberRowMapper());
		return user;
	}

	//����ϱ�
	@Override
	public void insert(MemberDTO user) {
		String sql="INSERT INTO SPRINGMEMBER VALUES(?,?,?,?,?,SYSDATE)";
		Object[] param=new Object[] {
			user.getId(),
			user.getPass(),
			user.getName(),
			user.getAddr(),
			user.getMemo()
		};
		int i = template.update(sql,param);
		System.out.println(i+"�� �� ����");
	}

	//�����ϱ�
	@Override
	public void update(MemberDTO user) {
		String sql="UPDATE SPRINGMEMBER"
				+" SET NAME='"+user.getName()+"', ADDR='"+user.getAddr()+"', MEMO='"+user.getMemo()+"'"
				+" WHERE ID='"+user.getId()+"'";
		//String sql="UPDATE SPRINGMEMBER SET NAME=?, ADDR=?, MEMO=? WHERE ID=?;"
		//Object[] param=new Object[]{user.getName(), user.getAddr(), user.getMemo(), user.getId()};
		//template.update(sql,param);
		template.update(sql);
		System.out.println("���� �Ϸ�");
	}

	//�����ϱ�
	@Override
	public void delete(String id) {
		String sql="DELETE FROM SPRINGMEMBER WHERE ID='"+id+"'";
		template.batchUpdate(sql);
		System.out.println("���� �Ϸ�");
	}


}
