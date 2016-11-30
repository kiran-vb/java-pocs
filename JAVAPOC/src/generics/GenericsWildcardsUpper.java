package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsWildcardsUpper {
	public static void main(String[] args) {
		List<Double> ints = new ArrayList<>();
		ints.add(3.0); ints.add(6.0); ints.add(6.0);
		double sum = sum(ints);
		System.out.println("Sum of ints="+sum);
	}

	public static double sum(List<? extends Number> list){
		double sum = 0;
		for(Number n : list){
			
			sum += n.doubleValue();
		}
		return sum;
	}
	
	///******* Java Generics Unbounded Wildcard *********/////////////
	
	/*Sometimes we have a situation where we want our generic method to be working with all types, 
	in this case unbounded wildcard can be used.
	Its same as using <? extends Object>.*/
	
	///******* Java Generics Unbounded Wildcard *********/////////////
	
	public static void printData(List<?> list){
		for(Object obj : list){
			System.out.print(obj + "::");
		}
	}
	
	
	////////// LOWER BOUND ///////////////
	
	
	public static void addIntegers(List<? super Number> list){
		list.add(new Integer(50));
		list.add(new Double(3.5));
		//list.a
	}
	
	
	
	public static void addNumbers(List<? extends Number> list){
		//list.a
		
		List<Number> listLong = new ArrayList<>();
		listLong.add(Long.valueOf(10));
		
		List<Long> listLong1 = new ArrayList<>();
		
		//List<Number> listNumbers = listLong1; // compiler error
		//listNumbers.add(Double.valueOf(1.23));
	}
	
	

}


