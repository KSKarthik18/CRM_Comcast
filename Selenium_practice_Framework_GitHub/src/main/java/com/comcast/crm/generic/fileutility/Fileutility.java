package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

public class Fileutility {

	public String getDatafromPropertiesFile(String Key) throws Exception {
		
		FileInputStream fis=new FileInputStream(ipath.cmd_data);
		Properties pobj= new Properties();
		pobj.load(fis);
		String data= pobj.getProperty(Key);		
		return data;	
	}
}
