package com.photo.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.photo.dto.PhotoDto;
import com.util.PageInfo;

public interface PhotoDao {

	public int photoCnt() throws DataAccessException;
	public List<PhotoDto> photoList(PageInfo pageInfo) throws DataAccessException;
	public void PhotoInsert(PhotoDto dto) throws DataAccessException;
	public PhotoDto photoView(PhotoDto dto) throws DataAccessException;
	public void photoDelete(PhotoDto dto) throws DataAccessException;
	public void photoModify(PhotoDto dto) throws DataAccessException;
}
