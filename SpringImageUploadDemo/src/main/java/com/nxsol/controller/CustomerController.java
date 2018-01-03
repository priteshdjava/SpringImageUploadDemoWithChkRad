package com.nxsol.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.nxsol.beans.CustomerBean;
import com.nxsol.model.Customer;
import com.nxsol.services.CustomerServiceImpl;

@Controller
public class CustomerController {

	/*String imageFile=null;*/
	@Autowired
	private CustomerServiceImpl service;

	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String get(@ModelAttribute("form") CustomerBean customerbean) {
		return "customerForm";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@RequestParam("bName") String bName, @RequestParam("bGender") String bGender,
			@RequestParam("bDocument") String[] bDocument, @RequestParam("bAdd") String bAdd,@RequestParam("imageFile")String imageFile) {
		Customer c = new Customer();
		String doc = "";
		for (int i = 0; i < bDocument.length; i++) {
			doc += bDocument[i];
			for (int j = 0; j < (bDocument.length) - 1; j++) {
				doc += ",";
			}
			/* service.save(c); */
		}
		System.out.println("doc is------------------------------------------------------------" + doc);
		c.setcDocument(doc);
		c.setcName(bName);
		c.setcGender(bGender);
		c.setcAdd(bAdd);
		c.setCuploadImage(imageFile);
		service.save(c);
		return "redirect:form";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public String upload(MultipartHttpServletRequest request) throws ServletException, IOException {
		  String  imageFile = null;
		Random rand = new Random();
		int random=rand.nextInt(100000);
		String strRandom=String.valueOf(random);
		String UPLOAD_DIRECTORY = "C:/Users/ADMIN/git/SpringImageUploadDemoWithChkRad/SpringImageUploadDemo/src/main/webapp/resources/Upload_Image";
		Iterator<String> itrator = request.getFileNames();
		MultipartFile multiFile = request.getFile(itrator.next());
		try {
			// just to show that we have actually received the file
			System.out.println("File Length:" + multiFile.getBytes().length);
			System.out.println("File Type:" + multiFile.getContentType());
			String fileName = multiFile.getOriginalFilename();
			/*  length=fileName .length();*/
			int length=fileName.length();
		    int index=fileName.indexOf('.');
		    String subStr=fileName.substring(index, length);
		    String str=fileName.substring(0,index);
		    imageFile= str.concat(strRandom+subStr);
			byte[] bytes = multiFile.getBytes();
			File directory = new File(UPLOAD_DIRECTORY);
			File file = new File(directory.getAbsolutePath() + System.getProperty("file.separator") + imageFile);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return imageFile;
	}

}
