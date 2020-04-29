package org.zerock.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.MemberVO;

public interface MemberMapper {
	public MemberVO read(String userid);
	public void insert(MemberVO vo);
	public void authInsert(@Param("userid") String userid,
			@Param("auth") String auth);
	
	public int memberIdCheck(String userid);
}
