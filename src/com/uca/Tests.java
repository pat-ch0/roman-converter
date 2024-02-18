package com.uca;

import org.junit.jupiter.api.Test;
import java.util.concurrent.Callable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Tests {
	
	@Test
	public void testConverter(){
		assertThat(RomanConverter.getRomanFromNumber(4), equalTo("IV"));
		assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(-2)), instanceOf(IllegalArgumentException.class));
	}
	
	@Test
	public void testInterval(){ //entre 1 et 3999
		assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(0)), instanceOf(IllegalArgumentException.class));
		assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(-1)), instanceOf(IllegalArgumentException.class));
		assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(4000)), instanceOf(IllegalArgumentException.class));
	}
	
	@Test
	public void testRepeatSymbol(){ //limite de symboles à la suite
		assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("CCCC")), instanceOf(IllegalArgumentException.class));
		assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("VV")), instanceOf(IllegalArgumentException.class));
		assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("IIV")), instanceOf(IllegalArgumentException.class));
	}
	
	@Test
	public void testRepeat(){ //pas de répétition de paires
		assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("XVXV")), instanceOf(IllegalArgumentException.class));
		assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("VIVI")), instanceOf(IllegalArgumentException.class));
	}
	
	@Test
	public void testAnt(){ //antécédent incorrect
		assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman(RomanConverter.getRomanFromNumber(-1))), instanceOf(IllegalArgumentException.class));
		assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(RomanConverter.getNumberFromRoman("VIVI"))), instanceOf(IllegalArgumentException.class));
	}
	
	@Test
	public void testAll(){ //tester les 2 méthodes sur tout l'intervalle
		for(int i = 1; i < 4000; i++){
			assertThat(RomanConverter.getNumberFromRoman(RomanConverter.getRomanFromNumber(i)), equalTo(i));
		}
	}


	//Help you to handle exception
	public static Throwable exceptionOf(Callable<?> callable) {
    	try {
    		callable.call();
        	return null;
    	}
    	catch (Throwable t) {
        	return t;
    	}
	}
}
