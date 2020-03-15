package com.member.service;

import com.member.dto.MemberDto;

public interface MemberService {

	public void memberInsert(MemberDto dto) throws Exception;
	public MemberDto memberLogin(MemberDto dto) throws Exception;
	public String memberCheck(String loginId) throws Exception;
}
