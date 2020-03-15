package com.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

public class FileManager {

	public static boolean down(HttpServletResponse response, String savedFileName, String originalFileName, String path){
		try{
			String filePath = path+File.separator+savedFileName;
			System.out.println("filePath : "+filePath);
			if("".equals(originalFileName)|| originalFileName == null ){
				originalFileName = savedFileName;
			}
			originalFileName = new String(originalFileName.getBytes("EUC-KR"), "ISO_8859_1");
			
			File file = new File(filePath);
			
			if(! file.exists()){
				return false;
			}
			response.setContentType("application/octet-stream");
			response.setHeader("content-disposition", "attachment;filename="+originalFileName);
			
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			OutputStream os = response.getOutputStream();
			
			int n;
			byte bytes[] = new byte[4096];
			
			while((n=bis.read(bytes,0,4096))!=-1){
				os.write(bytes, 0, n);
			}
			os.flush();
			os.close();
			bis.close();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static void delete(String savedFileName, String path){
		try{
			String filePath = path + File.separator+savedFileName;
			File file = new File(filePath);
			if(file.exists()){
				file.delete();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
