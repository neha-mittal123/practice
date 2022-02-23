package com.builderDesignPattern;

public class Computer {
	//required fields
	String Model;
	String Ram;
	
	//non required fields
	String os;
	String keyboard;
	
	//computerBuilder computerBuilder;
	
	private Computer(com.builderDesignPattern.Computer.computerBuilder computerBuilder) {
		this.Model=computerBuilder.getModel();
		this.Ram=computerBuilder.getRam();
		this.os=computerBuilder.getOs();
		this.keyboard=computerBuilder.getKeyboard();
	}



	public static class computerBuilder{
		Computer computer;
		//required fields
		String Model;
		String Ram;
		
		//non required fields
		String os;
		String keyboard;
		
		public String getModel() {
			return Model;
		}


		public String getRam() {
			return Ram;
		}


		public String getOs() {
			return os;
		}


		public String getKeyboard() {
			return keyboard;
		}

		public computerBuilder setOs(String os) {
			this.os = os;
			return this;
		}


		public computerBuilder setKeyboard(String keyboard) {
			this.keyboard = keyboard;
			return this;
		}


		public computerBuilder(String model, String ram) {
			Model = model;
			Ram = ram;
		}
		public Computer build() {
			return new Computer(this);
		}
	}
}
