package com.photo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.photo.dto.PhotoDto;
import com.photo.service.PhotoService;
import com.util.PageInfo;
import com.util.PageUtil;
import com.util.Thumbnail;

@Controller
public class PhotoController {

	@Autowired
	private PhotoService photoService;
	
	public void setPhotoService(PhotoService photoService){
		this.photoService = photoService;
	}
	
	@RequestMapping(value="/photo/list.do")
	public ModelAndView photoList(PageInfo pageInfo) throws Exception{
		int totalCnt = photoService.photoCnt();
		
		pageInfo.setNumPerPage(5);
		int pageCnt = PageUtil.getPageCnt(pageInfo.getNumPerPage(), totalCnt);
		
		int currentPage = PageUtil.setCurrentPage(pageInfo.getPageNo(), pageCnt);
		
		String pageIndex = PageUtil.pageIndexList(currentPage, pageCnt, "photo");
		
		pageInfo.setPageBlock(currentPage);
		
		List<PhotoDto> photoList = photoService.photoList(pageInfo);
		for(int i=0; i<photoList.size();i++){
			PhotoDto resultDto = photoList.get(i);
		}		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("photo/list"); 
		mav.addObject("totalCnt", totalCnt);
		mav.addObject("pageNo", currentPage);
		mav.addObject("pageIndex", pageIndex);
		mav.addObject("numPerPage", pageInfo.getNumPerPage());
		mav.addObject("photoList", photoList);		
		return mav;
	}
	
	@RequestMapping(value="/photo/write.do")
	public String photoWrite(){
		return "photo/write";
	}
	
	@RequestMapping(value="/photo/writeAct.do")
	public String photoWriteAct(PhotoDto dto
			,@RequestParam("upload") MultipartFile multipartFile
			, HttpServletRequest request			
			) throws Exception{
		
		if(!multipartFile.isEmpty()){
			String root = request.getSession().getServletContext().getRealPath("/");
			
			String filePath = root+"file"+File.separator+"photo"+File.separator;
			
			   File  dir = new File(filePath);
			   if(!dir.exists()){
			   	   dir.mkdirs();
			   }
			   
			   String imgOrgFile = multipartFile.getOriginalFilename();
			   String imgSavedFile = "photo_"+System.currentTimeMillis()+imgOrgFile.substring(imgOrgFile.lastIndexOf("."));
			   String thumbnail = "thumb_"+imgSavedFile;
			   
			   dto.setImgYn("Y");
			   dto.setImgOrgFile(imgOrgFile);
			   dto.setImgSavedFile(imgSavedFile);
			   dto.setThumbnail(thumbnail);
			   
			   InputStream is = multipartFile.getInputStream();
			   FileOutputStream fos = new FileOutputStream(new File(filePath, imgSavedFile));
			   FileCopyUtils.copy(is, fos);
			   
			   Thumbnail.createThumb(new File(filePath+File.separator+imgSavedFile), new File(filePath+File.separator+thumbnail), 100, 100);
			
		}
		photoService.photoInsert(dto);
		return "redirect:/photo/list.do";
	}
	
	@RequestMapping(value="/photo/view.do")
	public ModelAndView photoView(PhotoDto dto) throws Exception{
		
		PhotoDto resultDto = photoService.photoView(dto);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("photo/view");
		mav.addObject("dto", resultDto);
		return mav;
		
	}
	
	@RequestMapping(value="/photo/deleteAct.do")
	public String photoDelete(PhotoDto dto
			, HttpServletRequest request
			) throws Exception{

		PhotoDto resultDto = photoService.photoView(dto);
		String root = request.getSession().getServletContext().getRealPath("/");
		
		String filePath = root+"file"+File.separator+"photo"+File.separator;
		

		 String imgSavedFile = resultDto.getImgSavedFile();
		 String thumbnail = resultDto.getThumbnail();
		   
		   File  savedFile = new File(filePath+File.separator+imgSavedFile);
		   File	 thumbnailFile = new File(filePath+File.separator+thumbnail);
		   if(savedFile.exists()){
			   savedFile.delete();
		   }
		   if(thumbnailFile.exists()){
			   thumbnailFile.delete();
		   }
		
		photoService.photoDelete(dto);
		return "redirect:/photo/list.do";
	}
	@RequestMapping(value="/photo/modify.do")
	public ModelAndView photoModify(PhotoDto dto) throws Exception{
		
		PhotoDto resultDto = photoService.photoView(dto);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("photo/modify");
		mav.addObject("dto", resultDto);
		return mav;		
	}
	
	@RequestMapping(value="/photo/modifyAct.do")
	public String photoModifyAct(PhotoDto dto
			, @RequestParam("upload") MultipartFile multipartFile
			, HttpServletRequest request
			
			) throws Exception{
		String imgOrgFile = "";
		String imgSavedFile = "";
		String thumbnail = "";
		
		if(!multipartFile.isEmpty()){
			String root = request.getSession().getServletContext().getRealPath("/");
			
			String filePath = root+"file"+File.separator+"photo"+File.separator;
			
			   File  dir = new File(filePath);
			   
			   if(!dir.exists()){
			   	   dir.mkdirs();
			   }
			   
			   imgOrgFile = multipartFile.getOriginalFilename();
			   imgSavedFile = "photo_"+System.currentTimeMillis()+imgOrgFile.substring(imgOrgFile.lastIndexOf("."));
			   thumbnail = "thumb_"+imgSavedFile;
			   
			   InputStream is = multipartFile.getInputStream();
			   FileOutputStream fos = new FileOutputStream(new File(filePath, imgSavedFile));
			   FileCopyUtils.copy(is, fos);
			   
			   Thumbnail.createThumb(new File(filePath+File.separator+imgSavedFile), new File(filePath+File.separator+thumbnail), 100, 100);
			   
			   String org_imgSavedFile = dto.getImgSavedFile();
			   String org_thumbnail = "thumb_"+org_imgSavedFile;				   
				
			   File  delete_org_imgSavedFile = new File(filePath+File.separator+org_imgSavedFile);
			   File	 delete_org_thumbnail = new File(filePath+File.separator+org_thumbnail);
			
			   if(delete_org_imgSavedFile.exists()){
				   delete_org_imgSavedFile.delete();
			   }
			   if(delete_org_thumbnail.exists()){
				   delete_org_thumbnail.delete();
			   }
			   
			   dto.setImgYn("Y");
			   dto.setImgOrgFile(imgOrgFile);
			   dto.setImgSavedFile(imgSavedFile);
			   dto.setThumbnail(thumbnail);
		}else{
			imgOrgFile = dto.getImgOrgFile();
			imgSavedFile = dto.getImgSavedFile();
			thumbnail = "thumb_"+dto.getImgSavedFile();
			dto.setImgYn("Y");
			dto.setThumbnail(thumbnail);			
		}
		photoService.photoModify(dto);
		return "redirect:/photo/list.do";
	}
}
