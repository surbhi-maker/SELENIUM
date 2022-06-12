package com.learnautomation.testing;

public class TestingClass {

	String name;

	public TestingClass() {
		name = "selenium session";
	}

	public void showPrice() {
		System.out.println("Price is 200 USD");
	}

	public void showPrice(int noOfStudent) {
		System.out.println("Price for" + noOfStudent + "will be" + 200*noOfStudent +"USD");
	}
	
	private void showAllDetails() {
		System.out.println(" all Details");
	}

}
