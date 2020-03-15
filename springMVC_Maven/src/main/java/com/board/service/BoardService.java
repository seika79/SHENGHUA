package com.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.board.dto.BoardDto;
import com.util.PageInfo;

@Service
public interface BoardService {

	public int boardCnt(PageInfo pageInfo) throws Exception;
	public List<BoardDto> boardList(PageInfo pageInfo) throws Exception;
	public BoardDto boardView(BoardDto dto) throws Exception;
	public void boardModify(BoardDto dto) throws Exception;
	public void boardInsert(BoardDto dto) throws Exception;
	public void boardDelete(BoardDto dto) throws Exception;
	public void boardHit(BoardDto dto) throws Exception;

}
