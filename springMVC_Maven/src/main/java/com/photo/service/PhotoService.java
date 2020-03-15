package com.photo.service;

import java.util.List;

import com.photo.dto.PhotoDto;
import com.util.PageInfo;

public interface PhotoService {

	public int photoCnt() throws Exception;
	public List<PhotoDto> photoList(PageInfo pageInfo) throws Exception;
	public void photoInsert(PhotoDto dto) throws Exception;
	public PhotoDto photoView(PhotoDto dto) throws Exception;
	public void photoDelete(PhotoDto dto) throws Exception;
	public void photoModify(PhotoDto dto) throws Exception;
	
}
