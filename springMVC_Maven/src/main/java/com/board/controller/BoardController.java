package com.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.board.dto.BoardDto;
import com.board.service.BoardService;
import com.util.PageInfo;
import com.util.PageUtil;

@Controller
public class BoardController {

	@Autowired
	//private BoardServiceImpl boardService;
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService){
		//this.boardService = boardService;
		this.boardService = boardService;
	}
	
	
	@RequestMapping(value="/board/list.do")
	public ModelAndView boardList(PageInfo pageInfo) throws Exception{
		
		int totalCnt = boardService.boardCnt(pageInfo);
		
		int pageCnt = PageUtil.getPageCnt(pageInfo.getNumPerPage(), totalCnt);
		
		int currentPage = PageUtil.setCurrentPage(pageInfo.getPageNo(), pageCnt);
		
		
		String pageIndex = PageUtil.pageIndexList(currentPage, pageCnt, "board");
		
		pageInfo.setPageBlock(currentPage);
		
		List<BoardDto> boardList = boardService.boardList(pageInfo);
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/list");
		mav.addObject("totalCnt", totalCnt);
		mav.addObject("pageNo", currentPage);
		mav.addObject("pageIndex", pageIndex);
		mav.addObject("numPerPage", pageInfo.getNumPerPage());
		mav.addObject("boardList", boardList);
		
		return mav;
	}
	
	@RequestMapping(value="/board/write.do")
	public String boardWrite(){
		return "board/write";
	}
	
	@RequestMapping(value="/board/writeAct.do")
	public String boardWriteAct(BoardDto dto, @RequestParam("upload") MultipartFile multipartFile,
			HttpServletRequest request) throws Exception {

		if (!multipartFile.isEmpty()) {
			String root = request.getSession().getServletContext().getRealPath("/");
			System.out.println("root : " + root);

			String filePath = root + "file" + File.separator + "board" + File.separator;

			File dir = new File(filePath);

			if (!dir.exists()) {
				dir.mkdirs();
			}

			String orgFileName = multipartFile.getOriginalFilename();
			String savedFileName = "board_" + System.currentTimeMillis()
					+ orgFileName.substring(orgFileName.lastIndexOf("."));
			System.out.println("savedFileName: " + savedFileName);

			dto.setFileYn("Y");
			dto.setOrgFileName(orgFileName);
			dto.setSavedFileName(savedFileName);

			InputStream is = multipartFile.getInputStream();
			FileOutputStream fos = new FileOutputStream(new File(filePath, savedFileName));
			FileCopyUtils.copy(is, fos);

		}

		boardService.boardInsert(dto);

		return "redirect:/board/list.do";
	}

	@RequestMapping(value = "/board/modify.do")
	public ModelAndView boardModify(BoardDto dto) throws Exception {

		BoardDto resultDto = boardService.boardView(dto);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/modify");
		mav.addObject("dto", resultDto);

		return mav;
	}

	@RequestMapping(value = "/board/modifyAct.do")
	public String boardModifyAct(BoardDto dto, @RequestParam("upload") MultipartFile multipartFile,
			HttpServletRequest request) throws Exception {

		if (!multipartFile.isEmpty()) {
			String root = request.getSession().getServletContext().getRealPath("/");

			String filePath = root + "file" + File.separator + "board" + File.separator;

			File dir = new File(filePath);

			if (!dir.exists()) {
				dir.mkdirs();
			}

			String orgFileName = multipartFile.getOriginalFilename();
			String savedFileName = "board_" + System.currentTimeMillis()
					+ orgFileName.substring(orgFileName.lastIndexOf("."));

			dto.setFileYn("Y");
			dto.setOrgFileName(orgFileName);
			dto.setSavedFileName(savedFileName);

			InputStream is = multipartFile.getInputStream();
			FileOutputStream fos = new FileOutputStream(new File(filePath, savedFileName));
			FileCopyUtils.copy(is, fos);

		}

		boardService.boardModify(dto);

		return "redirect:/board/list.do";
	}

	@RequestMapping(value = "/board/view.do")
	public ModelAndView boardView(BoardDto dto) throws Exception {

		BoardDto resultDto = boardService.boardView(dto);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/view");
		mav.addObject("dto", resultDto);

		return mav;
	}

	@RequestMapping(value = "/board/download.do")
	public void boardDown(BoardDto dto, HttpServletRequest request, HttpServletResponse response) throws Exception {

		BoardDto resultDto = boardService.boardView(dto);
		String root = request.getSession().getServletContext().getRealPath("/");

		String filePath = root + "file" + File.separator + "board" + File.separator;

		String orgFileName = resultDto.getOrgFileName();
		String savedFileName = resultDto.getSavedFileName();
		orgFileName = new String(orgFileName.getBytes("EUC-KR"), "ISO_8859_1");

		response.setContentType("application/octet-stream");
		response.setHeader("content-disposition", "attachment;filename=" + orgFileName);

		OutputStream os = response.getOutputStream();
		FileInputStream fis = new FileInputStream(filePath + savedFileName);

		int n;
		byte bytes[] = new byte[4096];

		while ((n = fis.read(bytes)) != -1) {
			os.write(bytes, 0, n);
		}
		os.flush();
		os.close();
		fis.close();

	}

	@RequestMapping(value = "/board/deleteAct.do")
	public String boardDelete(BoardDto dto) throws Exception {

		boardService.boardDelete(dto);
		return "redirect:/board/list.do";
	}
}
