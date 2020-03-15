package com.board.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Component;

import com.board.dto.BoardDto;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.util.PageInfo;

@Component 
public class BoardDaoImpl extends SqlMapClientDaoSupport implements BoardDao {
	
	@Resource(name = "sqlMapClient")  
	private SqlMapClient sqlMapClient;  
    
	@PostConstruct  
    public void initSqlMapClient(){  
		super.setSqlMapClient(sqlMapClient);  
    }   
	
	public int boardCnt(PageInfo pageInfo) throws DataAccessException {
		return (Integer)getSqlMapClientTemplate().queryForObject("boardCnt",pageInfo);
 
	}

	@SuppressWarnings("unchecked")
	
	public List<BoardDto> boardList(PageInfo pageInfo)
			throws DataAccessException {
		return getSqlMapClientTemplate().queryForList("boardList", pageInfo);
	}

	
	public BoardDto boardView(BoardDto dto) throws DataAccessException {
		return (BoardDto)getSqlMapClientTemplate().queryForObject("boardView", dto);
	}

	
	public void boardModify(BoardDto dto) throws DataAccessException {
		getSqlMapClientTemplate().insert("boardUpdate", dto);

	}

	
	public void boardInsert(BoardDto dto) throws DataAccessException {
		getSqlMapClientTemplate().insert("boardInsert", dto);

	}

	
	public void boardDelete(BoardDto dto) throws DataAccessException {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().delete("boardDelete", dto);
	}

	
	public void boardHit(BoardDto dto) throws DataAccessException {
		getSqlMapClientTemplate().update("boardHit", dto);
		
	}


}
