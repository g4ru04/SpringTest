package com.example.demo;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Service.UserService;
import com.src.main.pojo.DirPojo;
import com.src.main.pojo.RequestObject;
import com.src.main.pojo.ResponseElement;
import com.src.main.pojo.ResponseObject;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	 @GetMapping("/")
		public String get_index(Map<String, Object> model, @RequestParam(value = "filename", defaultValue = "") String locate) {
		 	
		 String cmd = "sh -c 'ls -al "+locate+"'";
		 	String commandAns = CommonUsage.execCommand(
		 		cmd
		 		//"sh -c 'ls -al "+locate+"'"
		 		//"cmd /c dir ..\\..\\ps_aux.txt 2>&1"
		 		//"cmd /c type ps_aux.txt"
	 		);
		 	System.out.println("exec: 【" + cmd+"】");
			System.out.println(commandAns);
			
			ArrayList<DirPojo> dirAnsList = CommonUsage.parse_dir_ans(commandAns);
			System.out.println("files_amount: " + dirAnsList.size());
			if(dirAnsList.size()>0) {
				System.out.println("last_filename: "+dirAnsList.get(dirAnsList.size()-1).getName());
			}
			System.out.println();
			
			model.put("data", dirAnsList);
			return "table";
		}
	 
	 //@PostMapping("/")
	 	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
	    //@RequestMapping(method=RequestMethod.POST, path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
		public Object post_index(Map<String, Object> model,@RequestBody RequestObject requestObject) {
		 ResponseObject responseObject = new ResponseObject();
		 List<ResponseElement> responseElement = new ArrayList<ResponseElement>();
		 Random ran = new Random();
		 String[] ans_array = {"D","R","N"};
		 
		 for(int i=0;i<requestObject.getFileNameList().size();i++) {
			 ResponseElement element = new ResponseElement();
			 element.setFileName(requestObject.getFileNameList().get(i));
			 element.setFileStatus(ans_array[ran.nextInt(3)]);
			 responseElement.add(element);
		 }
		 responseObject.setStorwiseFileStatus(responseElement);
		 
		 model.put("data", responseObject);
		 return "json";
		 //return responseObject;
		 
	}
}




//model.put("jsonstr", "{\"dsmStatus\":[{\"fileName\":\"A001.jpg\",\"fileStatus\":\"D\"},{\"fileName\":\"A002.jpg\",\"fileStatus\":\"D\"},{\"fileName\":\"A003.jpg\",\"fileStatus\":\"D\"},{\"fileName\":\"A004.jpg\",\"fileStatus\":\"R\"},{\"fileName\":\"A005.jpg\",\"fileStatus\":\"R\"},{\"fileName\":\"A006.jpg\",\"fileStatus\":\"R\"},{\"fileName\":\"A007.jpg\",\"fileStatus\":\"N\"}]}");


//System.out.println("filename");
//System.out.println(requestObject.getFileNameList().size());
//if(requestObject.getFileNameList().size()>0) {
//	 System.out.println(requestObject.getFileNameList().get(0));
//}
/*
String cmd = "sh -c 'ls -al "+locate+"'";
	String commandAns = CommonUsage.execCommand(
		cmd
		//"sh -c 'ls -al "+locate+"'"
		//"cmd /c dir ..\\..\\ps_aux.txt 2>&1"
		//"cmd /c type ps_aux.txt"
	);
	System.out.println("exec: 【" + cmd+"】");
	System.out.println(commandAns);
	
	ArrayList<DirPojo> dirAnsList = CommonUsage.parse_dir_ans(commandAns);
	System.out.println("files_amount: " + dirAnsList.size());
	if(dirAnsList.size()>0) {
		System.out.println("last_filename: "+dirAnsList.get(dirAnsList.size()-1).getName());
	}
	System.out.println();
	
	model.put("data", dirAnsList);
	return "table";
	*/