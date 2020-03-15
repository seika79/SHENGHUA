package com.board.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.board.dto.BoardDto;
import com.util.PageInfo;

public interface BoardDao  {
	
	public int boardCnt(PageInfo pageInfo) throws DataAccessException;
	public List<BoardDto> boardList(PageInfo pageInfo)
			throws DataAccessException;

	public BoardDto boardView(BoardDto dto) throws DataAccessException;

	public void boardModify(BoardDto dto) throws DataAccessException;
	
	public void boardInsert(BoardDto dto) throws DataAccessException;

	public void boardDelete(BoardDto dto) throws DataAccessException;
	
	public void boardHit(BoardDto dto) throws DataAccessException;


}
