package com.photo.dto;

public class PhotoDto {

	private int 	seqNo;
	private String	title;
	private String	contents;
	private String	writer;
	private String	loginId;
	private String	createDate;
	private String	updateDate;
	private String	imgOrgFile;
	private String	imgSavedFile;
	private String	thumbnail;
	private String	imgYn;
	private String 	delYn;
	private int		hit;
	
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getImgOrgFile() {
		return imgOrgFile;
	}
	public void setImgOrgFile(String imgOrgFile) {
		this.imgOrgFile = imgOrgFile;
	}
	public String getImgSavedFile() {
		return imgSavedFile;
	}
	public void setImgSavedFile(String imgSavedFile) {
		this.imgSavedFile = imgSavedFile;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getImgYn() {
		return imgYn;
	}
	public void setImgYn(String imgYn) {
		this.imgYn = imgYn;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	
	
}
