package com.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.BoardDao;
import com.board.dto.BoardDto;
import com.util.PageInfo;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao){
		this.boardDao = boardDao;
	}
	
	public ArrayList<BoardDto> mainBoardList() throws Exception {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setStart(1);
		pageInfo.setEnd(5);
		List<BoardDto> orgList = boardDao.boardList(pageInfo);
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		for(int i=0;i<orgList.size();i++){
			BoardDto dto = orgList.get(i);
			dto.setTitle(dto.getTitle().replaceAll("#34", "'"));
			list.add(dto);
		}
		return list;
		
	}

}
