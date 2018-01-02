package com.nxsol.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.jsp.PageContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileUpload {

	@RequestMapping(value="/upload",method=RequestMethod.POST)
	@ResponseBody public String upload(@RequestParam("path")String request) throws IOException
	{
		/* Iterator<String> itrator = request.getFileNames();
	        MultipartFile multiFile = request.getFile(itrator.next());*/
	                try {
	            // just to show that we have actually received the file
	        /*    System.out.println("File Length:" + multiFile.getBytes().length);
	            System.out.println("File Type:" + multiFile.getContentType());
	            String fileName=multiFile.getOriginalFilename();
	            System.out.println("File Name:" +fileName);*/
	          /*  String path=request.getServletContext().getRealPath("/");*/
	                    
	            //making directories for our required path.
	                	 /*Iterator<String> itrator = request.getFileNames();
	                	 System.out.println(itrator);
	                     MultipartFile multiFile = request.getFile(itrator.next());*/
	                     System.out.println(request);
	                  /*   MultipartFile file=*/
	                     
	                	/* byte[] bytes = file.getBytes();
	                     BufferedOutputStream stream =
	                                   new BufferedOutputStream(new FileOutputStream(new File("/SpringImageUploadDemo/src/main/webapp/resources/Upload_Image/file1.txt")));
	                     stream.write(bytes);
	                     stream.close();
*/	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
//	            throw new Exception("Error while loading the file");
	        }
		
		
	
		return null;
}
}