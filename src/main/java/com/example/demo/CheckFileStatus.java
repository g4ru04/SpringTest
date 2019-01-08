package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.src.main.pojo.RequestObject;
import com.src.main.pojo.ResponseElement;
import com.src.main.pojo.ResponseObject;

@RestController
public class CheckFileStatus {

   @RequestMapping(value="/fileStatus", method=RequestMethod.POST)
   public ResponseObject post_index(Map<String, Object> model,@RequestBody RequestObject requestObject) {
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
		 
		 return responseObject;
		 
	}

}