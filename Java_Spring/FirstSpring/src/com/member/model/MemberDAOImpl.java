package com.member.model;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class MemberDAOImpl implements MemberDAO{
	
	private JdbcTemplate template;
	
	//setter
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
		
	//전체보기
	@Override
	public List<MemberDTO> getMemberList() {
		String sql="SELECT * FROM SPRINGMEMBER";
		//.query라는 명령어의 수행결과는 List형태로 담긴다.
		List<MemberDTO> userlist = template.query(sql,new MemberRowMapper());
		return userlist;
	}
	
	//상세보기
	@Override
	public MemberDTO findById(String id) {
		//String sql="SELECT * FROM SPRINGMEMBER WHERE ID=?";
		//MemberDTO user=template.queryForObject(sql,new Object[]{id}, new MemberRowMapper());
		String sql="SELECT * FROM SPRINGMEMBER WHERE ID='"+id+"'";
		MemberDTO user=template.queryForObject(sql, new MemberRowMapper());
		return user;
	}

	//등록하기
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
		System.out.println(i+"개 행 삽입");
	}

	//수정하기
	@Override
	public void update(MemberDTO user) {
		String sql="UPDATE SPRINGMEMBER"
				+" SET NAME='"+user.getName()+"', ADDR='"+user.getAddr()+"', MEMO='"+user.getMemo()+"'"
				+" WHERE ID='"+user.getId()+"'";
		//String sql="UPDATE SPRINGMEMBER SET NAME=?, ADDR=?, MEMO=? WHERE ID=?;"
		//Object[] param=new Object[]{user.getName(), user.getAddr(), user.getMemo(), user.getId()};
		//template.update(sql,param);
		template.update(sql);
		System.out.println("수정 완료");
	}

	//삭제하기
	@Override
	public void delete(String id) {
		String sql="DELETE FROM SPRINGMEMBER WHERE ID='"+id+"'";
		template.batchUpdate(sql);
		System.out.println("삭제 완료");
	}


}
