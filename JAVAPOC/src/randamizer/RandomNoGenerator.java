package randamizer;

import java.util.HashMap;
import java.util.Random;

import prime.PrimeCheck;

public class RandomNoGenerator {
	 static HashMap<Integer,Boolean> map = new HashMap<>();
	public static void main(String[] args) {
		 Random randomGenerator = new Random();
		    for (int idx = 1; idx <= 10; ++idx){
		      int randomInt = randomGenerator.nextInt(100);
		      map = PrimeCheck.check(randomInt);
		      for(Integer in : map.keySet()){
		    	  System.out.println(in + " is Prime Number --->>> " + map.get(in));
		      }
		     
		    }
		    
		  
	}

}
