package cn.believeus.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Main {
	//
	//1024 1
	public static void main(String[] args) throws Exception {
		Properties properties=new Properties();
		//classpath 
		File file = new File("project.properties");
		FileInputStream in=new FileInputStream(file);
		properties.load(in);
		String property = properties.getProperty("username");
		System.out.println(property);
		//in.close();
	}
}
