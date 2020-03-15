package com.photo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.photo.dao.PhotoDao;
import com.photo.dto.PhotoDto;
import com.util.PageInfo;

@Service
public class PhotoServiceImpl implements PhotoService {

	@Autowired
	private PhotoDao photoDao;
	
	public void setPhotoDao(PhotoDao photoDao){
		this.photoDao = photoDao;
	}
	public int photoCnt() throws Exception {		
		return photoDao.photoCnt();
	}

	public List<PhotoDto> photoList(PageInfo pageInfo) throws Exception {
		return photoDao.photoList(pageInfo);
	}

	public void photoInsert(PhotoDto dto) throws Exception {
		photoDao.PhotoInsert(dto);
	}

	public PhotoDto photoView(PhotoDto dto) throws Exception {
		return photoDao.photoView(dto);
	}
	public void photoDelete(PhotoDto dto) throws Exception {
		photoDao.photoDelete(dto);
	}
	public void photoModify(PhotoDto dto) throws Exception {
		photoDao.photoModify(dto);
	}

}
