package com.member.dao;

import org.springframework.dao.DataAccessException;

import com.member.dto.MemberDto;

public interface MemberDao {
	
	public void memberInsert(MemberDto dto) throws DataAccessException;
	public MemberDto memberLogin(MemberDto dto) throws DataAccessException;
	public String memberCheck(String loginId) throws DataAccessException;

}
