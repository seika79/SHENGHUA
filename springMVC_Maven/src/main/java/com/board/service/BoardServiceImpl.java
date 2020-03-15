package com.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.board.dao.BoardDao;
import com.board.dto.BoardDto;
import com.util.PageInfo;

@Component
public class BoardServiceImpl  implements BoardService{

	@Autowired
	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao){
		this.boardDao = boardDao;
	}
	
	@Transactional(readOnly = true)
	public int boardCnt(PageInfo pageInfo) throws Exception {
		return boardDao.boardCnt(pageInfo);
	}

	@Transactional(readOnly = true)
	public ArrayList<BoardDto> boardList(PageInfo pageInfo) throws Exception {
		
		List<BoardDto> orgList = boardDao.boardList(pageInfo);
		ArrayList<BoardDto> list = new ArrayList();
		for(int i=0;i<orgList.size();i++){
			BoardDto dto = orgList.get(i);
			dto.setTitle(dto.getTitle().replaceAll("#34", "'"));
			list.add(dto);
		}
		
		return list;
	}

	public BoardDto boardView(BoardDto dto) throws Exception {
		
		BoardDto resultDto = boardDao.boardView(dto);
		System.out.println("getOrgFileName : "+resultDto.getOrgFileName());
	//	dto.setTitle(dto.getTitle().replaceAll("#34", "'"));
	//	dto.setContents(dto.getContents().replaceAll("#34", "'"));
		try{
		//boardDao.boardHit(dto);
		}catch(Exception e){
			e.printStackTrace();
		}
		return resultDto;
	}
	

	@Transactional
	public void boardModify(BoardDto dto) throws Exception {
		// TODO Auto-generated method stub
		boardDao.boardModify(dto);
	}

	@Transactional
	public void boardInsert(BoardDto dto) throws Exception {
		
		dto.setTitle(dto.getTitle().replaceAll("'", "#34"));
		boardDao.boardInsert(dto);
	}

	@Transactional
	public void boardDelete(BoardDto dto) throws Exception {
		boardDao.boardDelete(dto);
	}

	public void boardHit(BoardDto dto) throws Exception {
		boardDao.boardHit(dto);
	}

}
