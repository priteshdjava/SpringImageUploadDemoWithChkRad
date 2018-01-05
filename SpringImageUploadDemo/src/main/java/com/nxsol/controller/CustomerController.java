package com.nxsol.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

import com.google.gson.Gson;
import com.nxsol.beans.CustomerBean;
import com.nxsol.model.Customer;
import com.nxsol.services.CustomerServiceImpl;

@Controller
public class CustomerController {

	/*String imageFile=null;*/
	@Autowired
	private CustomerServiceImpl service;

	String oldImage=null;
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
				doc += ",";
			
			/* service.save(c); */
		}
		c.setcDocument(doc);
		c.setcName(bName);
		c.setcGender(bGender);
		c.setcAdd(bAdd);
		c.setCuploadImage(imageFile);
		service.save(c);
		return "redirect:form";
	}
	@RequestMapping(value="edit",method=RequestMethod.POST)
	@ResponseBody public String editCustomer(@RequestParam("bId")int bId,@RequestParam("bName") String bName, @RequestParam("bGender") String bGender,
			@RequestParam("bDocument") String[] bDocument, @RequestParam("bAdd") String bAdd,@RequestParam("imageFile")String imageFile)
	{
		String doc1 = "";
		for (int i = 0; i < bDocument.length; i++) {
			doc1 += bDocument[i];
				doc1 += ",";
		}
		Customer cs=new Customer();
		cs.setcName(bName);
		cs.setcGender(bGender);
		cs.setcDocument(doc1);
		cs.setcAdd(bAdd);
		cs.setCuploadImage(imageFile);
		service.updateCutomer(cs, bId);
		return "success";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody public String delete(@RequestParam("bId")int bId)
	{
		service.deleteStudent(bId);
		return "success";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public String upload(MultipartHttpServletRequest request) throws ServletException, IOException {
		  String  imageFile = null;
		Random rand = new Random();
		File oldFile;
		
		int random=rand.nextInt(100000);
		String strRandom=String.valueOf(random);
		String UPLOAD_DIRECTORY = "C:/Users/ADMIN/git/SpringImageUploadDemoWithChkRad/SpringImageUploadDemo/src/main/webapp/resources/Upload_Image";
		Iterator<String> itrator = request.getFileNames();
		MultipartFile multiFile = request.getFile(itrator.next());
		
		/*File directory = new File(UPLOAD_DIRECTORY);*/
		File file;
		try {
			// just to show that we have actually received the file
			/*System.out.println("File Length:" + multiFile.getBytes().length);
			System.out.println("File Type:" + multiFile.getContentType());*/
			String fileName = multiFile.getOriginalFilename();
			/*  length=fileName .length();*/
			
			byte[] bytes = multiFile.getBytes();
			
			
			if(fileName.length()>0)
			{
					 oldFile=new File(UPLOAD_DIRECTORY+"/"+oldImage);
					oldFile.delete();
					System.out.println(oldFile.getName()+ "is deleted");
			}
			if(fileName.equals(""))
			{
				imageFile=oldImage;
			}
			else
			{		
						File directory = new File(UPLOAD_DIRECTORY);
						int length=fileName.length();
					    int index=fileName.indexOf('.');
					    String subStr=fileName.substring(index, length);
					    String str=fileName.substring(0,index);
					    imageFile= str.concat(strRandom+subStr);
					    file = new File(directory.getAbsolutePath() + System.getProperty("file.separator") + imageFile);
						BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
						stream.write(bytes);
						stream.close();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return imageFile;
		
	}
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	@ResponseBody public String view()
	{
		Gson gson = new Gson();
		List<CustomerBean> cutomerlist=prepareBeanList(service.getAllCutomer());
		String jsonstring=gson.toJson(cutomerlist);
		return jsonstring;
	}
	@RequestMapping(value="/get",method=RequestMethod.POST)
	@ResponseBody public String getById(@RequestParam("id")int bId) 
	{
		Gson gson=new Gson();
		CustomerBean bean = new CustomerBean();
		/*Customer cs=new Customer();
		String oldImage=cs.getCuploadImage();*/
		/*System.out.println(oldImage);*/
		/*Iterator<String> itr=oldImage.iterator();
		String str[]=new String[10];
		while(itr.hasNext())
		{
			String str1=itr.next();
			System.out.println(str1);
		}
		System.out.println(oldImage);*/
		Customer customer= service.getById(bId);
		bean.setbId(customer.getcId());
		bean.setbName(customer.getcName());
		bean.setbGender(customer.getcGender());
		bean.setbDocument(customer.getcDocument());
		bean.setbAdd(customer.getcAdd());
		bean.setBuploadImage(customer.getCuploadImage());
		oldImage=customer.getCuploadImage();
		System.out.println(oldImage);
		String jsonInString = gson.toJson(bean);
		return jsonInString;
	}
	
	public List<CustomerBean> prepareBeanList(List<Customer> customers) {
		CustomerBean customer = null;
		List<CustomerBean> beans = new ArrayList<CustomerBean>();
		for (Customer std : customers) {
			customer = new CustomerBean();
			customer.setbId(std.getcId());
			customer.setbName(std.getcName());
			customer.setbGender(std.getcGender());
			customer.setbAdd(std.getcAdd());
			customer.setbDocument(std.getcDocument());
			customer.setBuploadImage(std.getCuploadImage());

			beans.add(customer);
		}
		return beans;
	}

}
