package com.uca;

import java.util.Collection;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RomanConverter{
	
	// Table des symboles
	private static final Collection<RomanNumber> SYMBOLS = new ArrayList<>();
	static {
		SYMBOLS.add(new RomanNumber(1000, "M"));
		SYMBOLS.add(new RomanNumber(900, "CM"));
		SYMBOLS.add(new RomanNumber(500, "D"));
		SYMBOLS.add(new RomanNumber(400, "CD"));
		SYMBOLS.add(new RomanNumber(100, "C"));
		SYMBOLS.add(new RomanNumber(90, "XC"));
		SYMBOLS.add(new RomanNumber(50, "L"));
		SYMBOLS.add(new RomanNumber(40, "XL"));
		SYMBOLS.add(new RomanNumber(10, "X"));
		SYMBOLS.add(new RomanNumber(9, "IX"));
		SYMBOLS.add(new RomanNumber(5, "V"));
		SYMBOLS.add(new RomanNumber(4, "IV"));
		SYMBOLS.add(new RomanNumber(1, "I"));
	  }

	// Expression reguliere de validation
	private static final Pattern VALIDATION_RE = Pattern.compile("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");


	public static String getRomanFromNumber(int a) throws IllegalArgumentException{
		if (a > 3999 || a < 1){ //intervalle invalide
			throw new IllegalArgumentException("The number must be between 1 and 3999");
		}
		else{ //méthode donnée
			String result = "";
			for (RomanNumber rom : SYMBOLS){
				while (a >= rom.getValue()){
					result = result + rom.getRoman();
					a = a - rom.getValue();
				}
			}
			return result;
		}
	}
	
	public static int getNumberFromRoman(String a) throws IllegalArgumentException{
		Matcher m = VALIDATION_RE.matcher(a);
		boolean valid = m.matches(); //vrai si le nombre romain a est valide
		if (valid){ //méthode donnée
			int result = 0, index = 0;
			for (RomanNumber rom : SYMBOLS){
				String romNum = rom.getRoman();
				while (index + romNum.length() <= a.length() && a.substring(index, index + romNum.length()).equals(romNum)){
					result = result + rom.getValue();
					index = index + romNum.length();
				}
			}
			return result;
		}
		else{
			throw new IllegalArgumentException("Invalid roman number");
		}
	}
}