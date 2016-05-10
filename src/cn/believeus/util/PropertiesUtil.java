package cn.believeus.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtil {
	public static String getValue(String propertiesFile,String key){
		String value="";
		try {
			Properties properties =new Properties();
			//File file=new File(propertiesFile);
			//InputStream in=new FileInputStream(file);
			//properties.load(in);
			properties.load(new FileInputStream(new File(propertiesFile)));
			value=properties.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
		
	}
}
