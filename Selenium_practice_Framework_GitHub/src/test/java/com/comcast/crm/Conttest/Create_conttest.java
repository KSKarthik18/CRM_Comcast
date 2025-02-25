package com.comcast.crm.Conttest;

import org.testng.annotations.Test;

import com.comcast.crm.generic.baseclass.Baseclass;

public class Create_conttest extends Baseclass {

		@Test
		public void createcontact() {
			System.out.println("execute create contact and verify ");
		}
		
		
		@Test
		public void createcontactwithdate() {
			System.out.println("execute create contact with date and verify");
		}
}
