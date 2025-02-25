package com.comcast.crm.Orggtest;

import org.testng.annotations.Test;

import com.comcast.crm.generic.baseclass.Baseclass;

public class Create_orgtest extends Baseclass {
	
	@Test
	public void createorg() {
		System.out.println("execute create organization and verify ");
	}
	
	@Test
	public void createorgwithindustry() {
		System.out.println("execute create organization with industry and verify");
	}

}
