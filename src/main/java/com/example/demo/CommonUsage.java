package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.src.main.pojo.DirPojo;

public class CommonUsage {
	public static ArrayList<DirPojo> parse_dir_ans(String dirAnsStr){
		ArrayList<DirPojo> dirAnsList = new ArrayList<DirPojo>();
		
		String[] lines = dirAnsStr.split("\\n");
		for(int i=1;i<lines.length;i++) {
			
			String[] line = lines[i].split("\\s+");
			if(line.length>8) {
				
				DirPojo element = new DirPojo();
				element.setFilePermission(line[0]);
				element.setFilesAmount(Integer.parseInt(line[1]));
				element.setOwner(line[2]);
				element.setGroup(line[3]);
				element.setSize(line[4]);
				element.setModifiedTime(line[5]+" "+line[6]+" "+line[7]);
				element.setName(line[8]);
				
				dirAnsList.add(element);
			}
		}
		
		
		return dirAnsList;
	}
	
	public static String execCommand(String cmd){
		StringBuffer output = new StringBuffer();
		String ret = "";
		Process p;
		try {
			
			p = Runtime.getRuntime().exec(cmd);
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = "";
			
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
				ret += line + "\n";
			}
			
			if(!p.waitFor(10, TimeUnit.SECONDS)) {
				System.out.println("Command timeout? "+cmd);
			    p.destroy();
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}
}

/*
//p = Runtime.getRuntime().exec("cmd /c chcp 65001 & dir");
//p = Runtime.getRuntime().exec("sh -c 'ls -al'");
//p = Runtime.getRuntime().exec("sh -c \"cat c:/Users/g4ru04/Desktop/a.txt\"");


try {
	Process process = Runtime.getRuntime().exec(
			"cmd /c dir", null, new File("C:\\Users\\g4ru04\\"));
	StringBuilder output = new StringBuilder();

	BufferedReader reader = new BufferedReader(
			new InputStreamReader(process.getInputStream()));

	String line;
	while ((line = reader.readLine()) != null) {
		output.append(line + "\n");
	}

	int exitVal = process.waitFor();
	if (exitVal == 0) {
		System.out.println("Success!");
		System.out.println(output);
		//System.exit(0);
	} else {
		//abnormal...
	}

} catch (IOException e) {
	e.printStackTrace();
} catch (InterruptedException e) {
	e.printStackTrace();
}
*/