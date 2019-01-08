package com.example.demo;


import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Service.UserService;
import com.src.main.pojo.DirPojo;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	 @GetMapping("/")
		public String index(Map<String, Object> model, @RequestParam(value = "locate", defaultValue = "") String locate) {
		 	
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

}