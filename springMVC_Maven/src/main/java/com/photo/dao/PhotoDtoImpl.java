package com.photo.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Component;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.photo.dto.PhotoDto;
import com.util.PageInfo;
@Component
public class PhotoDtoImpl extends SqlMapClientDaoSupport implements PhotoDao {

	@Resource(name = "sqlMapClient")  
	private SqlMapClient sqlMapClient;  
    
	@PostConstruct  
    public void initSqlMapClient(){  
		super.setSqlMapClient(sqlMapClient);  
    }
	
	public int photoCnt() throws DataAccessException {
		return (Integer)getSqlMapClientTemplate().queryForObject("photoCnt");
	}

	@SuppressWarnings("unchecked")
	public List<PhotoDto> photoList(PageInfo pageInfo)
			throws DataAccessException {
		List<PhotoDto> list = getSqlMapClientTemplate().queryForList("photoList", pageInfo);
		return list;
	}

	public void PhotoInsert(PhotoDto dto) throws DataAccessException {
		getSqlMapClientTemplate().insert("photoInsert", dto);
	}

	public PhotoDto photoView(PhotoDto dto) throws DataAccessException {
		return (PhotoDto)getSqlMapClientTemplate().queryForObject("photoView", dto);
	}

	public void photoDelete(PhotoDto dto) throws DataAccessException {
		getSqlMapClientTemplate().update("photoDelete", dto);
	}

	public void photoModify(PhotoDto dto) throws DataAccessException {
		getSqlMapClientTemplate().update("photoModify", dto);
	}

}
