package com.uca;

public class RomanNumber extends Number implements Comparable<Number>{
	
	private String roman;
	private int value;
	
	public RomanNumber(){
		//Ignored
	}
	
	//méthode principale
	public RomanNumber(String roman){
		this.roman = roman;
		this.value = RomanConverter.getNumberFromRoman(this.roman);
	}
	public RomanNumber(int value){
		this.value = value;
		this.roman = RomanConverter.getRomanFromNumber(this.value);
	}
	public RomanNumber(int value, String roman){
		this.value = value;
		this.roman = roman;
	}
	
	//getter
	public String getRoman(){
		return this.roman;
	}
	public int getValue(){
		return this.value;
	}
	
	//setter
	public void setRoman(String roman){
		this.roman = roman;
		this.value = RomanConverter.getNumberFromRoman(this.roman);
	}
	public void setValue(int value){
		this.value = value;
		this.roman = RomanConverter.getRomanFromNumber(this.value);
	}

	//comparable
	@Override public int compareTo(Number num){
		if (value == num.intValue()){
			return 0;
		}
		else if (value > num.intValue()){
			return 1;
		}
		else{
			return -1;
		}
	}
	
	
	/**
	* @{inheritDoc}
	*/
	@Override
	public double doubleValue() {
		double val = (double) this.value;
		return val;
	}

	/**
	* @{inheritDoc}
	*/
	@Override
	public float floatValue() {
		float val = (float) this.value;
		return val;
	}

	/**
	* @{inheritDoc}
	*/
	@Override
	public int intValue() {
		return this.value; //this.value est déjà de type int
	}

	/**
	* @{inheritDoc}
	*/
	@Override
	public long longValue() {
		long val = (long) this.value;
		return val;
	}

	@Override
	public String toString() {
		String val = String.valueOf(this.value);
		return val;
	}
}