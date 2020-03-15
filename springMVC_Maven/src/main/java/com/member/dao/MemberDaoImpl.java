package com.member.dao;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Component;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.member.dto.MemberDto;

@Component 
public class MemberDaoImpl extends SqlMapClientDaoSupport implements MemberDao {

	@Resource(name = "sqlMapClient")  
	private SqlMapClient sqlMapClient;  
    
	@PostConstruct  
    public void initSqlMapClient(){  
		super.setSqlMapClient(sqlMapClient);  
    }
	
	public void memberInsert(MemberDto dto) throws DataAccessException {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().insert("memberInsert", dto);
	}

	public MemberDto memberLogin(MemberDto dto) throws DataAccessException {
		// TODO Auto-generated method stub
		return (MemberDto)getSqlMapClientTemplate().queryForObject("memberLogin", dto);
	}

	public String memberCheck(String loginId) throws DataAccessException {
		// TODO Auto-generated method stub
		return (String)getSqlMapClientTemplate().queryForObject("memberCheck", loginId);
	}

}
