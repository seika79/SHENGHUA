package com.member.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.member.dao.MemberDao;
import com.member.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao ){
		this.memberDao = memberDao;
	}

	public void memberInsert(MemberDto dto) throws Exception{
		memberDao.memberInsert(dto);
	}

	public MemberDto memberLogin(MemberDto dto) throws Exception {
		return memberDao.memberLogin(dto);
	}

	public String memberCheck(String loginId) throws Exception {
		
		return memberDao.memberCheck(loginId);
	}
	
	
}
